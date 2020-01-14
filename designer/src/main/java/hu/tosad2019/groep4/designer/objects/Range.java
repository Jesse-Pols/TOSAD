package hu.tosad2019.groep4.designer.objects;

import hu.tosad2019.groep4.designer.objects.enums.Operator;

public class Range {
    private int minValue;
    private int maxValue;
    private Operator andOrOperator;

    public Range(int minValue,
                 int maxValue,
                 Operator andOrOperator){

        this.minValue = minValue;
        this.maxValue = maxValue;
        this.andOrOperator = andOrOperator;
    }

}
