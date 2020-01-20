package hu.tosad2019.groep4.designer.application.storage.objects;

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

}
