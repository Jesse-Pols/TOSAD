package hu.tosad2019.groep4.designer.application.storage.objects;

import javax.persistence.*;

@Entity(name="List")
public class ListModel {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "list_id_sequence")
    @SequenceGenerator(name = "list_id_sequence", sequenceName = "LIST_SEQUENCE", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private BusinessRuleModel businessRule;

    public ListModel() {}

    public ListModel(BusinessRuleModel businessRuleModel) {
        this.businessRule = businessRuleModel;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) { this.id = id; }
}
