package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributelistrule.AttributeListRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRule;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.DatabaseExecution;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.DbConnection;
import hu.tosad2019.groep4.generator.dataaccess.dbaccess.OracleDbConnection;

import java.util.HashMap;

public class Generator {
    private BusinessRule rule;
    private DbConnection connection;

    public Generator(BusinessRule rule, TargetDbContext targetDbContext){
        this.rule = rule;

        if (targetDbContext.getDataBaseType().equals("Oracle")){
            connection = new OracleDbConnection(targetDbContext.getHostname(), targetDbContext.getPort());
            connection.SetCredentials(targetDbContext.getUsername(), targetDbContext.getPassword());
        }
    }

    public boolean generate(){
        String trigger = createTrigger();
        DatabaseExecution databaseExecution = new DatabaseExecution(connection);

        return databaseExecution.execute(trigger);
    }

    private String createTrigger(){
        String trigger = "";
        if (AttributeCompareRule.class.equals(rule.getClass())) {
            trigger = generateAttributeCompareRuleTrigger((AttributeCompareRule) rule);
        } else if (AttributeRangeRule.class.equals(rule.getClass())) {
            trigger = generateAttributeRangeRuleTrigger((AttributeRangeRule) rule);
        }

        return trigger.replaceAll("\n", " ");
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
        variables.put("failure_message", compareRule.getFailureMessage());
        String filledTemplate = TemplateParser.parse(compareRule, variables);
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
        variables.put("failure_message", rangeRule.getFailureMessage());

        String filledTemplate = TemplateParser.parse(rangeRule, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }

    private String generateAttributeListRuleTrigger(AttributeListRule listRule){
        String templateName = "ATTRIBUTE_LIST_RULE";

        HashMap<String, String> variables = new HashMap<>();

        variables.put("trigger_name", TemplateData.getTriggerName(listRule));
        variables.put("position", "BEFORE");
        variables.put("table_name", listRule.getColumn().getTableName());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("not", "NOT");
        variables.put("column_1", listRule.getColumn().getName());
        variables.put("listofvalues", listRule.getSpecifiedValue());
        variables.put("failure_message", listRule.getFailureMessage());

        String filledTemplate = TemplateParser.parse(listRule, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }

    private String generateAttributeOtherRuleTrigger(AttributeOtherRule otherRule){

        String templateName = "ATTRIBUTE_OTHER_RULE";
        HashMap<String, String> variables = new HashMap<>();

        variables.put("trigger_name", TemplateData.getTriggerName(otherRule));
        variables.put("position", "BEFORE");
        variables.put("table_name", otherRule.getColumn().getTableName());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("trigger_code", otherRule.getSQLContraint());
        variables.put("failure_message", otherRule.getFailureMessage());

        String filledTemplate = TemplateParser.parse(otherRule, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }

    private String generateTupleCompareRuleTrigger(TupleCompareRule tupleRule) {

        String templateName = "TUPLE_COMPARE_RULE";
        HashMap<String, String> variables = new HashMap<>();

        variables.put("trigger_name", TemplateData.getTriggerName(tupleRule));
        variables.put("position", "BEFORE");
        variables.put("table_name", tupleRule.getColumn1().getTableName());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("column_1", tupleRule.getColumn1().getName());
        variables.put("operator", tupleRule.getOperator().toString());
        variables.put("column_2", tupleRule.getColumn2().getName());
        variables.put("failure_message", tupleRule.getFailureMessage());

        String filledTemplate = TemplateParser.parse(tupleRule, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }

    private String generateInterEntityCompareRule(InterEntityCompareRule interEntityRule) {

        String templateName = "INTER_ENTITY_COMPARE_RULE";
        HashMap<String, String> variables = new HashMap<>();

        variables.put("trigger_name", TemplateData.getTriggerName(interEntityRule));
        variables.put("position", "BEFORE");
        variables.put("table_name", interEntityRule.getColumn1().getTableName());
        variables.put("for_each_row", "FOR EACH ROW");
        variables.put("column_1", interEntityRule.getColumn1().getName());
        variables.put("operator", interEntityRule.getOperator().toString());
        variables.put("column_2", interEntityRule.getColumn2().getName());
        variables.put("failure_message", interEntityRule.getFailureMessage());

        String filledTemplate = TemplateParser.parse(interEntityRule, variables);
        System.out.println(filledTemplate);

        return filledTemplate;
    }
}
