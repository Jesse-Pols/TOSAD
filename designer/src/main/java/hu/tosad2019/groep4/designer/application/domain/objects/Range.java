package hu.tosad2019.groep4.designer.application.domain.objects;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class Range {
    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public Operator getMinValueOperator() {
        return minValueOperator;
    }

    public Operator getMaxValueOperator() {
        return maxValueOperator;
    }

    private int minValue;
    private int maxValue;
    private Operator minValueOperator;
    private Operator maxValueOperator;


    public Range(int minValue,
                 int maxValue,
                 Operator minValueOperator,
                 Operator maxValueOperator){

        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minValueOperator = minValueOperator;
        this.maxValueOperator = maxValueOperator;
    }

}
