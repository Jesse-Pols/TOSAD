package hu.tosad2019.groep4.generator.domain.Enums;

public enum Operator {
    equals("="),
    notEquals("!="),
    greaterThen(">"),
    smallerThen("<"),
    greaterThenOrEqualsTo(">="),
    smallerThenOrEqualsTo("<=");


    public final String label;

    private Operator(String label){
        this.label = label;
    }
}
