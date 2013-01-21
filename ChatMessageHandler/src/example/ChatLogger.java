package example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.sythe.suf.message.ITextMessage;
import org.sythe.suf.message.service.AbstractService;

public class ChatLogger extends AbstractService
{
	private File log = new File("logger.txt");

	public void run(ITextMessage message)
	{
		Player p = (Player) message.getSender();
		try
		{
			BufferedWriter outLog = new BufferedWriter(new FileWriter(log, true));
			outLog.write(p.getName() + ": " + message.getMessageText());
			outLog.newLine();
			outLog.flush();
			outLog.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
