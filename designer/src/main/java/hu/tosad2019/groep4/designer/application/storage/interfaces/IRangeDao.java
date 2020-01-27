package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

public interface IRangeDao {
    RangeModel find(int id) throws DataAccessLayerException, NotFoundException;
}
