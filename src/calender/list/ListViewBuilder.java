/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.list;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author bookstore
 */
public class ListViewBuilder {
    
    private ObservableList itemList;
    
    private Callback cellFactory;
    
    public ListViewBuilder setItemList(ObservableList itemList){
        this.itemList = itemList;
        return this;
    }
    
    public ListViewBuilder setCellFactory(Callback cellFactory){
        this.cellFactory = cellFactory;
        return this;
    }
    
    public ListView create(){
        ListView result = new ListView();
        result.setItems(itemList);
        result.setCellFactory(cellFactory);
        return result;
    }
    
}
