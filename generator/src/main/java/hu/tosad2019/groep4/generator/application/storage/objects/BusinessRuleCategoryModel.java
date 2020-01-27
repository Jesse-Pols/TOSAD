package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="BusinessRuleCategory")
public class BusinessRuleCategoryModel {

    @Id
    private int id = 0;

    private String name;

    public BusinessRuleCategoryModel(String name) {
        this.name = name;
    }

    public BusinessRuleCategoryModel() {}

    public String getName() { return this.name; }
    public int getId() { return this.id; }
}
