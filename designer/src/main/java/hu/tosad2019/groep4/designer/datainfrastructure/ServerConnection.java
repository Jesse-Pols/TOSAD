package hu.tosad2019.groep4.designer.datainfrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.JsonObject;

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
	
	public String send(String subpath, JsonObject jsondata) throws IOException, RequestFailException {
		URL obj = this.getConnectionURL(subpath);
		HttpURLConnection conn;
		String jsondatastring = "";
		try {
			conn = (HttpURLConnection) obj.openConnection();
			if(jsondata!=null) jsondatastring = jsondata.toString();
	        conn.setRequestMethod("POST");
	        conn.setDoOutput( true );
	        conn.setInstanceFollowRedirects( false );
	        conn.setRequestProperty("Content-Type", "application/json"); 
	        conn.setRequestProperty("charset", "utf-8");
	        if(jsondata!=null) conn.setRequestProperty("Content-Length", String.valueOf(jsondatastring.length()));
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		if(jsondata != null) {
			try(OutputStream os = conn.getOutputStream()) {
	            byte[] input = jsondatastring.getBytes("utf-8");
	            os.write(input, 0, input.length);           
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	throw e;
	        }
		}
        
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
        	try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
        		StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
	            // print result
	            return response.toString();
			}
        } else { 
        	throw new RequestFailException(responseCode, null);  
        }
	}
	
}
