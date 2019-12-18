package hu.tosad2019.groep4.generator.domain.businessrule;

import hu.tosad2019.groep4.generator.domain.Database;
import hu.tosad2019.groep4.generator.domain.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.SpecifiedValue;

import javax.xml.crypto.Data;

public class AttributeCompareRule implements BusinessRule{

    private Database database;
    private boolean not;
    private String table;
    private String column;
    private Operator operator;
    private SpecifiedValue value;



    public AttributeCompareRule(Database database,
                                Boolean not,
                                String table,
                                String column,
                                Operator operator,
                                SpecifiedValue value){
        this.database = database;
        this.not = not;
        this.table = table;
        this.column = column;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
