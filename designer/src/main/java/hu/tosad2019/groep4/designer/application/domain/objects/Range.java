package hu.tosad2019.groep4.designer.application.domain.objects;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class Range {
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
