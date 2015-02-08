/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import javafx.scene.control.ListCell;
import javafx.scene.shape.Rectangle;

/**
 * カレンダーのリストを表すListViewのセル
 *
 * @author bookstore
 */
public class CalenderListCell extends ListCell<CalenderModel> {

    @Override
    protected void updateItem(CalenderModel item, boolean empty) {
        super.updateItem(item, empty);

        Rectangle rect = new Rectangle(100, 20);
        if (item != null) {
            rect.setFill(item.getIconColor());
            setGraphic(rect);
        }

    }

}
