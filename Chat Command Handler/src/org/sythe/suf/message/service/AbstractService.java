package org.sythe.suf.message.service;

import org.sythe.suf.message.ITextMessage;
import org.sythe.suf.message.permission.PermissionContainer;

public abstract class AbstractService extends PermissionContainer implements IService
{
	@Override
	public abstract void run(ITextMessage message);
}
