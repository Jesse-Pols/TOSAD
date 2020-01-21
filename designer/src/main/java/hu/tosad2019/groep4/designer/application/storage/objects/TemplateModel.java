package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Template")
public class TemplateModel {

    @Id
    private int id;

    public TemplateModel() { }
}
