package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

public interface ISpecifiedValueDao {
    SpecifiedValueModel find(int id) throws DataAccessLayerException, NotFoundException;
}
