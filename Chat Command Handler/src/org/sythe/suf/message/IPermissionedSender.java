package org.sythe.suf.message;

public interface IPermissionedSender extends ISender
{
	/**
	 * @return
	 */
	public int getPermission();
}
