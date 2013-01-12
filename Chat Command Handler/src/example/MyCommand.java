package example;

import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.AbstractCommand;
import org.sythe.suf.message.command.parameter.StringParameter;

public class MyCommand extends AbstractCommand
{

	public MyCommand()
	{
		super(2, 1, new StringParameter());
	}

	@Override
	public String runCommand(ISender sender, String[] args)
	{
		if (sender instanceof MyPlayer)
		{
			MyPlayer p = (MyPlayer) sender;
			p.setName(args[0]);
			p.sendPrivateMessage("MyCommand: -> Name changed to: " + args[0]);
		}
		return null;
	}

}
