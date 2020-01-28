package hu.tosad2019.groep4.generator.application.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(inputbody.toString());

			String ruleIdString = jsonObject.get("id").toString();

			String databaseType = jsonObject.get("databaseType").toString();
			String hostname = jsonObject.get("hostname").toString();
			int port = Integer.parseInt(jsonObject.get("port").toString());
			String username = jsonObject.get("username").toString();
			String password = jsonObject.get("password").toString();

			TargetDbContext targetDbContext = new TargetDbContext(databaseType, hostname, port, username, password);

			MainFacade facade = new MainFacade();

			int ruleId = Integer.parseInt(ruleIdString);
			boolean success = facade.GenerateBusinessRule(ruleId, targetDbContext);

			if (success){
				t.sendResponseHeaders(200, response.length());
				response = String.format("{ \"result\": \"success\" } ", LocalDateTime.now());
			}
			else{
				t.sendResponseHeaders(400, response.length());
				response = String.format("{ \"result\": \"failed to generate\" } ", LocalDateTime.now());
			}

			os.write(response.getBytes());
	        os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
