package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="BusinessRuleType")
public class BusinessRuleTypeModel {

    @Id
    private int id;

    private String name;
    private int template_id;
    private int category_type;

    public BusinessRuleTypeModel(String name, int template_id, int category_type) {
        this.name = name;
        this.template_id = template_id;
        this.category_type = category_type;
    }

    public BusinessRuleTypeModel() {}

    public String getName() {
        return this.name;
    }
}
