package hu.tosad2019.groep4.generator.application.domain.processing.enums;

public enum BusinessRuleType {
    AttributeCompareRule("AttributeListRuleContext", "Attribute Compare Rule"),
    AttributeRangeRule("AttributeRangeRule", "Attribute Range Rule"), 
    AttributeListRule("AttributeListRule", "Attribute List Rule"), 
    AttributeOtherRule("AttributeOtherRule", "Attribute Other Rule"), 
    TupleCompareRule("TupleCompareRule", "Tuple Compare Rule"), 
    TupleOtherRule("TupleOtherRule", "Tuple Other Rule"), 
    InterEntityCompareRule("InterEntityCompareRule", "Inter Entity Compare Rule"), 
    EntityOtherRule("EntityOtherRule", "Entity Other Rule"), 
    ModifyRule("ModifyRule", "Modify Rule");
	
	public final String label;
	public final String friendlyLabel;

	BusinessRuleType(String label, String friendlyLabel) {
		this.label = label;
		this.friendlyLabel = friendlyLabel;
	}
	public String toString() {
		return this.friendlyLabel;
	}
}
