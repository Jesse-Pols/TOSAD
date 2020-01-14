package hu.tosad2019.groep4.designer.dataaccess;

public interface Server {

	public boolean connect(ServerConnectionDetails details) throws ServerConnectionException;
	
}
