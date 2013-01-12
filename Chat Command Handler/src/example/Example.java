package example;

public class Example
{
	public static void main(String[] args)
	{
		MyMessageHandler handler = new MyMessageHandler();
		MyPlayer player = new MyPlayer("Jacob", 10);
		handler.handleMessage(new MyMessage(player, "Hey this is a simulation of me saying something."));
		handler.handleMessage(new MyMessage(player, "/mycommand Test"));
		handler.handleMessage(new MyMessage(player, "Hey this is a simulation of me saying something again!"));
		handler.handleMessage(new MyMessage(player, "/perm Test"));
		handler.handleMessage(new MyMessage(player, "/perm 3"));
		
	}
}
