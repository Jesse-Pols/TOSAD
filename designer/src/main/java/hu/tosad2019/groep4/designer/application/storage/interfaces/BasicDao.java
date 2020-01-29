package hu.tosad2019.groep4.designer.application.storage.interfaces;

import java.util.List;

public interface BasicDao {
    List<?> findWhere(String where);
    int save(Object obj);
}
