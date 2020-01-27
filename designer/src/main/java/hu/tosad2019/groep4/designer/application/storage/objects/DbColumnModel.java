package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="DbColumn")
public class DbColumnModel {

    @Id
    private int id;

    private String column_name;
    private String table_name;
    private int rule_id;
    private int position;

    public DbColumnModel(String column_name, String table_name, int rule_id, int position) {
        this.column_name = column_name;
        this.table_name = table_name;
        this.rule_id = rule_id;
        this.position = position;
    }

    public DbColumnModel() {}

    public int getPosition() { return this.position;}
    public String getColumn_name() { return this.column_name; }
    public String getTable_name() { return this.table_name; }
    public int getRuleID() { return this.rule_id; }
}
