package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicModel;

@Entity (name="BusinessRuleType")
public class BusinessRuleTypeModel implements BasicModel {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "type_id_sequence")
    @SequenceGenerator(name = "type_id_sequence", sequenceName = "BUSINESSRULETYPE_SEQUENCE")
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private TemplateModel template;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BusinessRuleCategoryModel category;

    public BusinessRuleTypeModel(String name, BasicModel template, BasicModel category) {
        this.name = name;
        this.template = (TemplateModel) template;
        this.category = (BusinessRuleCategoryModel) category;
    }

    public BusinessRuleTypeModel() {}

    public String getName() { return this.name; }
    public int getId() { return this.id; }
    public TemplateModel getTemplate() { return this.template; }
    public BusinessRuleCategoryModel getCategory() { return this.category; }

    public void setId(int id) { this.id = id; }
}
