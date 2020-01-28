package hu.tosad2019.groep4.generator.application.storage.objects;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name="TEMPLATE")
public class TemplateModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "template_id_sequence")
    @SequenceGenerator(name = "template_id_sequence", sequenceName = "TEMPLATE_SEQUENCE", initialValue = 1, allocationSize = 1)
    private int ID;

    private String VALUE;

    public TemplateModel(String VALUE) {
        this.VALUE = VALUE;
    }

    public TemplateModel() { }
    
    public String getValue() { return this.VALUE; }
    public int getId() { return this.ID; }

    public void setId(int id) { this.ID = id;}
}
