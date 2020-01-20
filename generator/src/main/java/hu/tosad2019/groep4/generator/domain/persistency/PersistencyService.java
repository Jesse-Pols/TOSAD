package hu.tosad2019.groep4.generator.domain.persistency;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.BusinessRuleModel;
import hu.tosad2019.groep4.generator.domain.objects.hibernated.DbColumnModel;
import hu.tosad2019.groep4.generator.domain.objects.hibernated.SpecifiedValueModel;
import hu.tosad2019.groep4.generator.domain.persistency.dao.BusinessRuleDao;
import hu.tosad2019.groep4.generator.domain.persistency.dao.DbColumnDao;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.generator.domain.objects.processed.Column;
import hu.tosad2019.groep4.generator.domain.objects.processed.enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.attributecomparerule.AttributeCompareRuleContext;

public class PersistencyService {
    public void getAllBusinessRules() {

    }
    public hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.BusinessRule getBusinessRuleById(int id) {

        // TODO Wtf is the deal with our domain objects
        // TODO Below code must be possible much shorter and simpler

        // DAO
        IBusinessRuleDao brDao = new BusinessRuleDao();
        IDbColumnDao dbcDao = new DbColumnDao();

        // Database Objects
        BusinessRuleModel BusinessRuleModel = brDao.find(id);
        DbColumnModel dbDbColumnModel = BusinessRuleModel.getDbColumn();
        SpecifiedValueModel dbSpecifiedValueModel = BusinessRuleModel.getSpecifiedValue();

        // Domain Objects
        Column column = new Column(dbDbColumnModel.getTable_name(), dbDbColumnModel.getColumn_name());
        AttributeCompareRuleContext context = new AttributeCompareRuleContext(column, true, Operator.and, null);

        hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.BusinessRule businessRule;
        businessRule = new AttributeCompareRule(null, BusinessRuleModel.getName(), BusinessRuleModel.getDescription(), context);

        return businessRule;
    }
}
