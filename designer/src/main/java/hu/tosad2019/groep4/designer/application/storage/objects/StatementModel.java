package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicModel;

import javax.persistence.*;

@Entity(name="Statement")
public class StatementModel implements BasicModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "statement_id_sequence")
    @SequenceGenerator(name = "statement_id_sequence", sequenceName = "STATEMENT_SEQUENCE", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name="rule_id")
    private BusinessRuleModel businessRule;

    private String statement;

    public StatementModel(String statement, BasicModel businessRuleModel) {
        this.statement = statement;
        this.businessRule = (BusinessRuleModel) businessRuleModel;
    }

    public StatementModel() { }

    public String getStatement() { return this.statement; }
    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }
}
