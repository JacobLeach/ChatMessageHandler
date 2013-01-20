package example;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.AbstractCommand;
import org.sythe.suf.message.command.parameter.StringParameter;
import org.sythe.suf.message.permission.IntegerPermission;

/**
 * @author Jacob A. Leach
 *
 */
public class Command extends AbstractCommand
{

	public Command()
	{
		super(new IntegerPermission(2), 1, new StringParameter());
	}

	@Override
	public void run(ISender sender, String[] args)
	{
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			p.setName(args[0]);
			p.sendMessage("MyCommand: -> Name changed to: " + args[0]);
		}
	}

}
