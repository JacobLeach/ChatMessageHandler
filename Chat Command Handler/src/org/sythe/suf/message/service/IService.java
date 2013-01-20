package org.sythe.suf.message.service;

import org.sythe.suf.message.ITextMessage;
import org.sythe.suf.message.permission.IContainsPermission;

public interface IService extends IContainsPermission
{
	/**
	 * TODO: Write comment
	 * 
	 * @param message
	 */
	public void run(ITextMessage message);
}
