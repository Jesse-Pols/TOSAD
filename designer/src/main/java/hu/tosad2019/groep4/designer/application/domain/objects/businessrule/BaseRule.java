package hu.tosad2019.groep4.designer.application.domain.objects.businessrule;

public abstract class BaseRule implements BusinessRule{
    private String name;
    private String description;
    private int id;

    public BaseRule(String name, String description){
        this(name, description, 0);
    }

    public BaseRule(String name, String description, int id){
        this.name = name;
        this.description = description;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getId(){ return id; };
}

