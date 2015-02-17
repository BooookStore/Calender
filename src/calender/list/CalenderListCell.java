/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.list;

import calender.calendermodel.CalenderProperties;
import javafx.scene.control.ListCell;

/**
 *
 * @author bookstore
 */
public class CalenderListCell extends ListCell<CalenderProperties> {

    @Override
    protected void updateItem(CalenderProperties item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            CalenderListCellGraph cell = new CalenderListCellGraph();
            cell.nameLabelTextProperty().bind(item.calenderNameProperty()); //カレンダーの名前をバインド
            cell.iconProperty().bind(item.calenderIconProperty());          //カレンダーのアイコンをバインド
            setGraphic(cell);
        }
    }

}
