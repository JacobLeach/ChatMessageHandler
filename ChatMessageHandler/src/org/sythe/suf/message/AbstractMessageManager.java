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
	private IServiceManager serviceManager;

	public AbstractMessageManager(String commandString, ICommandManager commandManager, IServiceManager serviceManager)
	{
		this.commandString = commandString;
		this.commandManager = commandManager;
		this.serviceManager = serviceManager;
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

		runServices(message);
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
	public IServiceManager getServiceManager()
	{
		return serviceManager;
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
	public boolean setServiceManager(IServiceManager manager)
	{
		if (manager != null)
		{
			serviceManager = manager;
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
	
	private final void runServices(ITextMessage message)
	{
		serviceManager.runTasks(message);
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
