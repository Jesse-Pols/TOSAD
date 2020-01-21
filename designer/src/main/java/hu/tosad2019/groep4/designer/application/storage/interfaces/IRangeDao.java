package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.RangeModel;

import java.util.List;

public interface IRangeDao {
    RangeModel find(int id);
    void create(RangeModel range);
    void delete(RangeModel range);
    List findAll();
}
