package hu.tosad2019.groep4.designer.domain.processing;


import hu.tosad2019.groep4.designer.domain.objects.Column;
import hu.tosad2019.groep4.designer.domain.objects.Range;
import hu.tosad2019.groep4.designer.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.designer.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.domain.processing.enums.*;


import java.util.HashMap;

public class BusinessRuleFactory {
    private BusinessRuleType type;
    private HashMap<String, String> attributes;

    public BusinessRuleFactory(BusinessRuleType type, HashMap<String,String> attributes){
        this.type = type;
        this.attributes = attributes;
    }

    public BusinessRule MakeBusinessRule(){
        BusinessRule rule = null;

        switch (type){
            case AttributeCompareRule:
                rule = createAttributeCompareRule(attributes);
                break;
            case AttributeRangeRule:
                rule = createAttributeRangeRule(attributes);
                break;
            default:
                break;
        }


        return rule;
    }

    private AttributeCompareRule createAttributeCompareRule(HashMap<String, String> attributes){
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

    private boolean containsBasicAttributes(HashMap<String, String> attributes){
        if (
                attributes.containsKey(Attribute.code.toString()) &&
                attributes.containsKey(Attribute.name.toString()) &&
                attributes.containsKey(Attribute.description.toString())
        ){
            return true;
        }
        return false;
    }

    private AttributeRangeRule createAttributeRangeRule(HashMap<String, String> attributes){
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
