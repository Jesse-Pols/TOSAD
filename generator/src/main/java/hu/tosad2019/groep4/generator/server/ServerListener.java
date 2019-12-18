package hu.tosad2019.groep4.generator.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class ServerListener {

	private static boolean created = false;
	
	private int port;
	private HttpServer server;
	
	private ServerListener(int port) {
		this.port = port;
	}
	
	private ServerListener setup() throws IOException {
		this.server = HttpServer.create(new InetSocketAddress(this.port), 0);
		this.server.createContext("/test", new TestHandler());
		this.server.createContext("/cmd", new CommandHandler());
        this.server.setExecutor(null); // Default handler
        return this;
	}
	
	public ServerListener start()  {
        this.server.start();
        System.out.println("Server listener started op port " + this.port + ".");
        return this;
	}
	
	public static ServerListener create(int port) throws Exception {
		if(ServerListener.created) throw new Exception("ServerListener already created"); 
		ServerListener.created = true;
		ServerListener server = new ServerListener(port);
		server.setup();
		return server;
	}
	
}
