package hu.tosad2019.groep4.generator.dataaccess.persistency;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.generator.dataaccess.persistency.dao.BusinessRuleDao;
import hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces.IBusinessRuleDao;

public class PersistencyService {
    public void getAllBusinessRules() {

    }
    public void getBusinessRuleById(int id) {
        IBusinessRuleDao brDao = new BusinessRuleDao();
        BusinessRule businessRule = brDao.find(id);
        System.out.println("done");
    }
}
