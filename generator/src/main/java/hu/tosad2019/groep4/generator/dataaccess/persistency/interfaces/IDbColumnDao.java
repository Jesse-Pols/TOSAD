package hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.DbColumn;

public interface IDbColumnDao {
    DbColumn getById(int id);
}
