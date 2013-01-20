package org.sythe.suf.message.command.parameter;

/**
 * @author Jacob A. Leach
 *
 */
public abstract class AbstractParameter implements IParameter
{
	private final String type;
	
	/**
	 * @param type the string representation of the type of argument
	 */
	public AbstractParameter(String type)
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
