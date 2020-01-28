package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="List")
public class ListModel {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    public int getId() {
        return this.id;
    }
}
