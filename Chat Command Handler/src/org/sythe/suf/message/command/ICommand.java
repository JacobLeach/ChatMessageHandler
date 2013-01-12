package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.error.IErrorHandler;

/**
 * @author Jacob A. Leach
 * 
 */
public interface ICommand
{
	/**
	 * @param sender
	 * @param args
	 * @return
	 */
	public void run(ISender sender, String[] args);

	/**
	 * @param args
	 */
	public boolean checkArgumentNumber(int argumentNumber);

	/**
	 * @param args
	 */
	public String checkArgumentTypes(String[] args);

	/**
	 * @param permission
	 */
	public boolean checkPermission(ISender sender);

	/**
	 * Returns the ErrorHandler used by this command or null if one is not set. If one is not set, the CommandManager
	 * uses its ErrorManager to handle the error.
	 * 
	 * @return the ErrorHandler used by this command or null if it does not have one
	 */
	public IErrorHandler getErrorHandler();
}
