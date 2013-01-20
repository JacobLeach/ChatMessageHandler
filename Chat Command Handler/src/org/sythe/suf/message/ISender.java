package org.sythe.suf.message;

import org.sythe.suf.message.permission.IPermission;

/**
 * @author Jacob A. Leach
 * 
 */
public interface ISender
{
	public IPermission getPermission();

	public void sendMessage(String message);
}
