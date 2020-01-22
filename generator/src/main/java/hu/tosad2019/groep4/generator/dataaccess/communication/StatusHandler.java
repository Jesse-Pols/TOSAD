package hu.tosad2019.groep4.generator.dataaccess.communication;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class StatusHandler implements HttpHandler {
	@Override
    public void handle(HttpExchange t) {
		OutputStream os = t.getResponseBody();

		try {
			List<String> steps = TempGenerator.getInstance().getSteps();
			boolean running = TempGenerator.getInstance().getIsRunning();
			JsonObjectBuilder builder = Json.createObjectBuilder();
			
			JsonArrayBuilder stepsarray = Json.createArrayBuilder(); 
			for(String step : steps) {
				stepsarray.add(step);
			}
			builder.add("steps", stepsarray);
			builder.add("running", running);
				
			builder.add("sent", LocalDateTime.now().toString());
			JsonObject obj = builder.build();
	        t.sendResponseHeaders(200, obj.toString().length());

			os.write(obj.toString().getBytes());
	        os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
