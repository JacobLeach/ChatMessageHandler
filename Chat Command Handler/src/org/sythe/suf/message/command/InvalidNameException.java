package org.sythe.suf.message.command;

public class InvalidNameException extends Exception
{
	private final String commandName;
	
	public InvalidNameException(String message, String commandName)
	{
		super(message);
		this.commandName = commandName;
	}
	
	public String getCommandName()
	{
		return commandName;
	}
}
