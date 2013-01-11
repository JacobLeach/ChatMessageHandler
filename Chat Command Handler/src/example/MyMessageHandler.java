package example;

import org.sythe.suf.message.*;
import org.sythe.suf.message.command.CommandManager;

public class MyMessageHandler extends AbstractMessageHandler
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

	@Override
	public void onInvalidNameException(String invalidCommand)
	{
		System.out.println("Invalid command: " + invalidCommand);
	}

	@Override
	public void onInvalidArgumentException(String requiredType)
	{
		System.out.println("Invalid Argument: " + requiredType + " required.");
	}

	@Override
	public void onMissingArgumentsException(String message)
	{
		System.out.println(message);
		
	}

}
