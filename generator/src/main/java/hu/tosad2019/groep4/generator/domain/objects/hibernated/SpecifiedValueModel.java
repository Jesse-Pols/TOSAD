package hu.tosad2019.groep4.generator.domain.objects.hibernated;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="SpecifiedValue")
public class SpecifiedValueModel {

    @Id
    private int id;

    private String column1;
    private String column2;

    public SpecifiedValueModel(String column1, String column2) {
        this.column1 = column1;
        this.column2 = column2;
    }

    public SpecifiedValueModel() {}
}
