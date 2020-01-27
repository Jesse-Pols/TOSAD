package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

public interface ITemplateDao {
    TemplateModel find(int id) throws DataAccessLayerException, NotFoundException;
    void save(TemplateModel templateModel);
}
