package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.argument.InvalidArugmentException;
import org.sythe.suf.message.command.argument.MissingArgumentsException;

/**
 * @author Jacob A. Leach
 *
 */
public interface ICommand
{
	/**
	 * @param iSender
	 * @param args
	 * @return
	 * @throws MissingArgumentsException 
	 */
	public void execute(ISender iSender, String[] args) throws InvalidArugmentException, MissingArgumentsException;
}
