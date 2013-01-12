package org.sythe.suf.message;

import org.sythe.suf.message.command.permission.IPermission;

/**
 * @author Jacob A. Leach
 *
 */
public interface ISender 
{
	public IPermission getPermission();
}
