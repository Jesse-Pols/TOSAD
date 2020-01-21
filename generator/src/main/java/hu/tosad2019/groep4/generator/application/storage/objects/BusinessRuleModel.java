package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="BusinessRule")
public class BusinessRuleModel {

    @Id
    private int id;

    private String name;
    private String description;
    private String failure;
    private int type_id;
    private int is_not;

    public BusinessRuleModel(String name, String description, String failure, int type_id, int is_not) {
        this.name = name;
        this.description = description;
        this.failure = failure;
        this.type_id = type_id;
        this.is_not = is_not;
    }

    public BusinessRuleModel() {}
}
