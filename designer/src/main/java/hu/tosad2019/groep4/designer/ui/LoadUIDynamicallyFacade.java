package hu.tosad2019.groep4.designer.ui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoadUIDynamicallyFacade {

    private LoadUI loadUI = new LoadUI();

    public void loadUICompoent(String businessRule, VBox vbox, HBox hbox) {

        if(businessRule.equals("Attribute Range Rule")) {
            loadUI.loadAttributeRangeRule(vbox, hbox);
        }

        if(businessRule.equals("Attribute compare rule")) {
            loadUI.loadAttributeCompareRule(vbox, hbox);
        }

    }

}

