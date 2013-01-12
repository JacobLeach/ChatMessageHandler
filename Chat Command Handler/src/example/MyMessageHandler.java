package example;

import org.sythe.suf.message.*;
import org.sythe.suf.message.command.CommandManager;

/**
 * TODO: CURRENTLY BROKEN. Fix
 * 
 * @author Jacob A. Leach
 *
 */
public class MyMessageHandler extends AbstractCommandMessageHandler
{
	public MyMessageHandler()
	{
		super("/", new CommandManager());
		getCommandManager().addCommand("mycommand", new MyCommand());
		getCommandManager().addCommand("perm", new MyIntCommand());
	}
	
	public void onMessage(ITextMessage message)
	{
		if(message instanceof MyMessage)
		{
			MyMessage temp = (MyMessage) message;
			System.out.println(temp.getPlayer().getName() + ": " + temp.getMessageText());
		}
	}
}
