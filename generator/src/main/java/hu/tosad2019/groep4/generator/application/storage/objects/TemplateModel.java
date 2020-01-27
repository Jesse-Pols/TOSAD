package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Template")
public class TemplateModel {

    @Id
    private int id;

    private String value;

    public TemplateModel(String value) {
        this.value = value;
    }

    public TemplateModel() { }

    public String getValue() { return this.value; }
    public int getId() { return this.id; }
}
