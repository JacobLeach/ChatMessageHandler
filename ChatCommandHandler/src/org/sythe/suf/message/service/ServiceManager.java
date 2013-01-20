package org.sythe.suf.message.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.sythe.suf.message.ITextMessage;

public class ServiceManager implements IServiceManager
{
	private HashMap<String, IService> service = new HashMap<String, IService>();

	@Override
	public boolean addTask(String serviceName, IService task)
	{
		boolean replaced = service.containsKey(serviceName);
		service.put(serviceName, task);

		return replaced;
	}

	@Override
	public void runTasks(ITextMessage message)
	{
		Iterator<IService> iterator = service.values().iterator();
		while (iterator.hasNext())
		{
			iterator.next().run(message);
		}
	}
}
