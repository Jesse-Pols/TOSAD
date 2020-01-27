package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;

public interface ITemplateDao {
    TemplateModel find(int id);
    void save(TemplateModel templateModel);
}
