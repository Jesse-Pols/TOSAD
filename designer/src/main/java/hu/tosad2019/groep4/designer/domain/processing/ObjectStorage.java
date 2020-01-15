package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.domain.objects.businessrule.BusinessRule;

public interface ObjectStorage {
    public boolean saveBusinessRule(BusinessRule rule);
    public BusinessRule getBusinessRule(String code);
    public boolean deleteBusinessRule(String code);
}
