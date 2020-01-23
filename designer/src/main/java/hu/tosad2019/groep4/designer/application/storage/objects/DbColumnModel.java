package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;

@Entity (name="DbColumn")
public class DbColumnModel {

    @Id
    private int id;

    private String column_name;
    private String table_name;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    private int position;

}
