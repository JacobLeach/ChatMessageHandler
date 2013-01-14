package org.sythe.suf.message.command.permission;

/**
 * @author Jacob A. Leach
 *
 */
public interface IPermission extends Cloneable
{

	/**
	 * TODO: Think about this more. Mainly passing as IPermission
	 * 
	 * Compares two permissions and returns true if the argument permission is equal to this permission or higher than
	 * this permission. Returns false if the argument permission is less than this permission.
	 * 
	 * @param permission
	 *            the permission to compare to this permission
	 * @return true if the argument permission is equal to or higher than this permission level, false if the argument
	 *         permission is less than this permission
	 */
	public boolean compare(IPermission permission);
	
	/**
	 * TODO: Write comment
	 * 
	 * @return
	 */
	public Object clone();
}
