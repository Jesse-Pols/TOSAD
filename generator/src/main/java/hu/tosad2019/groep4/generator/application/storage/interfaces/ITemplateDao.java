package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.TemplateModel;

public interface ITemplateDao {
    TemplateModel find(int id);
    int save(TemplateModel templateModel);
}
