package hu.tosad2019.groep4.designer.presentation;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class LoadUI {

    public void loadAttributeRangeRule(VBox vbox, HBox hbox) {

        clearCanvas(hbox, vbox);

        ComboBox<String> columnList = createComboBox();
        ComboBox<String> tableList = createComboBox();

        hbox.getChildren().add(columnList);
        hbox.getChildren().add(tableList);

        vbox.getChildren().add(hbox);
    }

    public void loadAttributeCompareRule(VBox vbox, HBox hbox) {

        clearCanvas(hbox, vbox);

        ComboBox<String> columList = createComboBox();
        columList.setPlaceholder(new Label("Select column..."));
        columList.getItems().add("Column1");

        ComboBox<String> tableList = createComboBox();
        tableList.setPlaceholder(new Label("Select table..."));
        tableList.getItems().add("table1");

        ComboBox<String> operatorList = createComboBox();
        operatorList.setPlaceholder(new Label("Select operator..."));
        operatorList.getItems().add("Equal");

        HBox comboHbox = createHbox();
        comboHbox.getChildren().add(columList);
        comboHbox.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(columList, Priority.ALWAYS);

        HBox tableListHBox = createHbox();
        tableListHBox.getChildren().add(tableList);

        HBox operatorListHbox = createHbox();
        operatorListHbox.getChildren().add(operatorList);

//        hbox.getChildren().add(columList);
//        hbox.getChildren().add(tableList);
//        hbox.getChildren().add(operatorList);

        vbox.getChildren().add(comboHbox);
        vbox.getChildren().add(tableListHBox);
        vbox.getChildren().add(operatorListHbox);

    }

    public void clearCanvas(HBox hbox, VBox vbox) {
       hbox.getChildren().clear();
       vbox.getChildren().clear();
    }

    public ComboBox<String> createComboBox() {
        return new ComboBox<String>();
    }

    public HBox createHbox() {
        return new HBox();
    }

}
