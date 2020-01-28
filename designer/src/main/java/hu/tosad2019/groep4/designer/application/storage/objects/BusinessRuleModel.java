package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleTypeDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "BusinessRule")
public class BusinessRuleModel {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "businessrule_id_sequence")
    @SequenceGenerator(name = "businessrule_id_sequence", sequenceName = "BUSINESSRULE_SEQUENCE")
    private int id;

    private String name;
    private String description;
    private String failure;
    private int is_not;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BusinessRuleTypeModel type;

    public BusinessRuleModel(String name, String description, String failure, int is_not, BusinessRuleTypeModel type) {
        this.name = name;
        this.description = description;
        this.failure = failure;
        this.is_not = is_not;
        this.type = type;
    }

    public BusinessRuleModel() {}

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

    public void setType(int id) {
        BusinessRuleTypeDao businessRuleTypeDao = new BusinessRuleTypeDao();
        BusinessRuleTypeModel businessRuleTypeModel = businessRuleTypeDao.find(id);
        if (businessRuleTypeModel != null) {
            this.type = businessRuleTypeModel;
        }
    }

    public void setType(BusinessRuleTypeModel type) {
        this.type = type;
    }

    public void setId(int id) { this.id = id; }

}
