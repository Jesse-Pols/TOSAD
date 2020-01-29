package hu.tosad2019.groep4.designer.application.application.messaging;

import javax.json.Json;
import javax.json.JsonObject;

import hu.tosad2019.groep4.designer.application.application.TargetDbContext;
import hu.tosad2019.groep4.designer.dataaccess.communication.Server;

public class GenerateCommand implements ServerCommand {

	public final int ruleId;
	private TargetDbContext targetDbContext;
	
	public GenerateCommand(int id, TargetDbContext targetDbContext) {
		this.ruleId = id;
		this.targetDbContext = targetDbContext;
	}
	
	@Override
	public boolean execute(Server server) {
		if (targetDbContext == null)
			return false;
		try {
			System.out.println("Generating..");
			JsonObject data = Json.createObjectBuilder()
					.add("databaseType", targetDbContext.getDataBaseType())
					.add("hostname", targetDbContext.getHostname())
					.add("port", targetDbContext.getPort())
					.add("username", targetDbContext.getUsername())
					.add("password", targetDbContext.getPassword())
					.add("action", "generate")
					.add("id", this.ruleId)
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
