package org.sythe.suf.message.command.argument;

/**
 * @author Jacob A. Leach
 */
public interface IArgument
{
	/**
	 * Returns true if the string passed in is a valid argument. Returns false otherwise.
	 * 
	 * @param argument the argument to be checked for validity
	 * @return true if the argument is valid, false if it is invalid
	 */
	public boolean isValid(String argument);
	
	/**
	 * Returns the String representation of the type of argument this is
	 * 
	 * @return the String representation of the type of argument this is
	 */
	public String getType();
}
