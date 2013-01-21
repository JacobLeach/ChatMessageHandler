package example.ircbot;

import org.jibble.pircbot.PircBot;

public class IRCBot extends PircBot
{
	private static final String server = "";
	private static final String channel = "";
	private static final String name = "";

	public IRCBot()
	{

	}

	public void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		
	}

	public static void main(String[] args)
	{
		IRCBot bot = new IRCBot();
		bot.setVerbose(false);

		try
		{
			bot.connect(server);
			bot.identify(name);
			bot.joinChannel(channel);
		}
		catch (Exception e)
		{
			
		}
	}
}
