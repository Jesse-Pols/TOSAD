package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;

@Entity (name="SpecifiedValue")
public class SpecifiedValueModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "specifiedvalue_id_sequence")
    @SequenceGenerator(name = "specifiedvalue_id_sequence", sequenceName = "SPECIFIEDVALUE_SEQUENCE", initialValue = 1, allocationSize = 1)
    private int id;

    private String value;
    private String type;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ListModel list;

    public SpecifiedValueModel(String value) {
        this.value = value;
    }

    public SpecifiedValueModel() { }

    public String getValue() { return this.value; }

    public void setList(ListModel list) {
        this.list = list;
    }

    public void setRule(BusinessRuleModel rule) {
        this.businessRule = rule;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }
}
