package hu.tosad2019.groep4.designer.dataaccess.communication;

public enum RequestMethod {

	GET("GET"),
	POST("POST");
	
	public final String name;

    private RequestMethod(String name) {
        this.name = name;
    }
	
}
