package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.SpecifiedValueModel;

public interface ISpecifiedValueDao {
    SpecifiedValueModel find(int id);
}
