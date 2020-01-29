package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="SpecifiedValue")
public class SpecifiedValueModel {

    @Id
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
