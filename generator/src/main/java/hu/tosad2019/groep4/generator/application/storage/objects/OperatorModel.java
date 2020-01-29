package hu.tosad2019.groep4.generator.application.storage.objects;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicModel;

import javax.persistence.*;

@Entity(name="Operator")
public class OperatorModel implements BasicModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "operator_id_sequence")
    @SequenceGenerator(name = "operator_id_sequence", sequenceName = "OPERATOR_SEQUENCE", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    private String operator;

    public OperatorModel(String operator, BasicModel businessRule) {
        this.operator = operator;
        this.businessRule = (BusinessRuleModel) businessRule;
    }

    public OperatorModel() { }

    public String getOperator() { return this.operator; }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

}
