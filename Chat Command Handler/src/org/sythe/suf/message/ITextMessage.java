package org.sythe.suf.message;

/**
 * @author Jacob A. Leach
 *
 */
public interface ITextMessage
{
	/**
	 * @return
	 */
	public String getMessageText();
	
	/**
	 * @return
	 */
	public ISender getSender();
}
