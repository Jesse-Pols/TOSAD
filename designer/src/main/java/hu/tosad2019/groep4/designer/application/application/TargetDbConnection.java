package hu.tosad2019.groep4.designer.application.application;

public class TargetDbConnection {
    private String dataBaseType;
    private String hostname;
    private String port;
    private String username;
    private String password;

    public TargetDbConnection(String databaseType, String hostname, String port, String username, String password){
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

    public String getPort() {
        if (port == null)
            return "";
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
