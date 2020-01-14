package hu.tosad2019.groep4.generator.domain.objects.businessrule;

public class BaseRule {

    private String code;
    private String name;
    private String description;

    public BaseRule(String code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
