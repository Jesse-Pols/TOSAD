package hu.tosad2019.groep4.generator.application.storage.objects;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicModel;

import javax.persistence.*;

@Entity (name="SpecifiedValue")
public class SpecifiedValueModel implements BasicModel {

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

    public SpecifiedValueModel(String value, BusinessRuleModel rule) {
        this.value = value;
        this.businessRule = rule;
    }

    public SpecifiedValueModel(String value, ListModel list) {
        this.value = value;
        this.list = list;
    }

    public SpecifiedValueModel() { }

    public String getValue() { return this.value; }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() { return this.id; }
}
