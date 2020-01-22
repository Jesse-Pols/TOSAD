package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="List")
public class ListModel {

    @Id
    private int id;

    private int rule_id;

    public ListModel(int rule_id) {
        this.rule_id = rule_id;
    }

    public ListModel() { }
}
