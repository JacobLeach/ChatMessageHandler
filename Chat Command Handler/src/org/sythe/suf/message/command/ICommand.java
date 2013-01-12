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
	 * @param argumentNumber the number of arguments to check
	 * @return true if there is no problems with the argument number, false if there is
	 */
	public boolean checkArgumentNumber(int argumentNumber);

	/**
	 * @param args the arguments to check
	 * @return null if there is no errors with the parameters or the type of argument required as a String if there is
	 *         an error
	 */
	public String checkParameterTypes(String[] args);

	/**
	 * @param sender
	 *            the sender of the command
	 * @return true if the sender has permission to use the command and false if the sender does not have permission to
	 *         use the command
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
