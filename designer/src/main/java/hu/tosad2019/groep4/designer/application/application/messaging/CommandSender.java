package hu.tosad2019.groep4.designer.application.application.messaging;

import hu.tosad2019.groep4.designer.dataaccess.communication.Server;
import hu.tosad2019.groep4.designer.dataaccess.communication.ServerManager;

public class CommandSender {

	public boolean executeCommand(ServerCommand command) throws Exception {
		Server connectedServer = ServerManager.getInstance().getConnectedServer();
		if(connectedServer == null) {
			throw new Exception("Not connected to server");
		}
		return command.execute(connectedServer);
	}
}
