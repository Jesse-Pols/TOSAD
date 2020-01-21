package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="DbColumn")
public class DbColumnModel {

    @Id
    private int id;

    private String column_name;
    private String table_name;
    private int rule_id;

    public DbColumnModel(String column_name, String table_name, int rule_id) {
        this.column_name = column_name;
        this.table_name = table_name;
        this.rule_id = rule_id;
    }

    public DbColumnModel() {}
}
