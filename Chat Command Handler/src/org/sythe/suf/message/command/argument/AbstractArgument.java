package org.sythe.suf.message.command.argument;

/**
 * @author Jacob A. Leach
 *
 */
public abstract class AbstractArgument implements IArgument
{
	private final String type;
	
	/**
	 * @param type the string representation of the type of argument
	 */
	public AbstractArgument(String type)
	{
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see org.sythe.suf.message.command.argument.IArgument#getType()
	 */
	@Override
	public final String getType()
	{
		return type;
	}
}
