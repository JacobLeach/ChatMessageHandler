package org.sythe.suf.message;

import org.sythe.suf.message.command.ICommandManager;
import org.sythe.suf.message.service.IServiceManager;

/**
 * TODO: Write comment
 * 
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractMessageManager implements IMessageManager
{
	private String commandString;
	private boolean alwaysHandleMessage = false;

	private ICommandManager commandManager;
	private IServiceManager taskManager;

	public AbstractMessageManager(String commandString, ICommandManager commandManager, IServiceManager taskManager)
	{
		this.commandString = commandString;
		this.commandManager = commandManager;
		this.taskManager = taskManager;
	}

	/*
	 * ************************************** IMessageManager Interface Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @param message
	 * @throws InvalidNameException
	 */
	@Override
	public final void handleMessage(ITextMessage message)
	{
		//TODO: Allow for command and task managers to be null
		if (isCommand(message))
		{
			onCommand(message);
		}

		if (alwaysHandleMessage || !isCommand(message))
		{
			onMessage(message);
		}

		runTasks(message);
	}

	/*
	 * ************************************** Getter Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public ICommandManager getCommandManager()
	{
		return commandManager;
	}

	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public IServiceManager getTaskManager()
	{
		return taskManager;
	}

	/*
	 * ************************************** Setter Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @param manager
	 * @return
	 */
	public boolean setCommandManager(ICommandManager manager)
	{
		if (manager != null)
		{
			commandManager = manager;
			return true;
		}

		return false;
	}

	/**
	 * TODO: Write comment
	 * 
	 * @param manager
	 * @return
	 */
	public boolean setTaskManager(IServiceManager manager)
	{
		if (manager != null)
		{
			taskManager = manager;
			return true;
		}

		return false;
	}

	/*
	 * ************************************** Public Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @param message
	 * @return
	 */
	public boolean isCommand(ITextMessage message)
	{
		return commandString != null && message.getMessageText().startsWith(commandString);
	}

	/**
	 * TODO: Write comment
	 * 
	 * @param arg
	 */
	public void alwaysHandleMessage(boolean arg)
	{
		alwaysHandleMessage = arg;
	}

	/*
	 * ************************************** Private Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @param message
	 */
	private final void onCommand(ITextMessage message)
	{
		commandManager.handleCommand(message.getSender(), message.getMessageText().substring(commandString.length()));
	}
	
	private final void runTasks(ITextMessage message)
	{
		taskManager.runTasks(message);
	}

	/*
	 * ************************************** Abstract Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @param message
	 */
	public abstract void onMessage(ITextMessage message);
}
