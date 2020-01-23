package hu.tosad2019.groep4.generator.application.domain.objects.enums;

public enum Operator {
    equals("="),
    notEquals("!="),
    greaterThen(">"),
    smallerThen("<"),
    greaterThenOrEqualsTo(">="),
    smallerThenOrEqualsTo("<="),
	and("&"),
	or("|");
	


    public final String label;

    private Operator(String label){
        this.label = label;
    }
}