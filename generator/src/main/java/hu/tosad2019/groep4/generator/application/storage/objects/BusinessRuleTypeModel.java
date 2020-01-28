package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="BusinessRuleType")
public class BusinessRuleTypeModel {

    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private TemplateModel template;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BusinessRuleCategoryModel category;

    public BusinessRuleTypeModel(String name, TemplateModel template, BusinessRuleCategoryModel category) {
        this.name = name;
        this.template = template;
        this.category = category;
    }

    public BusinessRuleTypeModel() {}

    public String getName() { return this.name; }
    public int getId() { return this.id; }
    public TemplateModel getTemplate() { return this.template; }
    public BusinessRuleCategoryModel getCategory() { return this.category; }
}
