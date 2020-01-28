package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="Range")
public class RangeModel {

    @Id
    private int id;

    private String min;
    private String max;

    @ManyToOne
    @JoinColumn(name = "min_value_operator")
    private OperatorModel min_operator;

    @ManyToOne
    @JoinColumn(name = "max_value_operator")
    private OperatorModel max_operator;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;


    public RangeModel() {}

    public OperatorModel getMinOperator() {
        return this.min_operator;
    }
    public OperatorModel getMaxOperator() { return this.min_operator; }
    public String getMinValue() { return this.min; }
    public String getMaxValue() { return this.max; }
}

