package example;

import org.sythe.suf.message.*;

/**
 * @author Jacob A. Leach
 *
 */
public class Message implements ITextMessage
{
	private String messageText;
	private Player player;

	public Message(Player player, String messageText)
	{
		this.player = player;
		this.messageText = messageText;
	}
	
	@Override
	public String getMessageText()
	{
		return messageText;
	}

	public Player getPlayer()
	{
		return player;
	}
	
	@Override
	public ISender getSender()
	{
		return player;
	}
}
