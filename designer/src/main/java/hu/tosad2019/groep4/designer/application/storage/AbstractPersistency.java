package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.*;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;

import java.util.ArrayList;
import java.util.List;

public class AbstractPersistency {

    protected BusinessRuleDao businessRuleDao = new BusinessRuleDao();
    protected BusinessRuleTypeDao businessRuleTypeDao = new BusinessRuleTypeDao();
    protected BusinessRuleCategoryDao businessRuleCategoryDao = new BusinessRuleCategoryDao();
    protected DbColumnDao dbColumnDao = new DbColumnDao();
    protected TemplateDao templateDao = new TemplateDao();

    protected BusinessRuleContext convertIdToContext(int id) {

        BusinessRuleModel businessRuleModel = businessRuleDao.find(id);
        //BusinessRuleTypeModel businessRuleTypeModel = businessRuleModel.getType();
        //List<DbColumnModel> dbColumns = dbColumnDao.findByRuleId(id);

        //BusinessRuleContext context = this.getCorrectType(businessRuleTypeModel.getName());
        BusinessRuleContext context = new BusinessRuleContext(BusinessRuleType.AttributeRangeRule);
        context.setName(businessRuleModel.getName());
        context.setId(businessRuleModel.getId());
        //context.setDescription(businessRuleModel.getDescription());
        //context.setFailure(businessRuleModel.getFailure());

        /*
        for (DbColumnModel column : dbColumns) {
            if (column.getPosition() == 0) {
                context.setFirstColumn(column.getColumn_name());
                context.setFirstTable(column.getTable_name());
                break;
            }
        }
         */

        // TODO: Operator isn't set; Which operator to set if there are two with the same rule_id?

        return context;
    }

    protected List<BusinessRuleContext> loopThroughBusinessRules(List<BusinessRuleModel> businessRuleModels) {
        List<BusinessRuleContext> businessRuleContexts = new ArrayList<>();
        for (BusinessRuleModel businessRule : businessRuleModels) {
            businessRuleContexts.add(this.convertIdToContext(businessRule.getId()));
        }
        return businessRuleContexts;
    }

    // Compare all enums to the database ruletype
    // Returns correct businessrulecontext
    private BusinessRuleContext getCorrectType(String businessRuleType) {
        for (BusinessRuleType typeEnum : BusinessRuleType.values()) {
            String type = typeEnum.toString().replaceAll("\\s+", "");

            if (type.equalsIgnoreCase(businessRuleType)) {
                return new BusinessRuleContext(typeEnum);
            }
        }
        return null;
    }
}
