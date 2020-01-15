package hu.tosad2019.groep4.generator.domain.objects;

import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Range {

    @Id
    private int id;

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
