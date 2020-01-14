package hu.tosad2019.groep4.designer.dataaccess.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.JsonObjectBuilder;

public class ServerConnection {

	public final ServerConnectionDetails details;
	
	/**
	* Create new ServerConnection
	*/
	public ServerConnection(ServerConnectionDetails details) {
		this.details = details;
	}
	
	public String getConnectionString(String subpath) {
		return String.format("%s%s:%s", this.details.protocol, this.details.host, this.details.port) + subpath;
	}
	public URL getConnectionURL(String subpath) throws MalformedURLException { 
		return new URL(this.getConnectionString(subpath)); 
	}
	
	public String send(String subpath, JsonObjectBuilder jsondata) throws IOException, RequestFailException {
		URL obj = this.getConnectionURL(subpath);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", this.details.password);
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
