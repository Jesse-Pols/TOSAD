package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.ITemplateDao;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

public class TemplateDao extends AbstractDao implements ITemplateDao {

    public TemplateModel find(int id) throws DataAccessLayerException, NotFoundException {
        return (TemplateModel) super.find(TemplateModel.class, id);
    }

    public void save(TemplateModel templateModel) throws DataAccessLayerException {
        super.saveOrUpdate(templateModel);
    }

}
