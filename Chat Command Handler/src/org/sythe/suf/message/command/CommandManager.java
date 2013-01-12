package org.sythe.suf.message.command;

import java.util.HashMap;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.error.IErrorHandler;

/**
 * @author Jacob A. Leach
 * @version 1.0
 * @since 1.0
 */
public class CommandManager implements ICommandManager
{
	private HashMap<String, ICommand> iCommands = new HashMap<String, ICommand>();
	private IErrorHandler errorHandler;

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
	 * This method is patched together at the moment.
	 * TODO: Rewrite method without it being crap
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommandManager#executeCommand(org.sythe.suf.message.ISender,
	 * java.lang.String)
	 */
	@Override
	public final void handleCommand(ISender iSender, String command)
	{
		String commandName;

		if (command.indexOf(' ') > -1)
		{
			// The command name is the first word of the String
			commandName = command.substring(0, command.indexOf(' '));
		}
		else
		{
			// There are no spaces so the entire command is the commandName
			commandName = command;
			commandName = commandName.toLowerCase();
			if (!iCommands.containsKey(commandName))
			{
				
			}
			iCommands.get(commandName).run(iSender, new String[0]);
			return;
		}

		commandName = commandName.toLowerCase();

		if (!iCommands.containsKey(commandName))
		{
			
		}
		else
		{
			String[] args = command.substring(command.indexOf(' ') + 1).split("[ ]");
			iCommands.get(commandName).run(iSender, args);
		}
	}
}
