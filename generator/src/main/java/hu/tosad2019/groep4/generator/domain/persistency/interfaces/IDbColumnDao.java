package hu.tosad2019.groep4.generator.domain.persistency.interfaces;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.DbColumnModel;

public interface IDbColumnDao {
    DbColumnModel find(int id);
}
