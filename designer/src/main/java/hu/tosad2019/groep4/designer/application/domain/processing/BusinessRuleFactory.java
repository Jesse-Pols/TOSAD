package hu.tosad2019.groep4.designer.application.domain.processing;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributelistrule.AttributeListRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.entityotherrule.EntityOtherRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.modifyrule.ModifyRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tupleotherrule.TupleOtherRule;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import java.util.Map;
import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.Range;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class BusinessRuleFactory {
    private _BusinessRuleContext ruleContext;
    private BusinessRuleType type;
    private Map<String, String> attributes;

    public BusinessRuleFactory(_BusinessRuleContext ruleContext){
        this.ruleContext = ruleContext;
    }

    public BusinessRule makeBusinessRule(){
        BusinessRule rule = null;

        switch (this.type){
            case AttributeCompareRule:
                rule = this.createAttributeCompareRule();
                break;
            case AttributeRangeRule:
                rule = createAttributeRangeRule();
                break;
            case AttributeListRule:
                rule = createAttributeListRule();
                break;
            case EntityOtherRule:
                rule = createEntityOtherRule();
                break;
            case InterEntityCompareRule:
                rule = createInterEntityCompareRule();
                break;
            case ModifyRule:
                rule = createModifyRule();
                break;
            case TupleCompareRule:
                rule = createTupleCompareRule();
                break;
            case TupleOtherRule:
                rule = createTupleOtherRule();
            default:
                System.out.println(this.type + " != iets");
                break;
        }

        return rule;
    }


    private AttributeCompareRule createAttributeCompareRule(){
        Column column = new Column(ruleContext.getTable(), ruleContext.getColumn());
        SpecifiedValue specifiedValue = new SpecifiedValue(ruleContext.getSpecifiedValue());
        AttributeCompareRuleContext compareRuleContext = new AttributeCompareRuleContext(column, false, ruleContext.getOperator(), specifiedValue);

        return new AttributeCompareRule(ruleContext.getName(), ruleContext.getDescription(), compareRuleContext);
    }


    private AttributeRangeRule createAttributeRangeRule(){
        Column column = new Column(ruleContext.getTable(), ruleContext.getColumn());

        Operator operator = ruleContext.getOperator();
        Operator minValueOperator = null;
        Operator maxValueOperator = null;

        int minValue;
        int maxValue;

        try{
            minValue = Integer.parseInt(ruleContext.getRange_minValue());
            maxValue = Integer.parseInt(ruleContext.getRange_maxValue());
        }
        catch(Exception e){
            System.out.println("cannot parse range values");
            return null;
        }



        if (operator == Operator.NOTBETWEEN){
            minValueOperator = Operator.LESSTHEN;
            maxValueOperator = Operator.GREATERTHAN;
        }
        else if(operator == Operator.BETWEEN){
            minValueOperator = Operator.GREATERTHAN;
            maxValueOperator = Operator.LESSTHEN;
        }

        Range range = new Range(minValue, maxValue, minValueOperator, maxValueOperator);

        AttributeRangeRuleContext attributeRangeRuleContext = new AttributeRangeRuleContext(true, false, column, range);

        return new AttributeRangeRule(ruleContext.getName(), ruleContext.getDescription(), attributeRangeRuleContext);
    }

    private AttributeListRule createAttributeListRule(){
        return null;
    }

    private AttributeOtherRule createAttributeOtherRule(){
        return null;
    }

    private EntityOtherRule createEntityOtherRule(){
        return null;
    }

    private InterEntityCompareRule createInterEntityCompareRule(){
        return null;
    }

    private ModifyRule createModifyRule(){
        return null;
    }

    private TupleCompareRule createTupleCompareRule(){
        return null;
    }

    private TupleOtherRule createTupleOtherRule(){
        return null;
    }
}
