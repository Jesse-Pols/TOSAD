package hu.tosad2019.groep4.designer.dataaccess.communication;

import hu.tosad2019.groep4.designer.datainfrastructure.Server;

public class GenerateCommand implements ServerCommand {

	public final int ruleId;
	
	public GenerateCommand(int ruleId) {
		this.ruleId = ruleId;
	}
	
	@Override
	public String execute(Server server) {
		try {
			return server.send("/ping", null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
