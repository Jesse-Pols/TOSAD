package hu.tosad2019.groep4.generator.application.domain.objects.businessrule;

public abstract class BaseRule implements BusinessRule{

    private String code;
    private String name;
    private int id;

    public BaseRule(String code, String name){
        this(code, name, 0);
    }

    public BaseRule(String code, String name, int id) {
        this.code = code;
        this.name = name;
        this.id = id;
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
    public int id() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
