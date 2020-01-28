package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.*;
import hu.tosad2019.groep4.designer.application.storage.objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        // Get businessrule, return null if businessrule doesn't exist
        BusinessRuleModel businessRule = businessRuleDao.find(id);
        if (businessRule == null) { return null; }

        // Get type, return null if type doesn't exist
        BusinessRuleTypeModel type = businessRule.getType();
        if (type == null) { return null; }

        // Generate context object
        BusinessRuleContext context = this.getCorrectType(type.getName());

        // Business Rule
        context.setName(businessRule.getName());
        context.setId(businessRule.getId());
        context.setDescription(businessRule.getDescription());
        context.setFailure(businessRule.getFailure());
        context.setIsNot(businessRule.getIsNot());

        // Type
        context.setTypeId(type.getId());

        // Category
        BusinessRuleCategoryModel category = type.getCategory();
        if (category != null) {
            context.setCategory(category.getName());
            context.setCategoryId(category.getId());
        }

        // Template
        TemplateModel template = type.getTemplate();
        if (template != null) {
            context.setTemplate(template.getValue());
            context.setTemplateId(template.getId());
        }

        // Statement
        List<StatementModel> statements = statementDao.findAllByRuleId(id);
        if (!statements.isEmpty()) {
            StatementModel statement = statements.get(0);
            context.setStatement(statement.getStatement());
            context.setStatementId(statement.getId());
        }

        // Range
        List<RangeModel> ranges = rangeDao.findAllByRuleId(id);
        if (!ranges.isEmpty()) {
            RangeModel range = ranges.get(0);
            context.setMaxValue(range.getMaxValue());
            context.setMinValue(range.getMinValue());
            context.setMaxOperator(range.getMaxOperator().getOperator());
            context.setMinOperator(range.getMinOperator().getOperator());
        }

        // List
        List<ListModel> lists = listDao.findAllByRuleId(id);
        ListModel list = null;
        if (!lists.isEmpty()) {
            list = lists.get(0);
        }

        if (list != null) {
            context.setListId(list.getId());

            List<SpecifiedValueModel> listSpecifiedValues = specifiedValueDao.findAllByListId(list.getId());
            List<String> stringList = new ArrayList<String>();

            if (!listSpecifiedValues.isEmpty()) {
                for (SpecifiedValueModel value : listSpecifiedValues) {
                    stringList.add(value.getValue());
                }
            }
            context.setListValues(stringList);
        }

        List<SpecifiedValueModel> businessRuleValues = specifiedValueDao.findAllByRuleId(id);
        List<String> businessRuleValuesToString = new ArrayList<String>();

        if (!businessRuleValues.isEmpty()) {
            for (SpecifiedValueModel value : businessRuleValues) {
                businessRuleValuesToString.add(value.getValue());
            }
            context.setBusinessRuleValues(businessRuleValuesToString);
        }

        return context;
    }

    protected List<BusinessRuleContext> loopThroughBusinessRules(List<BusinessRuleModel> businessRuleModels) {
        List<BusinessRuleContext> businessRuleContexts = new ArrayList<>();
        for (BusinessRuleModel businessRule : businessRuleModels) {
            businessRuleContexts.add(this.convertIdToContext(businessRule.getId()));
        }
        return businessRuleContexts;
    }

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
