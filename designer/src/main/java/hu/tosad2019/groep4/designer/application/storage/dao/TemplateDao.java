package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class TemplateDao extends AbstractDao implements BasicDao {

    public TemplateModel find(int id) throws DataAccessLayerException {
        return (TemplateModel) super.find(TemplateModel.class, id);
    }
    public List<?> findWhere(String where) throws DataAccessLayerException {
        return findAll(TemplateModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }

}
