package org.sythe.suf.message;

import java.util.ArrayList;

import org.sythe.suf.message.command.CommandManager;
import org.sythe.suf.message.command.ICommandManager;
import org.sythe.suf.message.service.IServiceManager;
import org.sythe.suf.message.service.ServiceManager;

public class MessageManager extends AbstractMessageManager
{
	public static final String DEFAULT_COMMAND_STRING = "/";

	private ArrayList<ChatListener> listeners;

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

	/**
	 * TODO: Write comment
	 * 
	 * @param listener
	 */
	public void addChatListener(ChatListener listener)
	{
		if (listeners == null)
		{
			listeners = new ArrayList<ChatListener>();
		}

		if (!listeners.contains(listener))
		{
			listeners.add(listener);
		}
	}

	/**
	 * TODO: Write comment
	 * 
	 * @param listener
	 */
	public void removeChatListener(ChatListener listener)
	{
		if (listeners != null && listeners.contains(listener))
		{
			listeners.remove(listener);

			if (listeners.size() == 0)
			{
				listeners = null;
			}
		}
	}

	/**
	 * TODO: Write comment.
	 * 
	 * @see org.sythe.suf.message.AbstractMessageManager#onMessage(org.sythe.suf.message.ITextMessage)
	 */
	@Override
	public void onMessage(ITextMessage message)
	{
		for (ChatListener c : listeners)
		{
			if (listeners != null)
			{
				c.onChat(message);
			}
		}
	}

	/**
	 * TODO: Write comment
	 * 
	 * @see org.sythe.suf.message.AbstractMessageManager#getCommandManager()
	 */
	@Override
	public CommandManager getCommandManager()
	{
		return (CommandManager) super.getCommandManager();
	}

	/**
	 * TODO: Write comment
	 * 
	 * @see org.sythe.suf.message.AbstractMessageManager#getTaskManager()
	 */
	@Override
	public ServiceManager getServiceManager()
	{
		return (ServiceManager) super.getServiceManager();
	}

	/**
	 * TODO: Write comment
	 * 
	 * @see org.sythe.suf.message.AbstractMessageManager#setCommandManager(org.sythe.suf.message.command.ICommandManager)
	 */
	public boolean setCommandManager(ICommandManager manager)
	{
		if (manager instanceof CommandManager)
		{
			super.setCommandManager(manager);
			return true;
		}
		return false;
	}

	/**
	 * TODO: Write comment
	 * 
	 * @see org.sythe.suf.message.AbstractMessageManager#setServiceManager(org.sythe.suf.message.service.IServiceManager)
	 */
	public boolean setServiceManager(IServiceManager manager)
	{
		if (manager instanceof ServiceManager)
		{
			super.setServiceManager(manager);
			return true;
		}

		return false;
	}
}
