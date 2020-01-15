package hu.tosad2019.groep4.designer.dataaccess.persistency;

import hu.tosad2019.groep4.designer.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.designer.dataaccess.objects.domainobjects.IBusinessRule;

public class PersistencyService {

    public void saveBusinessRule(IBusinessRule IBusinessRule){

        String code = IBusinessRule.getCode();
        String description = IBusinessRule.getDescription();
        String name = IBusinessRule.getName();
        BusinessRule businessRule = new BusinessRule(name, description, 1, 2, 3, 4);

    }

}
