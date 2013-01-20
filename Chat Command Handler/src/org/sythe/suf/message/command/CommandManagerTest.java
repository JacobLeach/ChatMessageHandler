package org.sythe.suf.message.command;

import static org.junit.Assert.*;

import org.junit.Test;
import org.sythe.suf.message.ISender;
import org.sythe.suf.message.command.error.IErrorHandler;
import org.sythe.suf.message.command.parameter.IParameter;
import org.sythe.suf.message.command.parameter.IntegerParameter;
import org.sythe.suf.message.permission.IPermission;
import org.sythe.suf.message.permission.IntegerPermission;

public class CommandManagerTest
{

	@Test
	public void testHandleCommand()
	{
		CommandManager manager = new CommandManager(new ErrorHandler());
		manager.addCommand("test", new TestCommand());
		SendTo reply = new SendTo();
		TestSender sender = new TestSender(reply);

		/*
		 * Test non-existent command name catching
		 */
		String command = "This_is_a_wrong_name.";
		manager.handleCommand(sender, command);
		assertTrue("Message: " + reply.message, reply.message.equals("NameError - " + command.toLowerCase()));

		/*
		 * Test not enough arguments
		 */
		command = "test";
		manager.handleCommand(sender, command);
		// 2 is from TestCommand
		assertTrue("Message: " + reply.message, reply.message.equals("ParameterNumberError - " + 0 + " - " + 2));

		command = "test arg1";
		manager.handleCommand(sender, command);
		// 2 is from TestCommand
		assertTrue("Message: " + reply.message, reply.message.equals("ParameterNumberError - " + 1 + " - " + 2));

		/*
		 * Test argument type wrong
		 */
		command = "test 1 hi";
		manager.handleCommand(sender, command);
		assertTrue("Message: " + reply.message, reply.message.equals("ParameterTypeError - " + "hi" + " - " + new IntegerParameter().getType()));

		command = "test hi 1";
		manager.handleCommand(sender, command);
		assertTrue("Message: " + reply.message, reply.message.equals("ParameterTypeError - " + "hi" + " - " + new IntegerParameter().getType()));

		command = "test hi hi";
		manager.handleCommand(sender, command);
		assertTrue("Message: " + reply.message, reply.message.equals("ParameterTypeError - " + "hi" + " - " + new IntegerParameter().getType()));

		/*
		 * Test permission
		 */
		// Set up
		TestCommand permissionTester = new TestCommand();
		permissionTester.setPermission(5);
		manager.addCommand("test", permissionTester);

		command = "test 1 1";
		manager.handleCommand(sender, command);
		assertTrue("Message: " + reply.message, reply.message.equals("PermissionError - " + 1 + " - " + 5));

		permissionTester.setPermission(1);
		
		/*
		 * Test Command Actually Running
		 */
		command = "test 1 1";
		manager.handleCommand(sender, command);
		assertTrue("Message: " + reply.message, reply.message.equals("Command run"));
	}

	/*
	 * This class is simply a way to get the message that would be sent back to the user.
	 */
	class SendTo
	{
		String message;

		public void sendMessage(String message)
		{
			this.message = message;
		}

		public String getMessage()
		{
			String temp = message;
			message = null;
			return temp;
		}
	}

	class TestSender implements ISender
	{
		SendTo sendTo;

		TestSender(SendTo sendTo)
		{
			this.sendTo = sendTo;
		}

		public IPermission getPermission()
		{
			return new IntegerPermission(1);
		}

		@Override
		public void sendMessage(String message)
		{
			sendTo.sendMessage(message);
		}
	}

	class ErrorHandler implements IErrorHandler
	{

		@Override
		public void onNameError(ISender sender, String nameGiven)
		{
			sender.sendMessage("NameError - " + nameGiven);
		}

		@Override
		public void onParameterNumberError(ISender sender, int numberGiven, int numberRequired)
		{
			sender.sendMessage("ParameterNumberError - " + numberGiven + " - " + numberRequired);
		}

		@Override
		public void onParameterTypeError(ISender sender, String parameterGiven, String typeRequired)
		{
			sender.sendMessage("ParameterTypeError - " + parameterGiven + " - " + typeRequired);
		}

		@Override
		public void onPermissionError(ISender sender, IPermission senderPermission, IPermission commandPermission)
		{
			sender.sendMessage("PermissionError - " + senderPermission + " - " + commandPermission);
		}

	}

	class TestCommand extends AbstractCommand
	{

		public TestCommand()
		{
			super(new IntegerPermission(1), 2, new IntegerParameter(), new IntegerParameter(), new IntegerParameter());
		}

		@Override
		public void run(ISender sender, String[] args)
		{
			sender.sendMessage("Command run");
		}

		public void setPermission(int permission)
		{
			this.setPermission(new IntegerPermission(permission));
		}

	}

}
