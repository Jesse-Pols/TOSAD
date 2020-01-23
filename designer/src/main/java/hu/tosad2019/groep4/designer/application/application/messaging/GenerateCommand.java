package hu.tosad2019.groep4.designer.application.application.messaging;

import javax.json.Json;
import javax.json.JsonObject;

import hu.tosad2019.groep4.designer.dataaccess.communication.Server;

public class GenerateCommand implements ServerCommand {

	public final int ruleId;
	
	public GenerateCommand(int id) {
		this.ruleId = id;
	}
	
	@Override
	public boolean execute(Server server) {
		try {
			System.out.println("Generating..");
			JsonObject data = Json.createObjectBuilder()
					.add("db_url", "")
					.add("rule_id", 1)
					.build();
			System.out.println(data);
			String response = server.send("/cmd", data);
			System.out.println(response);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
