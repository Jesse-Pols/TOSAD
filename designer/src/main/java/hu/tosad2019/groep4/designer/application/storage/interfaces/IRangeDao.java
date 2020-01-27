package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.RangeModel;

public interface IRangeDao {
    RangeModel find(int id);
}
