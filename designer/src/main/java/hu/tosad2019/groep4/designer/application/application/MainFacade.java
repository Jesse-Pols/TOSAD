package hu.tosad2019.groep4.designer.application.application;

import hu.tosad2019.groep4.designer.application.application.messaging.CommandSender;
import hu.tosad2019.groep4.designer.application.application.messaging.GenerateCommand;
import hu.tosad2019.groep4.designer.application.domain.processing.MessagingService;

public class MainFacade {
	
	public static boolean connectToServer(String protocol, String host, int port) throws Exception{
		return MessagingService.connectToServer(protocol, host, port);
	}
	
	public static boolean generateBusinessRule(int ruleId) throws Exception{
		CommandSender sender = new CommandSender();
		return sender.executeCommand(new GenerateCommand(ruleId));
	}
	
}
