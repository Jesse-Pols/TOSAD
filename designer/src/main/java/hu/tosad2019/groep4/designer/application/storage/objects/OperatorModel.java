package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;

@Entity(name="Operator")
public class OperatorModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "operator_id_sequence")
    @SequenceGenerator(name = "operator_id_sequence", sequenceName = "OPERATOR_SEQUENCE", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    private String operator;

    public OperatorModel() { }

    public String getOperator() { return this.operator; }

}
