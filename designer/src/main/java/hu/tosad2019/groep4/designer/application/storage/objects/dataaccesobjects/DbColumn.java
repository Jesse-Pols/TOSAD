package hu.tosad2019.groep4.designer.application.storage.objects.dataaccesobjects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DbColumn {

    @Id
    private int id;

    private String column_name;
    private String table_name;

    public DbColumn(String column_name, String table_name) {
        this.column_name = column_name;
        this.table_name = table_name;
    }

}
