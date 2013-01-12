package org.sythe.suf.message.command.parameter;

/**
 * @author Jacob A. Leach
 *
 */
public class IntegerParameter extends AbstractParameter
{
	private static final String INTEGER_TYPE = "Integer";

	public IntegerParameter()
	{
		super(INTEGER_TYPE);
	}

	/* (non-Javadoc)
	 * @see org.sythe.suf.message.command.argument.IArgument#isValid(java.lang.String)
	 */
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
