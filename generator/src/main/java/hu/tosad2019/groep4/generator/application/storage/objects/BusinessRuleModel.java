package hu.tosad2019.groep4.generator.application.storage.objects;

import hu.tosad2019.groep4.generator.application.storage.dao.BusinessRuleTypeDao;
import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicModel;

import javax.persistence.*;

@Entity(name = "BusinessRule")
public class BusinessRuleModel implements BasicModel {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "businessrule_id_sequence")
    @SequenceGenerator(name = "businessrule_id_sequence", sequenceName = "BUSINESSRULE_SEQUENCE")
    private int id;

    private String name;
    private String failure;
    private int is_not;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BusinessRuleTypeModel type;

    public BusinessRuleModel(String name, String failure, int is_not, BasicModel type) {
        this.name = name;
        this.failure = failure;
        this.is_not = is_not;
        this.type = (BusinessRuleTypeModel) type;
    }

    public BusinessRuleModel() {}

    public BusinessRuleTypeModel getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
    public int getId() { return this.id; }
    public String getFailure() { return this.failure; }
    public int getIsNot() { return this.is_not; }

    public void setId(int id) { this.id = id; }

}
