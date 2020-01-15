package hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DbColumn {

    @Id
    private int id;

    private String column1;
    private String column2;

    public DbColumn(String column1, String column2) {
        this.column1 = column1;
        this.column2 = column2;
    }

}
