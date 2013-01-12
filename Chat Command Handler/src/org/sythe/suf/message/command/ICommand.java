package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.error.IErrorHandler;
import org.sythe.suf.message.command.permission.IPermission;

/**
 * @author Jacob A. Leach
 * 
 */
public interface ICommand
{
	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public int getTotalParameters();
	
	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public int getRequiredParameters();
	
	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public IPermission getPermission();
	
	/**
	 * TODO: Write comment
	 * 
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
	 * @param args the argument to check
	 * @return null if there is no error with the parameter or the type of argument required as a String if there is
	 *         an error
	 */
	public String checkParameterTypes(String args, int position);

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
