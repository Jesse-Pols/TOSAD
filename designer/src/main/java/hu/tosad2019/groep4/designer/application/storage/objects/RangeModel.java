package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;

@Entity (name="Range")
public class RangeModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "range_id_sequence")
    @SequenceGenerator(name = "range_id_sequence", sequenceName = "RANGE_SEQUENCE", initialValue = 1, allocationSize = 1)
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

