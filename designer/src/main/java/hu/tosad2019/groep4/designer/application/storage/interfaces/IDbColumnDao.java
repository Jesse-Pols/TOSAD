package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;

import java.util.List;

public interface IDbColumnDao {
    DbColumnModel find(int id);
    List<DbColumnModel> findByRuleId(int rule_id);
}
