package hu.tosad2019.groep4.designer.datainfrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.JsonObjectBuilder;

public class ServerConnection {

	private String protocol; 
	private String host; 
	private int port;
	
	/**
	* Create new ServerConnection
	*/
	public ServerConnection(String protocol, String host, int port) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
	}
	
	public String getConnectionString(String subpath) {
		return String.format("%s%s:%s", this.protocol, this.host, this.port) + subpath;
	}
	public URL getConnectionURL(String subpath) throws MalformedURLException { 
		return new URL(this.getConnectionString(subpath)); 
	}
	
	public String send(String subpath, JsonObjectBuilder jsondata) throws IOException, RequestFailException {
		URL obj = this.getConnectionURL(subpath);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(1000);
        connection.setReadTimeout(1000);
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else { 
        	throw new RequestFailException(responseCode, null);  
        }
	}
	
}
