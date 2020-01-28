package hu.tosad2019.groep4.generator.application.application;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.generator.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.DatabaseExecution;

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

        HashMap<String, String> variables = new HashMap<>();
        variables.put("trigger_name", TemplateData.getTriggerName(compareRule));
        variables.put("position", "BEFORE");
        variables.put("table_name", compareRule.getColumn().getTableName());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("column1", compareRule.getColumn().getName());
        variables.put("operator", compareRule.getOperator().toString());
        variables.put("value", compareRule.getSpecifiedValue().toString());
        String filledTemplate = TemplateParser.parse(compareRule, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }

    private String generateAttributeRangeRuleTrigger(AttributeRangeRule rangeRule){

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

        String filledTemplate = TemplateParser.parse(rangeRule, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }
}
