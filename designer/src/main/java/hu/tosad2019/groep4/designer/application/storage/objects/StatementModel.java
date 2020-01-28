package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;

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
    private BusinessRuleModel businessRule;

    private String statement;

    public StatementModel(String statement, BusinessRuleModel businessRuleModel) {
        this.statement = statement;
        this.businessRule = businessRuleModel;
    }

    public StatementModel() { }

    public String getStatement() { return this.statement; }
    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }
}
