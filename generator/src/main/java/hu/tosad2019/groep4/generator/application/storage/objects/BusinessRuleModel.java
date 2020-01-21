package hu.tosad2019.groep4.generator.application.storage.objects;

import hu.tosad2019.groep4.generator.application.storage.dao.BusinessRuleTypeDao;
import hu.tosad2019.groep4.generator.application.storage.dao.DbColumnDao;
import hu.tosad2019.groep4.generator.application.storage.dao.SpecifiedValueDao;

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
    private int dbcolumn_id;
    private int specifiedvalue_id;
    private int range_id;

    public BusinessRuleModel(String name, String description, int type_id, int dbcolumn_id, int specifiedvalue_id, int range_id) {
        this.name = name;
        this.description = description;
        this.type_id = type_id;
        this.dbcolumn_id = dbcolumn_id;
        this.specifiedvalue_id = specifiedvalue_id;
        this.range_id = range_id;
    }

    public BusinessRuleModel() {}

    public DbColumnModel getDbColumn() {
        DbColumnDao dbcDao = new DbColumnDao();
        return dbcDao.find(this.dbcolumn_id);
    }

    public SpecifiedValueModel getSpecifiedValue() {
        SpecifiedValueDao svDao = new SpecifiedValueDao();
        return svDao.find(this.specifiedvalue_id);
    }

    public BusinessRuleTypeModel getBusinessRuleType() {
        BusinessRuleTypeDao brtDao = new BusinessRuleTypeDao();
        return brtDao.find(this.type_id);
    }
}
