package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleTypeDao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="BusinessRule")
public class BusinessRuleModel {

    @Id
    private int id;

    private String name;
    private String description;
    private String failure;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BusinessRuleTypeModel type;

    private int is_not;

    public BusinessRuleTypeModel getType() {
        return this.type;
    }

    public int getTypeId() {
        return this.type.getId();
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
