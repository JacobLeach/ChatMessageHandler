package org.sythe.suf.message.service;

import org.sythe.suf.message.ITextMessage;

public interface IServiceManager
{
	/**
	 * TODO: Write comment
	 * 
	 * @param taskName
	 * @param task
	 * @return
	 */
	public boolean addTask(String taskName, IService task);

	/**
	 * TODO: Write comment
	 * 
	 * @param message
	 */
	public void runTasks(ITextMessage message);
}
