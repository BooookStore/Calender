/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalenderPaneFactory;

import CalenderBorderPane.CalenderBorderPane;
import CalenderListView.CalenderListView;
import CalenderView.CalenderView;

/**
 *
 * @author bookstore
 */
public abstract class CalenderPaneFactory {
    
    public CalenderBorderPane createCalenderPane(){
        CalenderBorderPane result = new CalenderBorderPane();
        result.setCalenderList(createCalenderListView());
        result.setCalenderView(createCalenderView());
        
        return result;
    }
    
    protected abstract CalenderListView createCalenderListView();
    
    protected abstract CalenderView createCalenderView();
    
}
