package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.dao.DbColumnDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;

import java.util.List;

public class PersistencyService implements IPersistencyService {
    public BusinessRuleContext getBusinessRuleById(int id) {

        // DAO
        BusinessRuleDao brDao = new BusinessRuleDao();
        DbColumnDao dcDao = new DbColumnDao();

        // Models
        BusinessRuleModel businessRuleModel = brDao.find(id);
        BusinessRuleTypeModel businessRuleTypeModel = businessRuleModel.getType();
        List<DbColumnModel> dbColumns = dcDao.findByRuleId(id);

        // Context
        BusinessRuleContext context = this.getCorrectType(businessRuleTypeModel.getName());

        context.setName(businessRuleModel.getName());
        context.setDescription(businessRuleModel.getDescription());

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