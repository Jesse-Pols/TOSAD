package hu.tosad2019.groep4.generator.domain.persistency.interfaces;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.RangeModel;

public interface IRangeDao {
    RangeModel find(int id);
    void create(RangeModel range);
}
