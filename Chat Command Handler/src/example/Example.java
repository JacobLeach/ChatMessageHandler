package example;

public class Example
{
	public static void main(String[] args)
	{
		MessageHandler handler = new MessageHandler();
		Player player = new Player("Jacob", 10);
		handler.handleMessage(new Message(player, "Hey this is a simulation of me saying something."));
		handler.handleMessage(new Message(player, "/mycommand Test"));
		handler.handleMessage(new Message(player, "Hey this is a simulation of me saying something again!"));
		handler.handleMessage(new Message(player, "/perm Test"));
		handler.handleMessage(new Message(player, "/perm 3"));
		
	}
}
