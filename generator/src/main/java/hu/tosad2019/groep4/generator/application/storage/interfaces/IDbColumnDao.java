package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.DbColumnModel;

public interface IDbColumnDao {
    DbColumnModel find(int id);
}
