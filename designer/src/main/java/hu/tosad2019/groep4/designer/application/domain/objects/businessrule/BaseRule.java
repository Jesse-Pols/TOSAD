package hu.tosad2019.groep4.designer.application.domain.objects.businessrule;

public abstract class BaseRule implements BusinessRule{

    private String code;
    private String name;
    private int id;
    private String failure;
    
    public BaseRule(String code, String name, String failure, int id) {
        this.code = code;
        this.name = name;
        this.id = id;
        this.failure = failure;
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
    public int getId() { 
    	return id; 
    }

    @Override
    public void setId(int id){
        this.id = id;
    }
    
    @Override
    public String getFailure() {
    	return this.failure;
    }
}

