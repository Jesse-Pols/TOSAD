package hu.tosad2019.groep4.designer.application.application.messaging;

import hu.tosad2019.groep4.designer.dataaccess.communication.Server;

public interface ServerCommand {

	public boolean execute(Server server);
	
}
