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

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import hu.tosad2019.groep4.generator.application.application.Generator;
import hu.tosad2019.groep4.generator.application.application.Main;
import hu.tosad2019.groep4.generator.application.application.MainFacade;
import hu.tosad2019.groep4.generator.application.application.TempGenerator;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


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

			String dbUrlString = jsonObject.get("db_url").toString();
			String ruleIdString = jsonObject.get("rule_id").toString();


			MainFacade facade = new MainFacade();

			int ruleId = Integer.parseInt(ruleIdString);
			facade.GenerateBusinessRule(ruleId, dbUrlString);




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
