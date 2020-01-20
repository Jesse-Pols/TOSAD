package hu.tosad2019.groep4.generator.domain.persistency.dao;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.SpecifiedValueModel;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.ISpecifiedValueDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class SpecifiedValueDao extends AbstractDao implements ISpecifiedValueDao {
    public SpecifiedValueDao() {}

    public SpecifiedValueModel find(int id) throws DataAccessLayerException {
        return (SpecifiedValueModel) super.find(SpecifiedValueModel.class, id);
    }
}
