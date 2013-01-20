package org.sythe.suf.message.permission;

import org.sythe.suf.message.ISender;

public interface IContainsPermission
{
	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public IPermission getPermission();
	
	/**
	 * @param sender
	 *            the sender of the command
	 * @return true if the sender has permission to use the command and false if the sender does not have permission to
	 *         use the command
	 */
	public boolean checkPermission(ISender sender);
}
