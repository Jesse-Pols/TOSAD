package hu.tosad2019.groep4.designer.dataaccess.persistency;

import hu.tosad2019.groep4.designer.dataaccess.objects.dataaccesobjects.Range;

public interface IRangeDao {
    void save(Range range);
    void update(Range range);
    void delete(Range range);
}
