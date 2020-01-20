package hu.tosad2019.groep4.generator.domain.objects.hibernated;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="BusinessRuleCategory")
public class BusinessRuleCategoryModel {

    @Id
    private int id;

    private String name;

    public BusinessRuleCategoryModel(String name) {
        this.name = name;
    }

    public BusinessRuleCategoryModel() {}
}
