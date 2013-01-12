package example;

import org.sythe.suf.message.IPermissionedSender;

/**
 * TODO: CURRENTLY BROKEN. Fix
 * 
 * @author Jacob A. Leach
 *
 */
public class MyPlayer implements IPermissionedSender
{
	private String name;
	private int permission;
	
	public MyPlayer(String name, int permission)
	{
		this.name = name;
		this.permission = permission;
	}

	@Override
	public int getPermission()
	{
		return permission;
	}
	
	public void setPermission(int permission)
	{
		this.permission = permission;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void sendPrivateMessage(String message)
	{
		//This is pretending the console is how you send a private message to a player
		System.out.println(message);
	}
}
