package org.sythe.suf.message.command.parameter;

public class StringParameter extends AbstractParameter
{
	private static final String STRING_TYPE = "String";

	public StringParameter()
	{
		super(STRING_TYPE);
	}

	@Override
	public boolean isValid(String argument)
	{
		return true;
	}
}
