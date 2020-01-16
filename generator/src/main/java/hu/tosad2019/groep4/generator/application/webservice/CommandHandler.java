package hu.tosad2019.groep4.generator.application.webservice;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CommandHandler implements HttpHandler{
	@Override
    public void handle(HttpExchange t) throws IOException {
		OutputStream os = t.getResponseBody();
		String response = "";
		InputStream body = t.getRequestBody();
		StringBuilder inputbody = new StringBuilder();
		try (Reader reader = new BufferedReader(new InputStreamReader(body, Charset.forName(StandardCharsets.UTF_8.name())))) {
			int c = 0;
			while ((c = reader.read()) != -1) {
				inputbody.append((char) c);
			}
		}
		System.out.println(inputbody.toString());

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
