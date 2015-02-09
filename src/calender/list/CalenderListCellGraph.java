/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.list;

import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author bookstore
 */
public class CalenderListCellGraph extends HBox {

    @FXML
    private Circle iconCircle;

    @FXML
    private Label nameLabel;

    public CalenderListCellGraph() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/calender/list/CalenderListCell.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CalenderListCell.fxml load error");
        }
    }

    /**
     * カレンダーの名前を表示するLabelのText Propertyを返します。
     * @return 
     */
    public StringProperty nameLabelTextProperty(){
        return nameLabel.textProperty();
    }
    
    /**
     * アイコンの色のFill Propertyを返します。
     * @return 
     */
    public ObjectProperty<Paint> iconCircleFillProperty(){
        return iconCircle.fillProperty();
    }
    
}
