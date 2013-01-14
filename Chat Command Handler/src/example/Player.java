package example;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.permission.IPermission;
import org.sythe.suf.message.command.permission.IntegerPermission;

/**
 * @author Jacob A. Leach
 *
 */
public class Player implements ISender
{
	private String name;
	private IntegerPermission permission;
	
	public Player(String name, int permission)
	{
		this.name = name;
		this.permission = new IntegerPermission(permission);
	}

	@Override
	public IntegerPermission getPermission()
	{
		return permission;
	}
	
	public void setPermission(int permission)
	{
		this.permission = new IntegerPermission(permission);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public void sendMessage(String message)
	{
		//This is pretending the console is how you send a private message to a player
		System.out.println(message);
	}
	
	
}
