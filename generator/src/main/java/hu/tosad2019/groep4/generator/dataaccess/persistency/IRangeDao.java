package hu.tosad2019.groep4.generator.dataaccess.persistency;

import hu.tosad2019.groep4.generator.dataaccess.objects.Range;

public interface IRangeDao {
    void save(Range range);
    void update(Range range);
    void delete(Range range);
}
