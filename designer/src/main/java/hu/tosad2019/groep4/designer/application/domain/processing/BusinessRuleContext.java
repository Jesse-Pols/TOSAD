package hu.tosad2019.groep4.designer.application.domain.processing;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;

public class BusinessRuleContext {

    public BusinessRuleContext(BusinessRuleModel businessRule) {
        this.businessRule = businessRule;
    }

    /* PROPERTIES */
    private BusinessRuleModel businessRule;

    /* GETTERS */
    // Business Rule
    public String getName() {
        return this.businessRule.getName();
    }
    public String getDescription() {
        return this.businessRule.getDescription();
    }

}
