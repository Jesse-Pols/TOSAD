package hu.tosad2019.groep4.generator.domain;

import hu.tosad2019.groep4.generator.domain.Enums.Operator;

public class Range {
    private int minValue;
    private int maxValue;

    private Operator minValueOperator;
    private Operator maxValueOperator;
    private Operator andOrOperator;

    public Range(int minValue,
                 int maxValue,
                 Operator minValueOperator,
                 Operator maxValueOperator,
                 Operator andOrOperator){

        this.minValue = minValue;
        this.maxValue = maxValue;

        this.minValueOperator = minValueOperator;
        this.maxValueOperator = maxValueOperator;
        this.andOrOperator = andOrOperator;
    }

}
