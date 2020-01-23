package hu.tosad2019.groep4.designer.application.application;

import hu.tosad2019.groep4.designer.Main;
import hu.tosad2019.groep4.designer.application.application.messaging.CommandSender;
import hu.tosad2019.groep4.designer.application.application.messaging.GenerateCommand;
import hu.tosad2019.groep4.designer.application.application.messaging.MessagingService;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;

import java.util.HashMap;
import java.util.Map;

public class MainFacade {

	private static MainFacade instance;

	private MainFacade() {}

	public static MainFacade getInstance() {

		if (MainFacade.instance == null) {
			instance = new MainFacade();
		}

		return instance;
	}
	
	public boolean connectToServer(String protocol, String host, int port) throws Exception{
		return MessagingService.connectToServer(protocol, host, port);
	}
	
	public boolean generateBusinessRule(String ruleId) throws Exception{
		CommandSender sender = new CommandSender();
		return sender.executeCommand(new GenerateCommand(ruleId));
	}

	//code, name
	public HashMap<String, String> getAllBusinessRules(){
		return null;
	}

	public boolean saveBusinessRule(BusinessRuleContext context) {
		return DefineRule.saveBusinessRule(context);
	}

	public Map<String, String> getProperties(String businessRuleType){
		return DefineRule.getProperties(businessRuleType);
	}
	
}
