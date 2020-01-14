package hu.tosad2019.groep4.designer.dataaccess.communication;

public interface Server {

	public boolean connect(ServerConnectionDetails details) throws ServerConnectionException;
	
}
