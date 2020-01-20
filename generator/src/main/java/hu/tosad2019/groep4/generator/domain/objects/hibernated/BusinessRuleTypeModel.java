package hu.tosad2019.groep4.generator.domain.objects.hibernated;

import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.attributecomparerule.AttributeCompareRule;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="BusinessRuleType")
public class BusinessRuleTypeModel {

    @Id
    private int id;

    private String name;

    public BusinessRuleTypeModel(String name) {
        this.name = name;
    }

    public BusinessRuleTypeModel() {}

    public String getName() {
        return this.name;
    }

}
