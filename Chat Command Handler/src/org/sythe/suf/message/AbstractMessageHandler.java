package org.sythe.suf.message;

import org.sythe.suf.message.command.ICommandManager;

/**
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractMessageHandler implements IMessageHandler
{
	private String commandString;
	private ICommandManager commandManager;

	public AbstractMessageHandler(String commandString, ICommandManager commandManager)
	{
		this.commandString = commandString;
		this.commandManager = commandManager;
	}

	/**
	 * TODO: Write comment
	 * 
	 * @param message
	 * @throws InvalidNameException
	 */
	@Override
	public final void handleMessage(ITextMessage message)
	{
		if (commandString != null && message.getMessageText().startsWith(commandString))
		{
			onCommand(message);
		}
		else
		{
			onMessage(message);
		}
	}

	private final void onCommand(ITextMessage message)
	{
		commandManager.handleCommand(message.getSender(), message.getMessageText().substring(commandString.length()));
	}

	protected final ICommandManager getCommandManager()
	{
		return commandManager;
	}

	/**
	 * @param message
	 */
	public abstract void onMessage(ITextMessage message);
}
