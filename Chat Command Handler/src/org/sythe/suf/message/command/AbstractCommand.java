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
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractCommand implements ICommand
{
	private IPermission permission;

	private final int requiredArguments;
	private final IParameter[] parameters;

	// TODO: Write a IntegerPermission Class to use here
	public static final int DEFAULT_PERMISSION = 0;
	public static final int DEFAULT_REQUIRED_ARGUMENTS = 0;
	public static final int DEFAULT_TOTAL_ARGUMENTS = 0;

	// public AbstractCommand()
	// {
	// // TODO: uncomment when I have written IntegerPermission class
	// // this(DEFAULT_PERMISSION, DEFAULT_REQUIRED_ARGUMENTS, new IParameter[DEFAULT_TOTAL_ARGUMENTS]);
	// }

	/**
	 * @param permission
	 */
	public AbstractCommand(IPermission permission, int requiredArguments, IParameter... arguments)
	{
		this.permission = permission;
		this.requiredArguments = requiredArguments;
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
		return argumentNumber >= requiredArguments;
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
	public String checkParameterTypes(String[] args)
	{
		/*
		 * Check all the arugments to make sure they are the correct type.
		 * Compare i to both args.length and arguments.length because of optional arguments and not checking for
		 * too
		 * many arguments.
		 * 
		 * If there is an invalid argument, return the String representation of the required type.
		 */
		for (int i = 0; (i < args.length) && (i < parameters.length); i++)
		{
			if (!(parameters[i].isValid(args[i])))
			{
				return parameters[i].getType();
			}
		}

		return null;
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
	public final IPermission getPermission()
	{
		return permission;
	}

	
	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public final int getRequireArguments()
	{
		return requiredArguments;
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
