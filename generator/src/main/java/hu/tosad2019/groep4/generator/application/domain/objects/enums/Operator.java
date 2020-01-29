package hu.tosad2019.groep4.generator.application.domain.objects.enums;

public enum Operator {
    EQUALS("="),
    NOTEQUALS("!="),
    GREATERTHAN(">"),
    LESSTHEN("<"),
    GREATERTHENOREQUAL(">="),
    LESSTHENOREQUAL("<="),
    AND("&"),
    OR("|"),
    BETWEEN("|"),
    NOTBETWEEN("|");



    public final String label;

    private Operator(String label){
        this.label = label;
    }

    @Override
    public String toString(){
        return label;
    }
}
