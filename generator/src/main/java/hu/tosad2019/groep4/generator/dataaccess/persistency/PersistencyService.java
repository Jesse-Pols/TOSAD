package hu.tosad2019.groep4.generator.dataaccess.persistency;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.DbColumn;
import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.SpecifiedValue;
import hu.tosad2019.groep4.generator.dataaccess.persistency.dao.BusinessRuleDao;
import hu.tosad2019.groep4.generator.dataaccess.persistency.dao.DbColumnDao;
import hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.generator.domain.objects.Column;
import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;

public class PersistencyService {
    public void getAllBusinessRules() {

    }
    public hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule getBusinessRuleById(int id) {

        // TODO Wtf is the deal with our domain objects
        // TODO Below code must be possible much shorter and simpler

        // DAO
        IBusinessRuleDao brDao = new BusinessRuleDao();
        IDbColumnDao dbcDao = new DbColumnDao();

        // Database Objects
        BusinessRule dbBusinessRule = brDao.find(id);
        DbColumn dbDbColumn = dbBusinessRule.getDbColumn();
        SpecifiedValue dbSpecifiedValue = dbBusinessRule.getSpecifiedValue();

        // Domain Objects
        Column column = new Column(dbDbColumn.getTable_name(), dbDbColumn.getColumn_name());
        AttributeCompareRuleContext context = new AttributeCompareRuleContext(column, true, Operator.and, null);

        hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule businessRule;
        businessRule = new AttributeCompareRule(null, dbBusinessRule.getName(), dbBusinessRule.getDescription(), context);

        return businessRule;
    }
}
