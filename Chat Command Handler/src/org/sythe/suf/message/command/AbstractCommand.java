package org.sythe.suf.message.command;

import org.sythe.suf.message.IPermissionedSender;
import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.argument.IArgument;
import org.sythe.suf.message.command.argument.InvalidArugmentException;
import org.sythe.suf.message.command.argument.MissingArgumentsException;

/**
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractCommand implements ICommand
{
	private int permission;

	private int requiredArguments;
	private IArgument[] arguments;

	public static final int DEFAULT_PERMISSION = 0;
	public static final int DEFAULT_REQUIRED_ARGUMENTS = 0;
	public static final int DEFAULT_TOTAL_ARGUMENTS = 0;

	public AbstractCommand()
	{
		this(DEFAULT_PERMISSION, DEFAULT_REQUIRED_ARGUMENTS, new IArgument[DEFAULT_TOTAL_ARGUMENTS]);
	}

	/**
	 * @param permission
	 */
	public AbstractCommand(int permission, int requiredArguments, IArgument... arguments)
	{
		this.permission = permission;
		this.requiredArguments = requiredArguments;
		this.arguments = arguments;
	}

	/*
	 * ************************************** ICommand Interface Methods **************************************
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#execute(org.sythe.suf.message.ISender, java.lang.String[])
	 */
	@Override
	public final void execute(ISender sender, String[] args) throws InvalidArugmentException, MissingArgumentsException
	{
		if (isEnoughArgs(args))
		{
			if (hasPermission(sender))
			{
				/*
				 * Check all the arugments to make sure they are the correct type.
				 * Compare i to both args.length and arguments.length because of optional arguments and not checking for
				 * too
				 * many arguments.
				 * 
				 * If there is an invalid argument, throw an InvalidArugmentException.
				 */
				for (int i = 0; (i < args.length) && (i < arguments.length); i++)
				{
					if (!(arguments[i].isValid(args[i])))
					{
						throw new InvalidArugmentException("Argument is invalid: " + arguments[i].getType() + " expected.", arguments[i].getType());
					}
				}
				// If everything is all good, run the command
				runCommand(sender, args);
			}
		}
		else
		{
			throw new MissingArgumentsException("Missing arguments... Not fully implemented");
		}
	}

	/*
	 * ************************************** Getter Methods **************************************
	 */

	/**
	 * @return
	 */
	public final int getPermission()
	{
		return permission;
	}

	public final int getRequireArguments()
	{
		return requiredArguments;
	}

	/*
	 * ************************************** Setter Methods **************************************
	 */

	/**
	 * @param permission
	 */
	public final void setPermission(int permission)
	{
		this.permission = permission;
	}

	/*
	 * ************************************** Helper Methods **************************************
	 */

	/**
	 * Called by {@link #execute(ISender, String[]) execute} to ensure we have enough arugments.
	 * 
	 * @return true if the number of arugments is valid, false otherwise
	 */
	private final boolean isEnoughArgs(String[] args)
	{
		return args.length >= requiredArguments;
	}

	private final boolean hasPermission(ISender sender)
	{
		if (sender instanceof IPermissionedSender)
		{
			IPermissionedSender temp = (IPermissionedSender) sender;
			return (temp.getPermission() >= this.permission);
		}
		else
		{
			return true;
		}
	}

	/*
	 * ************************************** Abstract Methods **************************************
	 */

	/**
	 * @param sender
	 * @param args
	 * @return
	 */
	public abstract String runCommand(ISender sender, String[] args);
}
