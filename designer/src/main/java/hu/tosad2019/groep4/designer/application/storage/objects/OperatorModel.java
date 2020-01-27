package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Operator")
public class OperatorModel {

    @Id
    private int id;

    private int rule_id;
    private String operator;

    public OperatorModel(int rule_id, String operator) {
        this.rule_id = rule_id;
        this.operator = operator;
    }

    public OperatorModel() { }
    
    public int getRuleID() { return this.rule_id; }
    public String getOperator() { return this.operator; }

}
