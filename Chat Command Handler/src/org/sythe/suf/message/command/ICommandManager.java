package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;

/**
 * @author Jacob A. Leach
 *
 */
public interface ICommandManager
{
	
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
	public boolean addCommand(String commandName, ICommand iCommand);
	
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
	 * @throws MissingArgumentsException 
	 */
	public void executeCommand(ISender iSender, String command) throws InvalidNameException, InvalidArugmentException, MissingArgumentsException;
}
