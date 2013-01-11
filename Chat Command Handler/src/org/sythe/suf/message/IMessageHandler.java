package org.sythe.suf.message;

/**
 * @author Jacob A. Leach
 *
 */
public interface IMessageHandler
{
	/**
	 * @param message
	 */
	public void handleMessage(ITextMessage message);
}
