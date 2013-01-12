package org.sythe.suf.message;

public abstract class AbstractMessageHandler implements IMessageHandler
{
	@Override
	public void handleMessage(ITextMessage message)
	{
		onMessage(message);
	}
	
	protected abstract void onMessage(ITextMessage message);
}
