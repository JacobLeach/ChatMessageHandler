package org.sythe.suf.message.command.argument;

public abstract class AbstractArgument implements IArgument
{
	private final String type;
	
	public AbstractArgument(String type)
	{
		this.type = type;
	}
	
	@Override
	public final String getType()
	{
		return type;
	}
}
