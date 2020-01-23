package hu.tosad2019.groep4.designer.application.storage.objects;

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
    private int min_value_operator;
    private int max_value_operator;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    public String getMinValue() {
        return this.min;
    }

    public String getMaxValue() {
        return this.max;
    }

}

