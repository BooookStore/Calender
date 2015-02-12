/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.list;

import calender.calendermodel.CalenderColorModel;
import javafx.scene.control.ListCell;

/**
 *
 * @author bookstore
 */
public class ColorCircleListCell extends ListCell<CalenderColorModel> {

    @Override
    protected void updateItem(CalenderColorModel item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            CalenderListCellGraph cell = new CalenderListCellGraph();
            cell.nameLabelTextProperty().bind(item.calenderNameProperty());
            System.out.println(item.calenderNameProperty().get());
            setGraphic(cell);
        }
    }

}
