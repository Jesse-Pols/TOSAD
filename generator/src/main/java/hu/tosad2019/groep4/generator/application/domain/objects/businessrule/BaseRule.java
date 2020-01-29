package hu.tosad2019.groep4.generator.application.domain.objects.businessrule;

public abstract class BaseRule implements BusinessRule{

    private String code;
    private String name;
    private int id;
    private String failureMessage;

    public BaseRule(String code, String name, String failureMessage){
        this(code, name, 0, failureMessage);
    }

    public BaseRule(String code, String name, int id, String failureMessage) {
        this.code = code;
        this.name = name;
        this.id = id;
        this.failureMessage = failureMessage;
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

    @Override
    public String getFailureMessage() {
        return this.failureMessage;
    }
}
