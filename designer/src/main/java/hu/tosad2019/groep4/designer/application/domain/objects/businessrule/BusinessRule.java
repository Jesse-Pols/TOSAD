package hu.tosad2019.groep4.designer.application.domain.objects.businessrule;

public interface BusinessRule {
    public String getCode();

    public String getName();

    public int getId();

    public void setId(int id);
    
    public String getFailure();
}
