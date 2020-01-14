package hu.tosad2019.groep4.designer.dataaccess;

public class ServerConnectionDetails {

	public final String protocol;
	public final String host;
	public final int port;
	public final String password;
	
	public ServerConnectionDetails(String protocol, String host, int port, String password) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.password = password;
	}
	
}
