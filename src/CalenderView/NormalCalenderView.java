/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalenderView;

import CalenderView.DayCell.VBoxDayCell;
import javafx.scene.Node;
import javafx.scene.layout.Priority;

/**
 *
 * @author bookstore
 */
public class NormalCalenderView extends CalenderView {

    @Override
    void initCell() {
                //セルを初期化
        int day = 1;
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                
                Node cell = new VBoxDayCell(day);
                
                //縦、横に関して、開いているスペースを埋めるように自由に拡張するようにセット
                setHgrow(cell, Priority.ALWAYS);
                setVgrow(cell, Priority.ALWAYS);
                
                add(cell, j, i);
                day++;
            }
        }
    }
    
}
