package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Statement")
public class StatementModel {

    @Id
    private int id;

    private int rule_id;
    private String statement;

    public StatementModel(int rule_id, String statement) {
        this.rule_id = rule_id;
        this.statement = statement;
    }

    public StatementModel() { }
}
