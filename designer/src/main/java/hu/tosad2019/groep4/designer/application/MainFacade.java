package hu.tosad2019.groep4.designer.application;

import hu.tosad2019.groep4.designer.dataaccess.communication.CommandSender;
import hu.tosad2019.groep4.designer.dataaccess.communication.GenerateCommand;
import hu.tosad2019.groep4.designer.domain.processing.MessagingService;

public class MainFacade {
	
	public static boolean connectToServer(String protocol, String host, int port) throws Exception{
		return MessagingService.connectToServer(protocol, host, port);
	}
	
	public static boolean generateBusinessRule(int ruleId) throws Exception{
		CommandSender sender = new CommandSender();
		return sender.executeCommand(new GenerateCommand(ruleId));
	}
	
}
