package hu.tosad2019.groep4.generator.server;

import java.io.OutputStream;
import java.time.LocalDateTime;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class PingHandler implements HttpHandler {
	@Override
    public void handle(HttpExchange t) {
		OutputStream os = t.getResponseBody();
		String response = "";

		try {
			response = String.format("{ \"res\": true, \"sent\": \"%s\" } ", LocalDateTime.now());
            t.sendResponseHeaders(200, response.length());

			os.write(response.getBytes());
	        os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
