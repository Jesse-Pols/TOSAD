package hu.tosad2019.groep4.designer.application.application;

public class TargetDbContext {
    private String dataBaseType;
    private String hostname;
    private int port;
    private String username;
    private String password;

    public TargetDbContext(String databaseType, String hostname, int port, String username, String password){
        this.dataBaseType = databaseType;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getDataBaseType() {
        if (dataBaseType == null)
            return "";
        return dataBaseType;
    }

    public String getHostname() {
        if (hostname == null)
            return "";
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        if (username == null)
            return "";
        return username;
    }

    public String getPassword() {
        if (password == null)
            return "";
        return password;
    }
}
