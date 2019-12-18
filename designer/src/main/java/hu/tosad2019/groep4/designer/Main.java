package hu.tosad2019.groep4.designer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import hu.tosad2019.groep4.designer.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application
{
	private static String PollingURl = "";

	public static void main(String[] args) {
		launch();
//		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//	    System.out.print("Generator url: ");
//	    Main.PollingURl = myObj.nextLine();  // Read user input
//		try {
//			while(true) {
//				System.out.println("Request pending...");
//				Main.getHTTP();
//			}
//		} catch (ConnectException e) {
//			System.err.println(String.format("Could not find \"%s\".", Main.PollingURl));
//		} catch (MalformedURLException e) {
//			System.err.println(String.format("URL \"%s\" is not valid.", Main.PollingURl));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void start(Stage primaryStage) {
		MainWindow.create(primaryStage);
	}


	public static void getHTTP() throws IOException {
		URL obj = new URL(Main.PollingURl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "vMDhvChAYbRcF4dG");
//		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
		}
	}
}
