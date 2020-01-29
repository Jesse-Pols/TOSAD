package hu.tosad2019.groep4.generator.application.storage.objects;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicModel;

import javax.persistence.*;

@Entity (name="DbColumn")
public class DbColumnModel implements BasicModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "dbcolumn_id_sequence")
    @SequenceGenerator(name = "dbcolumn_id_sequence", sequenceName = "DBCOLUMN_SEQUENCE", initialValue = 1, allocationSize = 1)
    private int id;

    private String column_name;
    private String table_name;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRuleModel;

    private int position;

    public DbColumnModel(String column_name, String table_name, BasicModel rule, int position) {
        this.column_name = column_name;
        this.table_name = table_name;
        this.businessRuleModel = (BusinessRuleModel) rule;
        this.position = position;
    }

    public DbColumnModel() {}

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
}
