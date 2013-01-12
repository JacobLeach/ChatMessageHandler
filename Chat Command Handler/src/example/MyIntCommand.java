package example;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.*;
import org.sythe.suf.message.command.parameter.IntegerParameter;
import org.sythe.suf.message.command.permission.IntegerPermission;

/**
 * TODO: CURRENTLY BROKEN. Fix
 * 
 * @author Jacob A. Leach
 *
 */
public class MyIntCommand extends AbstractCommand
{
	public MyIntCommand()
	{
		super(new IntegerPermission(1), 1, new IntegerParameter());
	}
	
	@Override
	public void run(ISender sender, String[] args)
	{
		if(sender instanceof MyPlayer)
		{
			MyPlayer temp = (MyPlayer) sender;
			temp.setPermission(Integer.parseInt(args[0]));
			temp.sendMessage("MyIntCommand: -> Permission changed to: " + args[0]);
		}
	}

}
