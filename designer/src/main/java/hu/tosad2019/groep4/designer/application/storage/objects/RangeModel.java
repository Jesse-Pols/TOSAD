package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.OperatorDao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="Range")
public class RangeModel {

    @Id
    private int id;

    private String min;
    private String max;
    private int min_value_operator;
    private int max_value_operator;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    public RangeModel() { }

    public String getMinValue() {
        return this.min;
    }

    public String getMaxValue() {
        return this.max;
    }

    public Operator getMinOperator() {
        OperatorDao operatorDao = new OperatorDao();
        OperatorModel operatorModel = operatorDao.find(min_value_operator);
        return getCorrectOperator(operatorModel);
    }

    public Operator getMaxOperator() {
        OperatorDao operatorDao = new OperatorDao();
        OperatorModel operatorModel = operatorDao.find(max_value_operator);
        return getCorrectOperator(operatorModel);
    }

    private Operator getCorrectOperator(OperatorModel operatorModel) {
        for (Operator operatorEnum : Operator.values()) {
            String operator = operatorEnum.toString().replaceAll("\\s+", "");

            if (operator.equalsIgnoreCase(operatorModel.getOperator())) {
                return operatorEnum;
            }
        }
        return null;
    }

}

