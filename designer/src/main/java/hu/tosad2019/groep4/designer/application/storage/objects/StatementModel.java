package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;

@Entity(name = "Statement")
public class StatementModel {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    private String statement;

    public StatementModel() { }

    public int getId() { return this.id; }

    public String getStatement() { return this.statement; }
}
