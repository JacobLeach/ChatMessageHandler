package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;

public interface ICommandManager
{
	public boolean addCommand(String commandName, ICommand iCommand);
	public void executeCommand(ISender iSender, String command) throws InvalidNameException, InvalidArugmentException;
}
