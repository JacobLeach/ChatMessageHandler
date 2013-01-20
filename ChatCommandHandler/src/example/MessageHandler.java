package example;

import org.sythe.suf.message.*;
import org.sythe.suf.message.command.CommandManager;

/**
 * @author Jacob A. Leach
 *
 */
public class MessageHandler extends AbstractMessageManager
{
	public MessageHandler()
	{
		super("/", new CommandManager(), null);
		getCommandManager().addCommand("mycommand", new Command());
		getCommandManager().addCommand("perm", new IntCommand());
	}
	
	public void onMessage(ITextMessage message)
	{
		if(message instanceof Message)
		{
			Message temp = (Message) message;
			System.out.println(temp.getPlayer().getName() + ": " + temp.getMessageText());
		}
	}
}
