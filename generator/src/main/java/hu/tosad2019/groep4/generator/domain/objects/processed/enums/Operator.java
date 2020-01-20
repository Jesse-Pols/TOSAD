package hu.tosad2019.groep4.generator.domain.objects.processed.enums;

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