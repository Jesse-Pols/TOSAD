package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="SpecifiedValue")
public class SpecifiedValueModel {

    @Id
    private int id;

    private String value;
    private String type;
    private int rule_id;
    private int list_id;

    public SpecifiedValueModel(String value, String type, int rule_id, int list_id) {
        this.value = value;
        this.type = type;
        this.rule_id = rule_id;
        this.list_id = list_id;
    }
    
    public SpecifiedValueModel() {}

    public int getId() { return id; }
	public String getValue() { return value; }
	public String getType() { return type; }
	public int getRuleId() { return rule_id; }
	public int getListId() { return list_id; }
    
    
}
