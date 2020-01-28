package hu.tosad2019.groep4.generator.dataaccess.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import hu.tosad2019.groep4.generator.application.application.MainFacade;


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
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) new JSONParser().parse(inputbody.toString());
		} catch (ParseException e) {
			response = "Input body error";
			t.sendResponseHeaders(400, response.getBytes().length);
			os.write(response.getBytes());
	        os.close();
	        return;
		}
		String dbUrlString;
		String ruleIdString;
		try {
			dbUrlString = jsonObject.get("db_url").toString();
			ruleIdString = jsonObject.get("rule_id").toString();
		}catch(NullPointerException e) {
			response = "Invalid parameters";
			t.sendResponseHeaders(400, response.getBytes().length);
			os.write(response.getBytes());
	        os.close();
	        return;
		}
		
		MainFacade facade = new MainFacade();
		int ruleId = Integer.parseInt(ruleIdString);
		facade.GenerateBusinessRule(ruleId, dbUrlString);
		response = "Success!";
		t.sendResponseHeaders(200, response.getBytes().length);
		os.write(response.getBytes());
        os.close();
    }
}
