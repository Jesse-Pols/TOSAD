package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

import java.util.List;

public interface IDbColumnDao {
    DbColumnModel find(int id) throws DataAccessLayerException, NotFoundException;
    List<DbColumnModel> findByRuleId(int rule_id);
}
