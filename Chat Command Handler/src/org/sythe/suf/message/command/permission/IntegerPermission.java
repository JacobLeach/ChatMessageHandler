package org.sythe.suf.message.command.permission;

/**
 * TODO: Implement this class such that integers are used as levels of permission. The higher, the more permission you
 * have.
 * 
 * @author Jacob A. Leach
 * 
 */
public class IntegerPermission implements IPermission
{

	private int level;

	public IntegerPermission(int level)
	{
		this.level = level;
	}

	/* (non-Javadoc)
	 * @see org.sythe.suf.message.command.permission.IPermission#compare(org.sythe.suf.message.command.permission.IPermission)
	 */
	@Override
	public boolean compare(IPermission permission)
	{
		if (permission instanceof IntegerPermission)
		{
			IntegerPermission temp = (IntegerPermission) permission;
			return temp.level >= level;
		}
		else
		{
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone()
	{
		return new IntegerPermission(level);
	}
	
	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public int getLevel()
	{
		return level;
	}
	
	@Override
	public String toString()
	{
		return level + "";
	}
}
