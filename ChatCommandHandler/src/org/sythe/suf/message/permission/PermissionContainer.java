package org.sythe.suf.message.permission;

import org.sythe.suf.message.ISender;

public class PermissionContainer implements IContainsPermission
{
	private IPermission permission;

	protected void setPermission(IPermission permission)
	{
		this.permission = permission;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#getPermission()
	 */
	@Override
	public final IPermission getPermission()
	{
		// TODO: Fix javadoc to include null
		return (permission == null) ? null : (IPermission) permission.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sythe.suf.message.command.ICommand#checkPermission(org.sythe.suf.message.ISender)
	 */
	@Override
	public final boolean checkPermission(ISender sender)
	{
		// TODO: Update javadoc to include null
		return (permission == null) ? true : this.permission.compare(sender.getPermission());
	}
	
	public IPermission test()
	{
		return (IPermission) permission.clone();
	}
	
	public static void main(String[] args)
	{
		PermissionContainer example = new PermissionContainer();
		
		example.setPermission(null);
		//Prints null
		System.out.println(example.getPermission());
		//Throws NullPointerException
		System.out.println(example.test());
	}
}
