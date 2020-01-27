package hu.tosad2019.groep4.generator.dataaccess.storage;

public class DataAccessLayerException extends RuntimeException {
    public DataAccessLayerException() {}

    public DataAccessLayerException(String message) { super(message); }

    public DataAccessLayerException(Throwable cause) { super(cause); }

    public DataAccessLayerException(String message, Throwable cause) { super(message,cause); }
}
