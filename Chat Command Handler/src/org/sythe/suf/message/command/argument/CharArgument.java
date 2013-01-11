package org.sythe.suf.message.command.argument;

public class CharArgument extends AbstractArgument
{
	private static final String CHARACTER_TYPE = "Character";
	
	public CharArgument()
	{
		super(CHARACTER_TYPE);
	}

	@Override
	public boolean isValid(String argument)
	{
		return (argument.length() == 1);
	}	
}
