package hu.tosad2019.groep4.designer.dataaccess.persistency;

import hu.tosad2019.groep4.designer.dataaccess.objects.domainobjects.BusinessRule;

public class PersistencyService {

    public void saveBusinessRule(BusinessRule businessRule){

        String code = businessRule.getCode();
        String description = businessRule.getDescription();
        String name = businessRule.getName();

        System.out.println(code);
        System.out.println(description);
        System.out.println(name);



    }

}
