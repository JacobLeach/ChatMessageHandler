package org.sythe.suf.message.command;
import java.util.HashMap;

import org.sythe.suf.message.ISender;


/**
 * @author Jacob A. Leach
 * @version 1.0
 * @since	1.0
 */
public class CommandManager implements ICommandManager
{
	private HashMap<String, ICommand> iCommands = new HashMap<String, ICommand>();

	/**
	 * Adds a command to the CommandManager. Will replace a command with the same name and will
	 * return true. Will return false if there is not a command with the same name.
	 * 
	 * @param commandName
	 *            the name of the command
	 * @param iCommand
	 *            the command object
	 * @return true if a command of commandName already existed and was replaced and false otherwise
	 */
	public final boolean addCommand(String commandName, ICommand iCommand)
	{
		boolean replaced = iCommands.containsKey(commandName);
		iCommands.put(commandName, iCommand);

		return replaced;
	}

	/**
	 * Parses and executes a command. The command should come in as a String with the command name
	 * first, follow by the optional arugments with all seperated by spaces.
	 * 
	 * @param iSender
	 *            The sender of the command
	 * @param command
	 *            The unparsed command string with the command name and optional arugments
	 *            seperted with spaces
	 * @return an object (or null) that the command returns when finished executing
	 * @throws InvalidNameException
	 *             If there is no command of the name given (through the full command string)
	 * @throws InvalidArugmentException 
	 */
	public final void executeCommand(ISender iSender, String command) throws InvalidNameException, InvalidArugmentException
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
		}

		commandName = commandName.toLowerCase();

		if (!iCommands.containsKey(commandName))
		{
			throw new InvalidNameException("There is no command named \"" + commandName + "\".", commandName);
		}
		else
		{
			String[] args = command.substring(0, command.indexOf(' ')).split("[ ]");
			iCommands.get(commandName).execute(iSender, args);
		}
	}
}
