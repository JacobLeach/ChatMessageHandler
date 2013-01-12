package org.sythe.suf.message.command;

import java.util.HashMap;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.error.ErrorHandler;
import org.sythe.suf.message.command.error.IErrorHandler;

/**
 * TODO: Implement error handling within this class
 * 
 * @author Jacob A. Leach
 * @version 1.0
 * @since 1.0
 */
public class CommandManager implements ICommandManager
{
	private HashMap<String, ICommand> iCommands = new HashMap<String, ICommand>();
	private IErrorHandler errorHandler;

	public CommandManager()
	{
		this(new ErrorHandler());
	}
	
	public CommandManager(IErrorHandler errorHandler)
	{
		this.errorHandler = errorHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommandManager#addCommand(java.lang.String,
	 * org.sythe.suf.message.command.ICommand)
	 */
	@Override
	public final boolean addCommand(String commandName, ICommand iCommand)
	{
		boolean replaced = iCommands.containsKey(commandName);
		iCommands.put(commandName, iCommand);

		return replaced;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommandManager#executeCommand(org.sythe.suf.message.ISender,
	 * java.lang.String)
	 */
	@Override
	public final void handleCommand(ISender sender, String commandString)
	{
		String[] words = commandString.split("[ ]");
		String commandName = words[0].toLowerCase();
		String[] arguments = new String[words.length - 1];

		// Copy the arguments over and leave the command name out
		System.arraycopy(words, 1, arguments, 0, arguments.length);

		// Don't need words anymore so get rid of it
		words = null;

		if (iCommands.containsKey(commandName))
		{
			ICommand command = iCommands.get(commandName);
			if (command.checkPermission(sender))
			{
				if (command.checkArgumentNumber(arguments.length))
				{
					/*
					 * Check all the arugments to make sure they are the correct type.
					 * Compare i to both args.length and arguments.length because of optional arguments and not checking
					 * for too many arguments.
					 */
					for (int i = 0; (i < arguments.length) && (i < command.getTotalParameters()); i++)
					{
						String value = command.checkParameterTypes(arguments[i], i);
						if (value != null)
						{
							errorHandler.onParameterTypeError(sender, arguments[i], value);
							// Must return to not run the command after
							return;
						}
					}

					command.run(sender, arguments);
				}
				else
				{
					errorHandler.onParameterNumberError(sender, arguments.length, command.getRequiredParameters());
				}
			}
			else
			{
				errorHandler.onPermissionError(sender, sender.getPermission(), command.getPermission());
			}
		}
		else
		{
			errorHandler.onNameError(sender, commandName);
		}
	}
}
