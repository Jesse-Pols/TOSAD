package hu.tosad2019.groep4.designer.dataaccess.communication;

public class RequestFailException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private final int code;
	
	public RequestFailException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public int getResponseCode() { return this.code; }

}
