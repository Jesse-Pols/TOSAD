package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.dataaccess.communication.GeneratorServer;

public class MessagingService {

	public static boolean connectToServer(String protocol, String host, int port, String password) throws Exception{
		return GeneratorServer.getInstance().connect(protocol, host, port, password);
	}
	
}
