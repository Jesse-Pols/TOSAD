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
import hu.tosad2019.groep4.designer.application.storage.dao.OperatorDao;
import hu.tosad2019.groep4.designer.application.storage.dao.RangeDao;
import hu.tosad2019.groep4.designer.application.storage.dao.SpecifiedValueDao;
import hu.tosad2019.groep4.designer.application.storage.dao.StatementDao;
import hu.tosad2019.groep4.designer.application.storage.dao.TemplateDao;
import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.ListModel;
import hu.tosad2019.groep4.designer.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.designer.application.storage.objects.StatementModel;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;

public class AbstractPersistency {

    protected BusinessRuleDao businessRuleDao = new BusinessRuleDao();
    protected BusinessRuleTypeDao businessRuleTypeDao = new BusinessRuleTypeDao();
    protected BasicDao businessRuleCategoryDao = new BusinessRuleCategoryDao();
    protected DbColumnDao dbColumnDao = new DbColumnDao();
    protected BasicDao templateDao = new TemplateDao();
    protected StatementDao statementDao = new StatementDao();
    protected RangeDao rangeDao = new RangeDao();
    protected SpecifiedValueDao specifiedValueDao = new SpecifiedValueDao();
    protected ListDao listDao = new ListDao();
    protected OperatorDao operatorDao = new OperatorDao();

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
        @SuppressWarnings("unchecked")
		List<StatementModel> statements = (List<StatementModel>) statementDao.findByRuleId(id);
        if (!statements.isEmpty()) {
            StatementModel statement = statements.get(0);
            context.setStatement(statement.getStatement());
            context.setStatementId(statement.getId());
        }

        // Range
        @SuppressWarnings("unchecked")
		List<RangeModel> ranges = (List<RangeModel>)rangeDao.findAllByRuleId(id);
        if (!ranges.isEmpty()) {
            RangeModel range = ranges.get(0);
            context.setMaxValue(range.getMaxValue());
            context.setMinValue(range.getMinValue());
            context.setMaxOperator(range.getMaxOperator().getOperator());
            context.setMinOperator(range.getMinOperator().getOperator());
        }

        // List
        @SuppressWarnings("unchecked")
		List<ListModel> lists = (List<ListModel>)listDao.findAllByRuleId(id);
        ListModel list = null;
        if (!lists.isEmpty()) {
            list = lists.get(0);
        }

        if (list != null) {
            context.setListId(list.getId());

            @SuppressWarnings("unchecked")
			List<SpecifiedValueModel> listSpecifiedValues = (List<SpecifiedValueModel>) specifiedValueDao.findAllByListId(list.getId());
            List<String> stringList = new ArrayList<String>();

            if (!listSpecifiedValues.isEmpty()) {
                for (SpecifiedValueModel value : listSpecifiedValues) {
                    stringList.add(value.getValue());
                }
            }
            context.setListValues(stringList);
        }

        @SuppressWarnings("unchecked")
		List<SpecifiedValueModel> businessRuleValues = (List<SpecifiedValueModel>) specifiedValueDao.findByRuleId(id);
        List<String> businessRuleValuesToString = new ArrayList<>();

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

    // Checks if the object exists. Sets the generated or retreived ID
    protected BasicModel checkAndSaveObject(BasicModel object, BasicDao dao, String where) {
        List<?> objects = dao.findWhere(where);
        if (objects.isEmpty()) {
        	// Empty
        	System.err.println("Object couldn't be added. Already exists in the database.");
            object.setId(dao.save(object));
        } else {
            object = (BasicModel) objects.get(0);
        }
        return object;
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
