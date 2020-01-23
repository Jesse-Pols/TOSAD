package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleCategoryDao;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.dao.DbColumnDao;
import hu.tosad2019.groep4.designer.application.storage.objects.*;

import java.util.List;

public class PersistencyService implements IPersistencyService {

    private static PersistencyService instance;

    BusinessRuleDao businessRuleDao = new BusinessRuleDao();
    DbColumnDao dbColumnDao = new DbColumnDao();
    BusinessRuleCategoryDao businessRuleCategoryDao = new BusinessRuleCategoryDao();

    private PersistencyService() {}

    public static PersistencyService getInstance() {
        if(PersistencyService.instance == null) {
            instance = new PersistencyService();
        }

        return instance;
    }

    public BusinessRuleContext getBusinessRuleById(int id) {
        return this.convertIdToContext(id);
    }

    public List<BusinessRuleContext> getAllBusinessRules() {
        List<BusinessRuleModel> businessRuleModels = businessRuleDao.findAll();
        List<BusinessRuleContext> businessRuleContexts = null;
        for (BusinessRuleModel businessRule : businessRuleModels) {
            businessRuleContexts.add(convertIdToContext(businessRule.getId()));
        }

        return businessRuleContexts;
    }

    public List<BusinessRuleContext> findBusinessRuleByName(String name) {
        List<BusinessRuleModel> businessRuleModels = businessRuleDao.findAllByName(name);
        List<BusinessRuleContext> businessRuleContexts = null;
        for (BusinessRuleModel businessRule : businessRuleModels) {
            businessRuleContexts.add(convertIdToContext(businessRule.getId()));
        }

        return businessRuleContexts;
    }

    // Insert if new update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        List<BusinessRuleCategoryModel> categories = businessRuleCategoryDao.findByName(context.getCategory());

        BusinessRuleCategoryModel categoryModel = new BusinessRuleCategoryModel(null);


        // TODO type_id? is_not?
        BusinessRuleModel businessRuleModel = new BusinessRuleModel(context.getName(), context.getDescription(), context.getFailure(), 0,0);

        BusinessRuleTypeModel typeModel = null;

        DbColumnModel dbColumnModel = null;
        ListModel list = null;
        OperatorModel operatorModel = null;
        RangeModel rangeModel = null;
        SpecifiedValueModel specifiedValueModel = null;
        StatementModel statementModel = null;
        TemplateModel templateModel = null;

        return false;
    }

    public boolean deleteBusinessRule(int id) {
        return false;
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

    private BusinessRuleContext convertIdToContext(int id) {

        BusinessRuleModel businessRuleModel = businessRuleDao.find(id);
        BusinessRuleTypeModel businessRuleTypeModel = businessRuleModel.getType();
        List<DbColumnModel> dbColumns = dbColumnDao.findByRuleId(id);

        BusinessRuleContext context = this.getCorrectType(businessRuleTypeModel.getName());
        context.setName(businessRuleModel.getName());
        context.setDescription(businessRuleModel.getDescription());
        context.setFailure(businessRuleModel.getFailure());

        for (DbColumnModel column : dbColumns) {
            if (column.getPosition() == 0) {
                context.setFirstColumn(column.getColumn_name());
                context.setFirstTable(column.getTable_name());
                break;
            }
        }

        // TODO: Operator isn't set; Which operator to set if there are two with the same rule_id?

        return context;
    }
}