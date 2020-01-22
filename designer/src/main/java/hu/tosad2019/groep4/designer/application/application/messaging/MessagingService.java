package hu.tosad2019.groep4.designer.application.application.messaging;

import hu.tosad2019.groep4.designer.dataaccess.communication.ServerManager;

public class MessagingService {

	public static boolean connectToServer(String protocol, String host, int port) throws Exception{
		return ServerManager.getInstance().connect(protocol, host, port);
	}
}
