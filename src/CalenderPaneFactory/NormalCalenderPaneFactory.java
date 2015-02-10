/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalenderPaneFactory;

import CalenderListView.CalenderListView;
import CalenderListView.NormalCalenderListView;
import CalenderView.CalenderView;
import CalenderView.NormalCalenderView;

/**
 *
 * @author bookstore
 */
public class NormalCalenderPaneFactory extends CalenderPaneFactory {

    @Override
    protected CalenderListView createCalenderListView() {
        return new NormalCalenderListView();
    }

    @Override
    protected CalenderView createCalenderView() {
        return new NormalCalenderView();
    }
    
    
}
