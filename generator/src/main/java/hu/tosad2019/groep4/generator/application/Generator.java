package hu.tosad2019.groep4.generator.application;

import hu.tosad2019.groep4.generator.application.template.TemplateData;
import hu.tosad2019.groep4.generator.application.template.TemplateParser;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributerangerule.AttributeRangeRule;

import java.util.HashMap;

public class Generator {
    private BusinessRule rule;
    public Generator(BusinessRule rule){
        this.rule = rule;
    }

    public boolean generateBusinessRule()
    {
        String trigger = createTrigger();


        return false;
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
        variables.put("table_name", compareRule.getColumn().getTable());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("column1", compareRule.getColumn().getColumnName());
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
        variables.put("table_name", rangeRule.getColumn().getTable());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("not", "NOT");
        variables.put("column_1", rangeRule.getColumn().getColumnName());
        variables.put("operator_1", rangeRule.getMinValueOperator().toString());
        variables.put("value_min", rangeRule.getMinValue().toString());
        variables.put("operator", "AND");
        variables.put("column_2", rangeRule.getColumn().getColumnName());
        variables.put("operator_2", rangeRule.getMaxValueOperator().toString());
        variables.put("value_max", rangeRule.getMinValue().toString());

        String filledTemplate = TemplateParser.parse(templateName, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }
}
