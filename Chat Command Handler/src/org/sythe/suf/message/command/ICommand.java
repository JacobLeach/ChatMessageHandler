package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;

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
	 */
	public void execute(ISender iSender, String[] args) throws InvalidArugmentException;
}
