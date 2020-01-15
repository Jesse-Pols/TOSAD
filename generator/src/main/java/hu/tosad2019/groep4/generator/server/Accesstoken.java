package hu.tosad2019.groep4.generator.server;

public class Accesstoken {

	static String getToken() {
		String envtoken = System.getenv("TOKEN");
		return envtoken!=null?envtoken:"vMDhvChAYbRcF4dG";
	}
	
}
