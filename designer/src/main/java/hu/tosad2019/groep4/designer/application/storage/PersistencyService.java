package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing._BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.dao.DbColumnDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;

public class PersistencyService implements IPersistencyService {
    public BusinessRule getBusinessRuleById(int id) {

        // DAO
        BusinessRuleDao brDao = new BusinessRuleDao();
        DbColumnDao dcDao = new DbColumnDao();

        // Models
        BusinessRuleModel businessRuleModel = brDao.find(id);
        BusinessRuleTypeModel businessRuleTypeModel = businessRuleModel.getType();
        DbColumnModel dbColumnModel =

        // Context
        //_BusinessRuleContext businessRuleContext = this.getCorrectType(businessRuleTypeModel.getName());

        BusinessRuleContext context = new BusinessRuleContext(
                businessRuleModel);





        return null;

    }

    private BusinessRuleType getCorrectType(String businessRuleType) {
        for (BusinessRuleType typeEnum : BusinessRuleType.values()) {
            String type = typeEnum.toString().replaceAll("\\s+", "");

            if (type.equalsIgnoreCase(businessRuleType)) {
                return typeEnum;
            }
        }
        return null;
    }
}