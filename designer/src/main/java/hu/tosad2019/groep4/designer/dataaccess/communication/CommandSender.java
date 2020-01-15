package hu.tosad2019.groep4.designer.dataaccess.communication;

import hu.tosad2019.groep4.designer.datainfrastructure.Server;
import hu.tosad2019.groep4.designer.datainfrastructure.ServerManager;

public class CommandSender {

	public String executeCommand(ServerCommand command) {
		Server connectedServer = ServerManager.getInstance().getConnectedServer();
		return command.execute(connectedServer);
	}
}
