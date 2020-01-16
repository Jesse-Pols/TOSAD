package hu.tosad2019.groep4.designer.dataaccess.communication;

import hu.tosad2019.groep4.designer.datainfrastructure.Server;

public interface ServerCommand {

	public boolean execute(Server server);
	
}
