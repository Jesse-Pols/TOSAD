package hu.tosad2019.groep4.generator.server;

import java.io.OutputStream;
import java.time.LocalDateTime;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CommandHandler implements HttpHandler {
	@Override
    public void handle(HttpExchange t) {
    	Headers headers = t.getRequestHeaders();
		String authToken = headers.getFirst("Authorization");
		OutputStream os = t.getResponseBody();
		String response = "";
		try {
			if(authToken == null || !authToken.equals("vMDhvChAYbRcF4dG")) {
	            response = String.format("Inwalid access token", LocalDateTime.now());
	            t.sendResponseHeaders(401, response.length());
			}else {
				Thread.sleep(Math.round(Math.random() * 5000) + 2000);
				response = String.format("{ \"res\": \"[PLACE OBJECT HERE]\", \"sent\": \"%s\" } ", LocalDateTime.now());
	            t.sendResponseHeaders(200, response.length());
			}
			os.write(response.getBytes());
	        os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
