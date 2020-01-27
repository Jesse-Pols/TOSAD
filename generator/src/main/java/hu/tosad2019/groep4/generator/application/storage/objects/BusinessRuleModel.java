package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.*;

@Entity(name = "BusinessRule")
public class BusinessRuleModel {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String failure;
    private int is_not;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BusinessRuleTypeModel type;

    public BusinessRuleTypeModel getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() { return this.id; }

    public String getFailure() { return this.failure; }

    public int getIsNot() { return this.is_not; }

}
