package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.ITemplateDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.io.Serializable;
import java.util.List;

public class TemplateDao extends AbstractDao implements ITemplateDao {

    public TemplateModel find(int id) throws DataAccessLayerException {
        return (TemplateModel) super.find(TemplateModel.class, id);
    }

    public int save(TemplateModel templateModel) throws DataAccessLayerException {
        return (Integer) super.saveOrUpdate(templateModel);
    }

    public List<TemplateModel> findByValue(String value) throws DataAccessLayerException {
        return (List<TemplateModel>) findAll(TemplateModel.class, "value = '" + value + "'");
    }

}
