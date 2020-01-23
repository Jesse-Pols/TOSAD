package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.*;
import hu.tosad2019.groep4.designer.application.storage.objects.*;

import java.util.ArrayList;
import java.util.List;

public class AbstractPersistency {

    protected BusinessRuleDao businessRuleDao = new BusinessRuleDao();
    protected BusinessRuleTypeDao businessRuleTypeDao = new BusinessRuleTypeDao();
    protected BusinessRuleCategoryDao businessRuleCategoryDao = new BusinessRuleCategoryDao();
    protected DbColumnDao dbColumnDao = new DbColumnDao();
    protected TemplateDao templateDao = new TemplateDao();
    protected StatementDao statementDao = new StatementDao();
    protected RangeDao rangeDao = new RangeDao();
    protected SpecifiedValueDao specifiedValueDao = new SpecifiedValueDao();
    protected ListDao listDao = new ListDao();

    protected BusinessRuleContext convertIdToContext(int id) {

        /* MODELS */
        BusinessRuleModel businessRuleModel = businessRuleDao.find(id);





        BusinessRuleTypeModel businessRuleTypeModel = businessRuleModel.getType();
        BusinessRuleCategoryModel businessRuleCategoryModel = businessRuleTypeModel.getCategory();
        TemplateModel templateModel = businessRuleTypeModel.getTemplate();

        //List<StatementModel> statementModels = statementDao.findAllByRuleId(id);
        //StatementModel statementModel = statementModels.get(0);


        /* CONTEXT */
        BusinessRuleContext context = this.getCorrectType(businessRuleTypeModel.getName());

        // Business Rule
        context.setName(businessRuleModel.getName());
        context.setId(businessRuleModel.getId());
        context.setDescription(businessRuleModel.getDescription());
        context.setFailure(businessRuleModel.getFailure());
        context.setIsNot(businessRuleModel.getIsNot());

        // Business Type
        context.setTypeId(businessRuleModel.getTypeId());

        // Business Category
        context.setCategory(businessRuleCategoryModel.getName());
        context.setCategoryId(businessRuleCategoryModel.getId());

        // Template
        context.setTemplate(templateModel.getValue());
        context.setTemplateId(templateModel.getId());

        // Statement
        //context.setStatement(statementModel.getStatement());
        //context.setStatementId(statementModel.getId());

        // Range
        //context.setMaxValue(rangeModel.getMaxValue());
        //context.setMinValue(rangeModel.getMinValue());


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
