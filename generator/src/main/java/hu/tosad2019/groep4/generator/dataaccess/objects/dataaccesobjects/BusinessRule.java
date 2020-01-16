package hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects;

import hu.tosad2019.groep4.generator.dataaccess.persistency.dao.DbColumnDao;
import hu.tosad2019.groep4.generator.dataaccess.persistency.dao.SpecifiedValueDao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusinessRule {

    @Id
    private int id;

    private String name;
    private String description;
    private int type_id;
    private int dbcolumn_id;
    private int specifiedvalue_id;
    private int range_id;

    public BusinessRule(String name, String description, int type_id, int dbcolumn_id, int specifiedvalue_id, int range_id) {
        this.name = name;
        this.description = description;
        this.type_id = type_id;
        this.dbcolumn_id = dbcolumn_id;
        this.specifiedvalue_id = specifiedvalue_id;
        this.range_id = range_id;
    }

    public BusinessRule() {}

    public DbColumn getDbColumn() {
        DbColumnDao dbcDao = new DbColumnDao();
        return dbcDao.find(this.dbcolumn_id);
    }

    public SpecifiedValue getSpecifiedValue() {
        SpecifiedValueDao svDao = new SpecifiedValueDao();
        return svDao.find(this.specifiedvalue_id);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
