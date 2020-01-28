package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;

@Entity (name="DbColumn")
public class DbColumnModel {

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

    public DbColumnModel() {}
}
