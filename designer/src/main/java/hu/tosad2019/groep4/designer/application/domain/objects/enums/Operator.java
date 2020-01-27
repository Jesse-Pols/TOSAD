package hu.tosad2019.groep4.designer.application.domain.objects.enums;

public enum Operator {
    EQUALS("=", "[=] Equal"),
    NOTEQUALS("!=", "[≠] Not equal"),
    GREATERTHAN(">", "[>] Greater than"),
    LESSTHEN("<", "[<] Less than"),
    GREATERTHENOREQUAL(">=", "[≥] Greater than or equal"),
    LESSTHENOREQUAL("<=", "[≤] Less than or equal"),
    AND("&", "[&] And"),
    OR("|", "[|] Or"),
	BETWEEN("|", "[↔] Between"),
	NOTBETWEEN("|", "[¬] Not between");



    public final String label;
    public final String friendlyLabel;

    private Operator(String label, String friendlyLabel){
        this.label = label;
        this.friendlyLabel = friendlyLabel;
    }
    
    public String toString() {
    	return this.friendlyLabel;
    }
}

