package hu.tosad2019.groep4.generator.server;

import java.io.OutputStream;
import java.time.LocalDateTime;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CommandHandler implements HttpHandler{
	@Override
    public void handle(HttpExchange t) {
		OutputStream os = t.getResponseBody();
		String response = "";

		try {
			if(!TempGenerator.getInstance().getIsRunning()) {
				TempGenerator.getInstance().startGeneration();
				t.sendResponseHeaders(200, response.length());
				response = String.format("{ \"status\": \"started\", \"sent\": \"%s\" } ", LocalDateTime.now());
			}else {
				t.sendResponseHeaders(400, response.length());
				response = String.format("{ \"status\": \"already running\", \"sent\": \"%s\" } ", LocalDateTime.now());
			}

			os.write(response.getBytes());
	        os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
