package hu.tosad2019.groep4.designer.dataaccess.communication;

import java.io.IOException;

public class GeneratorServer implements Server {

	private static GeneratorServer INSTANCE = new GeneratorServer();
	
	private ServerConnection connection;
	
	private GeneratorServer() {}
	
	public static GeneratorServer getInstance() { return GeneratorServer.INSTANCE; }
	
	public boolean connect(ServerConnectionDetails details) throws ServerConnectionException {
		try {
			this.connection = new ServerConnection(details);
			this.connection.send("/test", null);
			return true;
		} catch(NumberFormatException e) {
			throw new ServerConnectionException("Port must be a number");
		} catch (IOException e) {
			throw new ServerConnectionException("Could not connect to server.");
		} catch (RequestFailException e) {
			if(e.getResponseCode() == 404) throw new ServerConnectionException("Path not found");
			else if(e.getResponseCode() == 401) throw new ServerConnectionException("Invalid password");
			else throw new ServerConnectionException("Unknown error while connecting server");
		}
	}
	
	public boolean executeCommand(ServerCommand command) {
		return command.execute(this);
	}
	
}
