package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.parameter.IParameter;

/**
 * NOTE: This class is "dumb". It does not do any checking of the permissions / parameters. It is assumed that this is
 * done BEFORE the command is told to run, most likely by the CommandManager.
 * 
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractCommand implements ICommand
{
	private int permission;

	private int requiredArguments;
	private IParameter[] parameters;

	public static final int DEFAULT_PERMISSION = 0;
	public static final int DEFAULT_REQUIRED_ARGUMENTS = 0;
	public static final int DEFAULT_TOTAL_ARGUMENTS = 0;

	public AbstractCommand()
	{
		this(DEFAULT_PERMISSION, DEFAULT_REQUIRED_ARGUMENTS, new IParameter[DEFAULT_TOTAL_ARGUMENTS]);
	}

	/**
	 * @param permission
	 */
	public AbstractCommand(int permission, int requiredArguments, IParameter... arguments)
	{
		this.permission = permission;
		this.requiredArguments = requiredArguments;
		this.parameters = arguments;
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
	public final void run(ISender sender, String[] args)
	{
		if (checkArgumentNumber(args.length))
		{
			if (checkPermission(sender))
			{
				/*
				 * Check all the arugments to make sure they are the correct type.
				 * Compare i to both args.length and arguments.length because of optional arguments and not checking for
				 * too
				 * many arguments.
				 * 
				 * If there is an invalid argument, throw an InvalidArugmentException.
				 */
				for (int i = 0; (i < args.length) && (i < parameters.length); i++)
				{
					if (!(parameters[i].isValid(args[i])))
					{
						// throw new InvalidArugmentException("Argument is invalid: " + arguments[i].getType() +
						// " expected.", arguments[i].getType());
					}
				}
				// If everything is all good, run the command
				runCommand(sender, args);
			}
			else
			{
				// throw new InsufficientPermissionException("Permission is insufficient: " + permission + " needed.",
				// permission);
			}
		}
		else
		{
			// TODO: Implement
			// throw new MissingArgumentsException("Missing arguments... Not fully implemented");
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

	@Override
	public final boolean checkArgumentNumber(int argumentNumber)
	{
		return argumentNumber >= requiredArguments;
	}

	@Override
	public final boolean checkPermission(ISender sender)
	{
		return (sender.getPermission() >= this.permission);
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
