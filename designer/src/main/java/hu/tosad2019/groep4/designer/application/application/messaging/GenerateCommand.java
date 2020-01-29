package hu.tosad2019.groep4.designer.application.application.messaging;

import javax.json.Json;
import javax.json.JsonObject;

import hu.tosad2019.groep4.designer.application.application.TargetDbConnection;
import hu.tosad2019.groep4.designer.dataaccess.communication.Server;

public class GenerateCommand implements ServerCommand {

	public final int ruleId;
	private TargetDbConnection targetDbConnection;
	
	public GenerateCommand(int id, TargetDbConnection targetDbConnection) {
		this.ruleId = id;
		this.targetDbConnection = targetDbConnection;
	}
	
	@Override
	public boolean execute(Server server) {
		if (targetDbConnection == null)
			return false;
		try {
			System.out.println("Generating..");
			JsonObject data = Json.createObjectBuilder()
					.add("databaseType", targetDbConnection.getDataBaseType())
					.add("hostname", targetDbConnection.getHostname())
					.add("port", targetDbConnection.getPort())
					.add("username", targetDbConnection.getUsername())
					.add("password", targetDbConnection.getPassword())
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
