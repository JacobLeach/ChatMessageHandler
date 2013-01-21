package org.sythe.suf.message.command.error;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.permission.IPermission;

/**
 * TODO: Fix this implementation
 * 
 * @author Jacob A. Leach
 * 
 */
public class ErrorHandler implements IErrorHandler
{

	@Override
	public void onNameError(ISender sender, String nameGiven)
	{
		sender.sendMessage("Command name: " + nameGiven + " does not exist");
	}

	@Override
	public void onParameterNumberError(ISender sender, int numberGiven, int numberRequired)
	{
		sender.sendMessage("Parameter Number incorrect: " + numberGiven + " given, " + numberRequired + " required.");
	}

	@Override
	public void onParameterTypeError(ISender sender, String parameterGiven, String requiredType)
	{
		sender.sendMessage("Type Error: " + parameterGiven + " given, " + requiredType + " required.");
	}

	@Override
	public void onPermissionError(ISender sender, IPermission senderPermission, IPermission commandPermission)
	{
		sender.sendMessage("You do not have enough permission to use that command.");
	}

}
