package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.DbColumnModel;

import java.util.List;

public interface IDbColumnDao {
    DbColumnModel find(int id);
    List<DbColumnModel> findByRuleId(int rule_id);
}
