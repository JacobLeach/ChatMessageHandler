package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.error.IErrorHandler;
import org.sythe.suf.message.command.parameter.IParameter;
import org.sythe.suf.message.command.permission.IPermission;

/**
 * NOTE: This class is "dumb". It does not do any checking of the permissions / parameters. It is assumed that this is
 * done BEFORE the command is told to run, most likely by the CommandManager.
 * 
 * NOTE: This implementation implements permissions, required and optional arguments, and argument types.
 * 
 * NOTE: This implementation allows for permissions to be changed but not parameters or requiredArguments.
 * 
 * NOTE: This implementation ignores extra parameters and does not error if it is given too many.
 * 
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractCommand implements ICommand
{
	private IPermission permission;

	private final int requiredParameters;
	private final IParameter[] parameters;

	public static final int DEFAULT_REQUIRED_ARGUMENTS = 0;
	public static final int DEFAULT_TOTAL_ARGUMENTS = 0;

	public AbstractCommand(IPermission permission)
	{
		this(permission, DEFAULT_REQUIRED_ARGUMENTS, new IParameter[DEFAULT_TOTAL_ARGUMENTS]);
	}

	/**
	 * @param permission
	 */
	public AbstractCommand(IPermission permission, int requiredArguments, IParameter... arguments)
	{
		this.permission = permission;
		this.requiredParameters = requiredArguments;
		this.parameters = arguments;
	}

	/*
	 * ************************************** ICommand Interface Methods **************************************
	 */

	/*
	 * This implementation of ICommand does implement Command level ErrorHandlers and will always return null.
	 * 
	 * If you need a command level ErrorHandler simply override this method and implement the ErrorHandler however you
	 * wish.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#getErrorHandler()
	 */
	@Override
	public IErrorHandler getErrorHandler()
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#checkArgumentNumber(int)
	 */
	@Override
	public final boolean checkArgumentNumber(int argumentNumber)
	{
		return argumentNumber >= requiredParameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#checkPermission(org.sythe.suf.message.ISender)
	 */
	@Override
	public final boolean checkPermission(ISender sender)
	{
		return this.permission.compare(sender.getPermission());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#checkParameterTypes(java.lang.String[])
	 */
	public String checkParameterTypes(String parameter, int position)
	{
		// TODO: Maybe add array index checking and add a custom error
		if (!(parameters[position].isValid(parameter)))
		{
			return parameters[position].getType();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#getTotalParameters()
	 */
	@Override
	public int getTotalParameters()
	{
		return parameters.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#getRequiredParameters()
	 */
	@Override
	public int getRequiredParameters()
	{
		return requiredParameters;
	}

	public IPermission getPermission()
	{
		return (IPermission) permission.clone();
	}

	/*
	 * This method gets overridden to make the command do what you want it to do.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#run(org.sythe.suf.message.ISender, java.lang.String[])
	 */
	@Override
	public abstract void run(ISender sender, String[] args);

	/*
	 * ************************************** Getter Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public final int getRequireArguments()
	{
		return requiredParameters;
	}

	/*
	 * ************************************** Setter Methods **************************************
	 */

	/**
	 * TODO: Write comment
	 * 
	 * @param permission
	 */
	public final void setPermission(IPermission permission)
	{
		this.permission = permission;
	}
}
