package hu.tosad2019.groep4.designer.dataaccess.communication;

import java.io.IOException;

public class GeneratorServer implements Server {

	private static GeneratorServer INSTANCE = new GeneratorServer();
	
	private ServerConnection connection;
	
	private GeneratorServer() {}
	
	public static GeneratorServer getInstance() { return GeneratorServer.INSTANCE; }
	
	public boolean connect(String protocol, String host, int port, String password) throws Exception {
		try {
			this.connection = new ServerConnection(protocol, host, port, password);
			this.connection.send("/test", null);
			return true;
		} catch(NumberFormatException e) {
			throw new Exception("Port must be a number");
		} catch (IOException e) {
			throw new Exception("Could not connect to server.");
		} catch (RequestFailException e) {
			if(e.getResponseCode() == 404) throw new Exception("Path not found");
			else if(e.getResponseCode() == 401) throw new Exception("Invalid password");
			else throw new Exception("Unknown error while connecting server");
		}
	}
	
	public boolean executeCommand(ServerCommand command) {
		return command.execute(this);
	}
	
}
