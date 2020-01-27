package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    public int getIs_not() { return this.is_not; }
    public String getFailure() { return this.failure; }

    public int getIsNot() { return this.is_not; }

}
