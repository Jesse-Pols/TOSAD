package hu.tosad2019.groep4.generator.domain.objects.businessrule;

public abstract class BaseRule implements BusinessRule{

    private String code;
    private String name;
    private String description;

    public BaseRule(String code, String name, String description){
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
