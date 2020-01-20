package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;

public interface IDbColumnDao {
    DbColumnModel find(int id);
}
