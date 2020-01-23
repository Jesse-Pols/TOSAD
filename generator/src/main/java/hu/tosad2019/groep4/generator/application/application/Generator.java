package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.application.TemplateData;
import hu.tosad2019.groep4.generator.application.application.TemplateParser;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.DatabaseExecution;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;

import java.util.HashMap;

public class Generator {
    private BusinessRule rule;
    public Generator(BusinessRule rule){
        this.rule = rule;
    }

    public boolean generateBusinessRuleOnHost(String dbHostName)
    {
        return false;
    }

    public boolean generateBusinessRuleOnConnectionString(String connectionString){
        String trigger = createTrigger();

        DatabaseExecution databaseExecution = new DatabaseExecution(connectionString);

        return databaseExecution.execute(trigger);
    }

    private String createTrigger(){
        String trigger = "";
        if (AttributeCompareRule.class.equals(rule.getClass())) {
            trigger = generateAttributeCompareRuleTrigger((AttributeCompareRule) rule);
        } else if (AttributeRangeRule.class.equals(rule.getClass())) {
            trigger = generateAttributeRangeRuleTrigger((AttributeRangeRule) rule);
        }

        return trigger;
    }

    private String generateAttributeCompareRuleTrigger(AttributeCompareRule compareRule){

        String templateName = "ATTRIBUTE_COMPARE_RULE";

        HashMap<String, String> variables = new HashMap<>();
        variables.put("trigger_name", TemplateData.getTriggerName(compareRule));
        variables.put("position", "BEFORE");
        variables.put("table_name", compareRule.getColumn().getTableName());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("column1", compareRule.getColumn().getName());
        variables.put("operator", compareRule.getOperator().toString());
        variables.put("value", compareRule.getSpecifiedValue().toString());
        String filledTemplate = TemplateParser.parse(templateName, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }

    private String generateAttributeRangeRuleTrigger(AttributeRangeRule rangeRule){
        String templateName = "ATTRIBUTE_RANGE_RULE";

        HashMap<String, String> variables = new HashMap<>();

        variables.put("trigger_name", TemplateData.getTriggerName(rangeRule));
        variables.put("position", "BEFORE");
        variables.put("table_name", rangeRule.getColumn().getTableName());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("not", "NOT");
        variables.put("column_1", rangeRule.getColumn().getName());
        variables.put("operator_1", rangeRule.getRange().getMinValueOperator().toString());
        variables.put("value_min", Integer.toString(rangeRule.getRange().getMinValue()));
        variables.put("operator", "AND");
        variables.put("column_2", rangeRule.getColumn().getName());
        variables.put("operator_2", rangeRule.getRange().getMaxValueOperator().toString());
        variables.put("value_max", Integer.toString(rangeRule.getRange().getMaxValue()));

        String filledTemplate = TemplateParser.parse(templateName, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }
}
