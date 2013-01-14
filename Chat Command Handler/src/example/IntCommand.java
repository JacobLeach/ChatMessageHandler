package example;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.*;
import org.sythe.suf.message.command.parameter.IntegerParameter;
import org.sythe.suf.message.command.permission.IntegerPermission;

/**
 * @author Jacob A. Leach
 *
 */
public class IntCommand extends AbstractCommand
{
	public IntCommand()
	{
		super(new IntegerPermission(1), 1, new IntegerParameter());
	}
	
	@Override
	public void run(ISender sender, String[] args)
	{
		if(sender instanceof Player)
		{
			Player temp = (Player) sender;
			temp.setPermission(Integer.parseInt(args[0]));
			temp.sendMessage("MyIntCommand: -> Permission changed to: " + args[0]);
		}
	}

}
