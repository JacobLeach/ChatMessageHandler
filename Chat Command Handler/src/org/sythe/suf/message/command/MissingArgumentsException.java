package org.sythe.suf.message.command;

public class MissingArgumentsException extends Exception
{
	//TODO: Make it accept what arguments are needed and give a way of getting that as a string
	public MissingArgumentsException(String message)
	{
		super(message);
	}
}
