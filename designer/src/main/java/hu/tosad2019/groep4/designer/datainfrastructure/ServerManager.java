package hu.tosad2019.groep4.designer.datainfrastructure;

public class ServerManager {

	private static ServerManager INSTANCE = new ServerManager();
	
	private Server connectedServer; 
	
	private ServerManager() {}
	
	public static ServerManager getInstance() { return ServerManager.INSTANCE; }
	
	public boolean connect(String protocol, String host, int port) throws Exception {
		this.connectedServer = new Server(protocol, host, port);
		return true;
	}
	public Server getConnectedServer() { return this.connectedServer; }
	
}
