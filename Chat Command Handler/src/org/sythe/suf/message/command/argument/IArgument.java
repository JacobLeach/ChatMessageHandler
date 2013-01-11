package org.sythe.suf.message.command.argument;


/**
 * @author Jacob A. Leach
 */
public interface IArgument
{
	/**
	 * @param argument
	 * @return
	 * @throws InvalidArugmentException
	 */
	public boolean isValid(String argument);
	
	/**
	 * @return
	 */
	public String getType();
}
