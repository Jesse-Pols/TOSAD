package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.datainfrastructure.ServerManager;

public class MessagingService {

	public static boolean connectToServer(String protocol, String host, int port) throws Exception{
		return ServerManager.getInstance().connect(protocol, host, port);
	}
	
}
