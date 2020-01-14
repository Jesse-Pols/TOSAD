package hu.tosad2019.groep4.generator.domain.objects;

import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;

public class Range {
    private int minValue;
    private int maxValue;

    public Range(int minValue,
                 int maxValue,
                 Operator andOrOperator){

        this.minValue = minValue;
        this.maxValue = maxValue;
    }

}
