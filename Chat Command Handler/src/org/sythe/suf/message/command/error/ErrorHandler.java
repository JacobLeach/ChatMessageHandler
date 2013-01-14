package org.sythe.suf.message.command.error;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.permission.IPermission;

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
		sender.sendMessage("Name error");
	}

	@Override
	public void onParameterNumberError(ISender sender, int numberGiven, int numberRequired)
	{
		sender.sendMessage("Parameter Number Error");
	}

	@Override
	public void onParameterTypeError(ISender sender, String parameterGiven, String requiredType)
	{
		sender.sendMessage("Type Error");
	}

	@Override
	public void onPermissionError(ISender sender, IPermission senderPermission, IPermission commandPermission)
	{
		sender.sendMessage("Permission Error");
	}

}
