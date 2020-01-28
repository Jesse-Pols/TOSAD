package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;

import java.io.Serializable;

public interface ITemplateDao {
    TemplateModel find(int id);
    int save(TemplateModel templateModel);
}
