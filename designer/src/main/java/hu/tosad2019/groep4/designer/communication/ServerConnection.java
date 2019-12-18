package hu.tosad2019.groep4.designer.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerConnection {

	public final boolean https;
	public final String protocol;
	public final String host;
	public final int port;
	public final String authkey;
	private HttpURLConnection connection;
	
	/**
	* Create new ServerConnection,
	* defaults protocol to 'http'
	*/
	public ServerConnection(String host, String authkey, int port) {
		this(host, port, authkey, false);
	}
	/**
	* Create new ServerConnection
	*/
	public ServerConnection(String host, int port, String authkey, boolean https) {
		this.host = host;
		this.port = port;
		this.authkey = authkey;
		this.https = https;
		
		if(this.https) this.protocol = "https://";
		else this.protocol = "http://";
	}
	
	public ServerConnection open() {
		try {
			URL obj = this.getConnectionURL();
			this.connection = (HttpURLConnection) obj.openConnection();
		} 
		catch (MalformedURLException e) { e.printStackTrace(); } 
		catch (IOException e) {
			// TODO: Error handling
			System.err.println("IOException!");
			e.printStackTrace();
		}
		return this;
	}
	
	
	public String getConnectionString() {
		return String.format("%s%s:%s/test", this.protocol, this.host, this.port);
	}
	public URL getConnectionURL() throws MalformedURLException { 
		return new URL(this.getConnectionString()); 
	}
	
	public boolean send() throws IOException {
        this.connection.setRequestMethod("GET");
        this.connection.setRequestProperty("Authorization", this.authkey);
//        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = this.connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.err.println("GET request returned with code " + responseCode + ".");
        }
		return  true;
	}
	
}
