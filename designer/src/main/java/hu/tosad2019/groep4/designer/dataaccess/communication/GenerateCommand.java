package hu.tosad2019.groep4.designer.dataaccess.communication;

import hu.tosad2019.groep4.designer.datainfrastructure.Server;

public class GenerateCommand implements ServerCommand {

	public final int ruleId;
	
	public GenerateCommand(int ruleId) {
		this.ruleId = ruleId;
	}
	
	@Override
	public boolean execute(Server server) {
		try {
			System.out.println("Generating..");
			String response = server.send("/cmd", null);
			System.out.println(response);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
