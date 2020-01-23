package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="BusinessRuleType")
public class BusinessRuleTypeModel {

    @Id
    private int id;

    private String name;
    private int template_id;
    private int category_id;

    public BusinessRuleTypeModel(String name, int template_id, int category_id) {
        this.name = name;
        this.template_id = template_id;
        this.category_id = category_id;
    }

    public BusinessRuleTypeModel() {}

    public String getName() {
        return this.name;
    }
}
