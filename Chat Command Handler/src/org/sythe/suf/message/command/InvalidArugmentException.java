package org.sythe.suf.message.command;

/**
 * Signals that an invalid argument has been passed
 * 
 * @author Jacob A. Leach
 *
 */
public class InvalidArugmentException extends Exception
{
	private final String requiredType;
	
	public InvalidArugmentException(String message, String requiredType)
	{
		super(message);
		this.requiredType = requiredType;
	}
	
	public String getRequiredType()
	{
		return requiredType;
	}
}
