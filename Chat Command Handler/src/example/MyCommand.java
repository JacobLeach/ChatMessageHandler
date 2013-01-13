package example;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.AbstractCommand;
import org.sythe.suf.message.command.parameter.StringParameter;
import org.sythe.suf.message.command.permission.IntegerPermission;

/**
 * TODO: CURRENTLY BROKEN. Fix
 * 
 * @author Jacob A. Leach
 *
 */
public class MyCommand extends AbstractCommand
{

	public MyCommand()
	{
		super(new IntegerPermission(2), 1, new StringParameter());
	}

	@Override
	public void run(ISender sender, String[] args)
	{
		if (sender instanceof MyPlayer)
		{
			MyPlayer p = (MyPlayer) sender;
			p.setName(args[0]);
			p.sendMessage("MyCommand: -> Name changed to: " + args[0]);
		}
	}

}
