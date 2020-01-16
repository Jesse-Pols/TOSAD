package hu.tosad2019.groep4.designer.datainfrastructure;

public class ServerManager {

	private static ServerManager INSTANCE = new ServerManager();
	
	private Server connectedServer; 
	
	private ServerManager() {}
	
	public static ServerManager getInstance() { return ServerManager.INSTANCE; }
	
	public boolean connect(String protocol, String host, int port) throws Exception {
		try {
			this.connectedServer = new Server(protocol, host, port);
			return true;
		} catch (Exception e) {
			this.connectedServer = null;
			throw e;
		}
		
	}
	public Server getConnectedServer() { return this.connectedServer; }
	
}
