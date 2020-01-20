package hu.tosad2019.groep4.designer.domain.objects.businessrule;

public abstract class BaseRuleI implements BusinessRule{

    private String code;
    private String name;
    private String description;

    public BaseRuleI(String code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

