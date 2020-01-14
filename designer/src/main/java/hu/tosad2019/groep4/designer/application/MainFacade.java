package hu.tosad2019.groep4.designer.application;

import hu.tosad2019.groep4.designer.domain.processing.MessagingService;

public class MainFacade {
	
	public static boolean connectToServer(String protocol, String host, int port, String password) throws Exception{
		return MessagingService.connectToServer(protocol, host, port, password);
	}
	
}
