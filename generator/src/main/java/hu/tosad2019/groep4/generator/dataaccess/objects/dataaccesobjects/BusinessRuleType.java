package hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusinessRuleType {

    @Id
    private int id;

    private String name;

    public BusinessRuleType(String name) {
        this.name = name;
    }

}
