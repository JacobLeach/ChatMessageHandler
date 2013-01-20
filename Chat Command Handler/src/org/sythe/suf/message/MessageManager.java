package org.sythe.suf.message;

import org.sythe.suf.message.command.CommandManager;
import org.sythe.suf.message.service.ServiceManager;

public class MessageManager extends AbstractMessageManager
{
	public static final String DEFAULT_COMMAND_STRING = "/";

	public MessageManager()
	{
		this(DEFAULT_COMMAND_STRING);
	}

	public MessageManager(String commandString)
	{
		this(commandString, new CommandManager(), new ServiceManager());
	}

	public MessageManager(String commandString, CommandManager commandManager, ServiceManager taskManager)
	{
		super(commandString, commandManager, taskManager);
	}

	@Override
	public void onMessage(ITextMessage message)
	{
		
	}

	@Override
	public CommandManager getCommandManager()
	{
		return (CommandManager) super.getCommandManager();
	}
	
	@Override
	public ServiceManager getTaskManager()
	{
		return (ServiceManager) super.getTaskManager();
	}
}
