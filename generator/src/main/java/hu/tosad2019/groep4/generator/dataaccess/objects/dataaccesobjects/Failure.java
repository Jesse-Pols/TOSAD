package hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Failure {

    @Id
    private int id;

    private String message;
    private int rule;

    public Failure(String message, int rule) {
        this.message = message;
        this.rule = rule;
    }

    public Failure() {}

}
