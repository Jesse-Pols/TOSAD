package hu.tosad2019.groep4.generator.domain.businessrule;

public class BaseRule {
    private String code;
    private String name;
    private String description;

    BaseRule(String code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }
}
