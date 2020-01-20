package hu.tosad2019.groep4.generator.domain.objects.hibernated;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Failure")
public class FailureModel {

    @Id
    private int id;

    private String message;
    private int rule;

    public FailureModel(String message, int rule) {
        this.message = message;
        this.rule = rule;
    }

    public FailureModel() {}

}
