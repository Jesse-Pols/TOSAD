package hu.tosad2019.groep4.generator.domain.objects.hibernated;

import hu.tosad2019.groep4.generator.domain.objects.processed.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="DbColumn")
public class DbColumnModel {

    @Id
    private int id;

    private String column_name;
    private String table_name;

    public DbColumnModel(String column_name, String table_name) {
        this.column_name = column_name;
        this.table_name = table_name;
    }

    public DbColumnModel() {}

    public Column getColumn() {
        return new Column(this.table_name, this.column_name);
    }

}
