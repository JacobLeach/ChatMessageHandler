package org.sythe.suf.message;

/**
 * @author Jacob A. Leach
 *
 */
public abstract class AbstractMessageHandler implements IMessageHandler
{
	@Override
	public void handleMessage(ITextMessage message)
	{
		onMessage(message);
	}
	
	protected abstract void onMessage(ITextMessage message);
}
