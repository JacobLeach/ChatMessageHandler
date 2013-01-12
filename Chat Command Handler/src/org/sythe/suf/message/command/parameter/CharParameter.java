package org.sythe.suf.message.command.parameter;

public class CharParameter extends AbstractParameter
{
	private static final String CHARACTER_TYPE = "Character";
	
	public CharParameter()
	{
		super(CHARACTER_TYPE);
	}

	@Override
	public boolean isValid(String argument)
	{
		return (argument.length() == 1);
	}	
}
