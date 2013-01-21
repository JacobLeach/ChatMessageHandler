package example;

import org.sythe.suf.message.ChatListener;
import org.sythe.suf.message.ITextMessage;
import org.sythe.suf.message.MessageManager;

public class Example
{
	public static void main(String[] args)
	{
		MessageManager manager = new MessageManager();
		manager.getCommandManager().addCommand("mycommand", new Command());
		manager.getCommandManager().addCommand("perm", new IntCommand());
		manager.getServiceManager().addTask("logger", new ChatLogger());

		manager.addChatListener(new ChatListener()
		{
			@Override
			public void onChat(ITextMessage message)
			{
				Player p = (Player) message.getSender();
				System.out.println(p.getName() + ": " + message.getMessageText());
			}
		});
		Player player = new Player("Jacob", 10);
		manager.handleMessage(new Message(player, "Hey this is a simulation of me saying something."));
		manager.handleMessage(new Message(player, "/mycommand Test"));
		manager.handleMessage(new Message(player, "Hey this is a simulation of me saying something again!"));
		manager.handleMessage(new Message(player, "/perm Test"));
		manager.handleMessage(new Message(player, "/perm 3"));

	}
}
