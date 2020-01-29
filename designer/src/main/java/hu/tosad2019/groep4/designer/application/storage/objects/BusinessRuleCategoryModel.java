package hu.tosad2019.groep4.designer.application.storage.objects;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicModel;

import javax.persistence.*;

@Entity (name="BUSINESSRULECATEGORY")
public class BusinessRuleCategoryModel implements BasicModel {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "category_id_sequence")
    @SequenceGenerator(name = "category_id_sequence", sequenceName = "BUSINESSRULECATEGORY_SEQUENCE")
    private int ID;

    private String NAME;

    public BusinessRuleCategoryModel(String name) {
        this.NAME = name;
    }

    public BusinessRuleCategoryModel() {}
    
    public String getName() { return this.NAME; }
    public int getId() { return this.ID; }
    public void setId(int id) { this.ID = id; }
}
