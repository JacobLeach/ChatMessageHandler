package org.sythe.suf.message;

import org.sythe.suf.message.command.ICommandManager;
import org.sythe.suf.message.command.InvalidArugmentException;
import org.sythe.suf.message.command.InvalidNameException;
import org.sythe.suf.message.command.MissingArgumentsException;

/**
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractMessageHandler implements IMessageHandler
{
	private String commandString;
	private ICommandManager commandManager;

	public AbstractMessageHandler()
	{
		commandString = null;
	}

	public AbstractMessageHandler(String commandString, ICommandManager commandManager)
	{
		this.commandString = commandString;
		this.commandManager = commandManager;
	}

	/**
	 * @param message
	 * @throws InvalidNameException
	 */
	public final void handleMessage(ITextMessage message)
	{
		if (commandString != null && message.getMessageText().startsWith(commandString))
		{
			try
			{
				onCommand(message);
			}
			catch (InvalidNameException e)
			{
				onInvalidNameException(e.getCommandName());
			}
			catch (InvalidArugmentException e)
			{
				onInvalidArgumentException(e.getRequiredType());
			}
			catch (MissingArgumentsException e)
			{
				onMissingArgumentsException(e.getMessage());
			}
		}
		else
		{
			onMessage(message);
		}
	}

	/**
	 * @param message
	 * @throws InvalidNameException
	 * @throws InvalidArugmentException
	 * @throws MissingArgumentsException
	 */
	private final void onCommand(ITextMessage message) throws InvalidNameException, InvalidArugmentException, MissingArgumentsException
	{
		commandManager.executeCommand(message.getSender(), message.getMessageText().substring(commandString.length()));
	}

	protected final ICommandManager getCommandManager()
	{
		return commandManager;
	}

	/**
	 * @param message
	 */
	public abstract void onMessage(ITextMessage message);

	public abstract void onInvalidNameException(String invalidCommand);

	public abstract void onInvalidArgumentException(String requiredType);
	
	public abstract void onMissingArgumentsException(String message);
}
