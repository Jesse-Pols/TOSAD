package hu.tosad2019.groep4.designer.application.storage;

import java.util.ArrayList;
import java.util.List;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleCategoryDao;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleTypeDao;
import hu.tosad2019.groep4.designer.application.storage.dao.DbColumnDao;
import hu.tosad2019.groep4.designer.application.storage.dao.ListDao;
import hu.tosad2019.groep4.designer.application.storage.dao.RangeDao;
import hu.tosad2019.groep4.designer.application.storage.dao.SpecifiedValueDao;
import hu.tosad2019.groep4.designer.application.storage.dao.StatementDao;
import hu.tosad2019.groep4.designer.application.storage.dao.TemplateDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.StatementModel;

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

    protected BusinessRuleContext convertIdToContext(int id) throws Exception {

        // Get businessrule, return null if businessrule doesn't exist
        BusinessRuleModel businessRule = businessRuleDao.find(id);
        if (businessRule == null) throw new Exception("Given ID has no business rule match");

        // Get type, return null if type doesn't exist
        BusinessRuleTypeModel type = businessRule.getType();
        if (type == null) throw new Exception("Given ID has no business rule type match");

        // Generate context object
        BusinessRuleContext context = this.getCorrectType(type.getName());

        // Business Rule
        context.setName(businessRule.getName());
        context.setId(businessRule.getId());
        context.setDescription(businessRule.getDescription());
        context.setFailure(businessRule.getFailure());
        context.setIsNot(businessRule.getIsNot());

        // Type
        //context.setTypeId(type.getId());

        // Category
        //BusinessRuleCategoryModel category = type.getCategory();
        //if (category != null) {
          //  context.setCategory(category.getName());
          //  context.setCategoryId(category.getId());
        //}

        // Template
        //TemplateModel template = type.getTemplate();
        //if (template != null) {
          //  context.setTemplate(template.getValue());
            //context.setTemplateId(template.getId());
        //}

        // Statement
        @SuppressWarnings("unchecked")
		List<StatementModel> statements = (List<StatementModel>) statementDao.findAllByRuleId(id);
        StatementModel statement = null;
        if (!statements.isEmpty()) {
            statement = statements.get(0);
        }

        // Range
        @SuppressWarnings("unchecked")
		List<RangeModel> ranges = (List<RangeModel>) rangeDao.findAllByRuleId(id);
        RangeModel range = null;
        if (!ranges.isEmpty()) {
            range = ranges.get(0);
        }
        //context.setMaxValue(range.getMaxValue());
        //context.setMinValue(range.getMinValue());
        //context.setMaxOperator(range.getMaxOperator());
        //context.setMinOperator(range.getMinOperator());

        // List
        /*
        List<ListModel> lists = listDao.findAllByRuleId(id);
        ListModel list = null;
        if (!lists.isEmpty()) {
            list = lists.get(0);
        }

        if (list != null) {
            //context.setListId(list.getId());
            // listvalues
        }

        /*
        List<SpecifiedValue> businessRuleValues = specifiedValueDao.findAllByRuleId(id);
        if (!businessRuleValues.isEmpty()) {
            context.setBusinessRuleValues(businessRuleValues);
        }

         */



        

        // Specified Values

        







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
        System.out.println("HIERI" + context);
        return context;
    }

    protected List<BusinessRuleContext> loopThroughBusinessRules(List<BusinessRuleModel> businessRuleModels) throws Exception {
    	System.out.println("Loop " + businessRuleModels);
        List<BusinessRuleContext> businessRuleContexts = new ArrayList<>();
        for (BusinessRuleModel businessRule : businessRuleModels) {
        	BusinessRuleContext context = this.convertIdToContext(businessRule.getId());
            businessRuleContexts.add(context);
        }
        System.out.println("Loop " + businessRuleContexts);
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
