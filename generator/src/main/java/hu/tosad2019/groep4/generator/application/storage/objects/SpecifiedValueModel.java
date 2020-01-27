package hu.tosad2019.groep4.generator.application.storage.objects;

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

    private int list_id;

    public SpecifiedValueModel() { }
}
