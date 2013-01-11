package example;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.*;
import org.sythe.suf.message.command.argument.IntegerArugment;

public class MyIntCommand extends AbstractCommand
{
	public MyIntCommand()
	{
		super(1, 1, new IntegerArugment());
	}
	
	@Override
	public String runCommand(ISender sender, String[] args)
	{
		if(sender instanceof MyPlayer)
		{
			MyPlayer temp = (MyPlayer) sender;
			temp.setPermission(Integer.parseInt(args[0]));
			temp.sendPrivateMessage("Permission changed to: " + args[0]);
		}
		return null;
	}

}
