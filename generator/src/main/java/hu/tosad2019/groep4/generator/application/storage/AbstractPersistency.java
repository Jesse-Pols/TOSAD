package hu.tosad2019.groep4.generator.application.storage;

import hu.tosad2019.groep4.generator.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.generator.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.generator.application.storage.dao.*;
import hu.tosad2019.groep4.generator.application.storage.objects.*;

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
        BusinessRuleModel businessRule = businessRuleDao.find(id);
        BusinessRuleTypeModel type = businessRule.getType();
        BusinessRuleCategoryModel category = type.getCategory();
        TemplateModel template = type.getTemplate();

        List<StatementModel> statements = statementDao.findAllByRuleId(id);
        StatementModel statement = statements.get(0);

        List<RangeModel> ranges = rangeDao.findAllByRuleId(id);
        RangeModel range = ranges.get(0);

        /* CONTEXT */
        BusinessRuleContext context = this.getCorrectType(businessRule.getType().getName());

        // Business Rule
        context.setName(businessRule.getName());
        context.setId(businessRule.getId());
        context.setDescription(businessRule.getDescription());
        context.setFailure(businessRule.getFailure());
        context.setIsNot(businessRule.getIsNot());

        // Business Type
        context.setTypeId(type.getId());

        // Business Category
        context.setCategory(category.getName());
        context.setCategoryId(category.getId());

        // Template
        context.setTemplate(template.getValue());
        context.setTemplateId(template.getId());

        // Statement
        context.setStatement(statement.getStatement());
        context.setStatementId(statement.getId());

        // Range
        context.setMaxValue(range.getMaxValue());
        context.setMinValue(range.getMinValue());
        context.setMaxOperator(range.getMaxOperator());
        context.setMinOperator(range.getMinOperator());



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
