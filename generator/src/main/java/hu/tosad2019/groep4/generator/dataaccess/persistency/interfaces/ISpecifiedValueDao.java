package hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.SpecifiedValue;

public interface ISpecifiedValueDao {
    SpecifiedValue getById(int id);
}