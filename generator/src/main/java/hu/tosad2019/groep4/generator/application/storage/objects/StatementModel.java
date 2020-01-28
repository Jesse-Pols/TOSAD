package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Statement")
public class StatementModel {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="rule_id")
    private BusinessRuleModel businessRuleModel;

    private String statement;

    public StatementModel() { }

    public String getStatement() { return this.statement; }
    public int getId() { return this.id; }
}
