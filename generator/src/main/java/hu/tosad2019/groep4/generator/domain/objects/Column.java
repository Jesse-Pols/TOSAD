package hu.tosad2019.groep4.generator.domain.objects;

public class Column {
    private String tableName;
    private String columnName;

    public Column(String tableName, String columName){
        this.tableName = tableName;
        this.columnName = columName;
    }

    public String getTableName(){
        return tableName;
    }

    public String getName(){
        return columnName;
    }
}
