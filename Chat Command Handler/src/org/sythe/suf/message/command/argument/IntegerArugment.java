package org.sythe.suf.message.command.argument;

public class IntegerArugment extends AbstractArgument
{
	private static final String INTEGER_TYPE = "Integer";

	public IntegerArugment()
	{
		super(INTEGER_TYPE);
	}

	@Override
	public boolean isValid(String argument)
	{
		/*
		 * I am aware that using Exceptions for checking like this is frowned upon.
		 * However, this is guaranteed to work and performance shouldn't be an issue.
		 * Other methods could introduce bugs so I am simply choosing this method.
		 */
		try
		{
			Integer.parseInt(argument);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}

}
