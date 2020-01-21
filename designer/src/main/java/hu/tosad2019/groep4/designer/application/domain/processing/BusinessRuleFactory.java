package hu.tosad2019.groep4.designer.application.domain.processing;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.Range;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.*;

import java.util.Map;

public class BusinessRuleFactory {
    private BusinessRuleType type;
    private Map<String, String> attributes;

    public BusinessRuleFactory(BusinessRuleType type, Map<String,String> attributes){
        this.type = type;
        this.attributes = attributes;
    }

    public void MakeBusinessRule(){

        /*
        IBusinessRule rule = null;

        switch (this.type){
            case AttributeCompareRule:
                rule = createAttributeCompareRule(attributes);
                break;
            case AttributeRangeRule:
                rule = createAttributeRangeRule(attributes);
                break;
            default:
                System.out.println(this.type + " != iets");
                break;
        }


        return rule;

         */
    }

    private AttributeCompareRule createAttributeCompareRule(Map<String, String> attributes){
        AttributeCompareRule rule = null;
        if (
                this.containsBasicAttributes(attributes) &&
                attributes.containsKey(Attribute.not.toString()) &&
                attributes.containsKey(Attribute.table.toString()) &&
                attributes.containsKey(Attribute.column.toString()) &&
                attributes.containsKey(Attribute.operator.toString()) &&
                attributes.containsKey(Attribute.specifiedvalue.toString())
        ){
            String code = attributes.get(Attribute.code.toString());
            String name = attributes.get(Attribute.name.toString());
            String description = attributes.get(Attribute.description.toString());

            String notString = attributes.get(Attribute.not.toString());
            String columnName = attributes.get(Attribute.column.toString());
            String tableName = attributes.get(Attribute.table.toString());
            String operatorString = attributes.get(Attribute.operator.toString());
            String specifiedValueString = attributes.get(Attribute.specifiedvalue.toString());



            boolean not = Boolean.parseBoolean(notString);
            Column column = new Column(tableName, columnName);
            Operator operator = Operator.valueOf(operatorString);
            SpecifiedValue specifiedValue = new SpecifiedValue(specifiedValueString);

            AttributeCompareRuleContext context = new AttributeCompareRuleContext(column, not, operator, specifiedValue);

            rule = new AttributeCompareRule(code, name, description, context);


        }
        return rule;
    }

    private boolean containsBasicAttributes(Map<String, String> attributes){
        if (
                attributes.containsKey(Attribute.code.toString()) &&
                attributes.containsKey(Attribute.name.toString()) &&
                attributes.containsKey(Attribute.description.toString())
        ){
            return true;
        }
        return false;
    }

    private AttributeRangeRule createAttributeRangeRule(Map<String, String> attributes){
        AttributeRangeRule rule = null;
        if (
                this.containsBasicAttributes(attributes) &&
                attributes.containsKey(Attribute.table.toString()) &&
                attributes.containsKey(Attribute.column.toString()) &&
                attributes.containsKey(Attribute.not.toString()) &&
                attributes.containsKey(Attribute.foreachrow.toString()) &&
                attributes.containsKey(Attribute.minvalue.toString()) &&
                attributes.containsKey(Attribute.maxvalue.toString()) &&
                attributes.containsKey(Attribute.minvalueoperator.toString()) &&
                attributes.containsKey(Attribute.maxvalueoperator.toString())
        ){
            String code = attributes.get(Attribute.code.toString());
            String name = attributes.get(Attribute.name.toString());
            String description = attributes.get(Attribute.description.toString());

            String notString = attributes.get(Attribute.not.toString());
            String foreachRowString = attributes.get(Attribute.foreachrow.toString());
            String columnName = attributes.get(Attribute.column.toString());
            String tableName = attributes.get(Attribute.table.toString());
            String minValueString = attributes.get(Attribute.minvalue.toString());
            String maxValueString = attributes.get(Attribute.minvalue.toString());
            String minValueOperatorString = attributes.get(Attribute.minvalueoperator.toString());
            String maxValueOperatorString = attributes.get(Attribute.maxvalueoperator.toString());


            Column columnn = new Column(tableName, columnName);

            Operator minvalueOperator = Operator.valueOf(minValueOperatorString);
            Operator maxValueOperator = Operator.valueOf(maxValueOperatorString);
            Range range = new Range(Integer.parseInt(minValueString), Integer.parseInt(maxValueString), minvalueOperator, maxValueOperator);

            AttributeRangeRuleContext context = new AttributeRangeRuleContext(Boolean.parseBoolean(foreachRowString), Boolean.parseBoolean(notString), columnn, range);

            rule = new AttributeRangeRule(code, name, description, context);
        }

        return rule;
    }
}
