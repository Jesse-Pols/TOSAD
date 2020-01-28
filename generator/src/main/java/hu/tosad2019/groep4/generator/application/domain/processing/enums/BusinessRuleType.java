package hu.tosad2019.groep4.generator.application.domain.processing.enums;

public enum BusinessRuleType {
    AttributeCompareRule("AttributeCompareRule", "Attribute Compare Rule", "ACMP"),
    AttributeRangeRule("AttributeRangeRule", "Attribute Range Rule", "ARNG"),
    AttributeListRule("AttributeListRule", "Attribute List Rule", "ALIS"),
    AttributeOtherRule("AttributeOtherRule", "Attribute Other Rule", "AOTH"),
    TupleCompareRule("TupleCompareRule", "Tuple Compare Rule", "TCMP"),
    TupleOtherRule("TupleOtherRule", "Tuple Other Rule", "TOTH"),
    InterEntityCompareRule("InterEntityCompareRule", "Inter Entity Compare Rule", "ICMP"),
    EntityOtherRule("EntityOtherRule", "Entity Other Rule", "EOTH"),
    ModifyRule("ModifyRule", "Modify Rule", "MODI");

    public final String label;
    public final String friendlyLabel;
    public final String code;

    BusinessRuleType(String label, String friendlyLabel, String code) {
        this.label = label;
        this.friendlyLabel = friendlyLabel;
        this.code = code;
    }
    public String toString() {
        return this.friendlyLabel;
    }
}
