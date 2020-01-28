package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.ITemplateDao;
import hu.tosad2019.groep4.generator.application.storage.objects.TemplateModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

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
