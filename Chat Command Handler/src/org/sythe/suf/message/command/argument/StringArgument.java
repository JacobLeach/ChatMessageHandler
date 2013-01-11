package org.sythe.suf.message.command.argument;

public class StringArgument extends AbstractArgument
{
	private static final String STRING_TYPE = "String";

	public StringArgument()
	{
		super(STRING_TYPE);
	}

	@Override
	public boolean isValid(String argument)
	{
		return true;
	}
}
