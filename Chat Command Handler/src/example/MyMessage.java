package example;

import org.sythe.suf.message.*;

/**
 * TODO: CURRENTLY BROKEN. Fix
 * 
 * @author Jacob A. Leach
 *
 */
public class MyMessage implements ITextMessage
{
	private String messageText;
	private MyPlayer myPlayer;

	public MyMessage(MyPlayer myPlayer, String messageText)
	{
		this.myPlayer = myPlayer;
		this.messageText = messageText;
	}
	
	@Override
	public String getMessageText()
	{
		return messageText;
	}

	public MyPlayer getPlayer()
	{
		return myPlayer;
	}
	
	@Override
	public ISender getSender()
	{
		return myPlayer;
	}
}
