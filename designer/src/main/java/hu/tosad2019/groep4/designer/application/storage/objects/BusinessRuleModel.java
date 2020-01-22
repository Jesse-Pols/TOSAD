package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleTypeDao;

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

    public BusinessRuleTypeModel getType() {
        BusinessRuleTypeDao brtDao = new BusinessRuleTypeDao();
        return brtDao.find(this.type_id);
    }

}
