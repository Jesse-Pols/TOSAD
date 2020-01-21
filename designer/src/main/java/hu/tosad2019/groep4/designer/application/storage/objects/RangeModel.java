package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Range")
public class RangeModel {

    @Id
    private int id;

    private String min;
    private String max;
    private int min_value_operator;
    private int max_value_operator;
    private int rule_id;

    public RangeModel(String min, String max, int min_value_operator, int max_value_operator, int rule_id) {
        this.min = min;
        this.max = max;
        this.min_value_operator = min_value_operator;
        this.max_value_operator = max_value_operator;
        this.rule_id = rule_id;
    }

    public RangeModel() {}

}

