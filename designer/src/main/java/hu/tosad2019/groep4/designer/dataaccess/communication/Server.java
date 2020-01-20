package hu.tosad2019.groep4.designer.dataaccess.communication;

import java.io.IOException;

import javax.json.JsonObject;

public class Server {
	
	private ServerConnection connection;
	
	public Server(String protocol, String host, int port) throws Exception {
		this.connect(protocol, host, port);
	}
	
	private boolean connect(String protocol, String host, int port) throws Exception {
		try {
			this.connection = new ServerConnection(protocol, host, port);
			this.send("/ping", null);
			return true;
		} catch(NumberFormatException e) {
			throw new Exception("Port must be a number");
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Could not connect to server.");
		} catch (RequestFailException e) {
			if(e.getResponseCode() == 404) throw new Exception("Path not found");
			else if(e.getResponseCode() == 401) throw new Exception("Invalid password");
			else throw new Exception("Unknown error while connecting server");
		}
	}
	public String send(String subpath, JsonObject jsondata) throws IOException, RequestFailException {
		return this.connection.send(subpath, jsondata);
	}
	
}
