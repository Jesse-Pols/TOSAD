package hu.tosad2019.groep4.designer.application.application;

import hu.tosad2019.groep4.designer.application.application.messaging.CommandSender;
import hu.tosad2019.groep4.designer.application.application.messaging.GenerateCommand;
import hu.tosad2019.groep4.designer.application.application.messaging.MessagingService;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;

import java.util.HashMap;
import java.util.Map;

public class MainFacade {
	
	public static boolean connectToServer(String protocol, String host, int port) throws Exception{
		return MessagingService.connectToServer(protocol, host, port);
	}
	
	public static boolean generateBusinessRule(int ruleId) throws Exception{
		CommandSender sender = new CommandSender();
		return sender.executeCommand(new GenerateCommand(ruleId));
	}

	//code, name
	public static HashMap<String, String> getAllBusinessRules(){
		return null;
	}

	public static boolean saveBusinessRule(BusinessRuleContext context) {
		return DefineRule.saveBusinessRule(context);
	}

	public static Map<String, String> getProperties(String businessRuleType){
		return DefineRule.getProperties(businessRuleType);
	}
	
}
