package hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusinessRuleCategory {

    @Id
    private int id;

    private String name;

    public BusinessRuleCategory(String name) {
        this.name = name;
    }
}
