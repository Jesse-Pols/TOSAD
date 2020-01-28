package hu.tosad2019.groep4.designer.application.domain.objects.businessrule;

public interface BusinessRule {
    String getDescription();
    String getName();
    int getId();

    //to be deleted later
    void setId(int id);
}
