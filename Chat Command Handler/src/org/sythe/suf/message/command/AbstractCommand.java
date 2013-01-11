package org.sythe.suf.message.command;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.argument.IArgument;

/**
 * @author Jacob A. Leach
 * 
 */
public abstract class AbstractCommand implements ICommand
{
	private int permission;
	/**
	 * 
	 */
	private int requiredArugments;
	private IArgument[] arguments;

	public static final int DEFAULT_PERMISSION = 0;

	/**
	 * 
	 */
	public AbstractCommand()
	{
		this(DEFAULT_PERMISSION);
	}

	/**
	 * @param permission
	 */
	public AbstractCommand(int permission)
	{
		this.permission = permission;
	}

	/*
	 * ************************************** ICommand Interface Methods **************************************
	 */

	/**
	 * 
	 * @see ICommand#execute(ISender, String[])
	 */
	public final void execute(ISender iSender, String[] args)
	{
		
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

	/**
	 * @param arguments
	 * @param numberRequired
	 */
	protected void setArugments(IArgument[] arguments, int numberRequired)
	{
		this.arguments = arguments;
	}

	/*
	 * ************************************** Helper Methods **************************************
	 */

	/**
	 * Called by {@link #execute(ISender, String[]) execute} to ensure we have enough arugments.
	 * 
	 * @return true if the number of arugments is valid, false otherwise
	 */
	private final boolean checkArugmentNumber(String[] args)
	{
		return args.length >= requiredArugments;
	}

	/*
	 * ************************************** Abstract Methods **************************************
	 */

	/**
	 * @param iSender
	 * @param args
	 * @return
	 */
	public abstract Object runCommand(ISender iSender, String[] args);
}
