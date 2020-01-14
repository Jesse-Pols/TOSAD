package hu.tosad2019.groep4.designer.dataaccess.communication;

public interface Server {

	public boolean connect(String protocol, String host, int port, String password) throws Exception;
	
}
