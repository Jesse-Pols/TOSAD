package hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Range {

    @Id
    private int id;

    private int min;
    private int max;
    private int column1;
    private int column2;

    public Range(int min, int max, int column1, int column2) {
        this.min = min;
        this.max = max;
        this.column1 = column1;
        this.column2 = column2;
    }

    public Range() {}

    public void setId(int id) {
        this.id = id;
    }

}

