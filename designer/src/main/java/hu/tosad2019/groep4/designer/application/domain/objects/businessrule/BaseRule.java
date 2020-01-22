package hu.tosad2019.groep4.designer.application.domain.objects.businessrule;

public abstract class BaseRule implements BusinessRule{
    private String name;
    private String description;

    public BaseRule(String name, String description){
        this.name = name;
        this.description = description;
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

