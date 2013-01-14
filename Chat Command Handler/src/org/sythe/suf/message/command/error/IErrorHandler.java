package org.sythe.suf.message.command.error;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.permission.IPermission;

/**
 * TODO: Add a method for empty commands: IE ""
 * 
 * @author Jacob A. Leach
 * 
 */
public interface IErrorHandler
{
	/**
	 * TODO: Fix comment
	 * 
	 * Called when a command by the name given does not exist. Should not be called by a command as it does not make
	 * sense and if IErrorHandler will be used only within a command this method does not need to do anything.
	 * 
	 * @param nameGiven the name of the command given
	 */
	public void onNameError(ISender sender, String nameGiven);

	/**
	 * TODO: Fix comment
	 * 
	 * Called when there is a problem with the number of parameters passed to the command.
	 * 
	 * @param numberGiven
	 *            the number of parameters sent to the command
	 * @param numberRequired
	 *            the number of parameters required by the command
	 */
	public void onParameterNumberError(ISender sender, int numberGiven, int numberRequired);

	/**
	 * TODO: Fix comment
	 * 
	 * Called when a parameter of the wrong type is passed.
	 * 
	 * @param parameterGiven
	 *            the parameter that was passed to the command
	 * @param requiredType
	 *            the type of parameter required
	 */
	public void onParameterTypeError(ISender sender, String parameterGiven, String requiredType);

	/**
	 * TODO: Fix comment
	 * 
	 * Called when there is a problem with the permissions of the sender and command.
	 * 
	 * This will generally be when the sender has the wrong permission for the command.
	 * 
	 * @param senderPermission
	 *            the permission of the sender
	 * @param commandPermission
	 *            the permission required by the command
	 */
	public void onPermissionError(ISender sender, IPermission senderPermission, IPermission commandPermission);
}
