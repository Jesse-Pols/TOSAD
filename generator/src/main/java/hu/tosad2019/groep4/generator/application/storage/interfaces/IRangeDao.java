package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.RangeModel;

public interface IRangeDao {
    RangeModel find(int id);
}
