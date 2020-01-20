package hu.tosad2019.groep4.generator.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Range")
public class RangeModel {

    @Id
    private int id;

    private int min;
    private int max;
    private int column1;
    private int column2;

    public RangeModel(int min, int max, int column1, int column2) {
        this.min = min;
        this.max = max;
        this.column1 = column1;
        this.column2 = column2;
    }

    public RangeModel() {}

}

