/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.calenderView;

import javafx.scene.layout.GridPane;
import java.util.function.Function;
import javafx.scene.Node;
import javafx.scene.layout.Priority;

/**
 *
 * @author bookstore
 */
public class CalenderGridView extends GridPane {
    
    public CalenderGridView(Function<Integer,Node> func){
        dayCellFactory = func;
        initCell();
    }

    /**
     * DayCellを作成します
     */
    private Function<Integer,Node> dayCellFactory;
    
    /**
     * 外部へDayCellを作成する実装を委託します
     * @param func 
     */
    public void setDayCellFunction(Function func){
        dayCellFactory = func;
    }
    
     /**
     * 各セルを初期化します。
     */
    private void initCell(){
        int day = 1;
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                
                Node cell = dayCellFactory.apply(day);     //セルの作成
                
                //縦、横に関して、開いているスペースを埋めるように自由に拡張するようにセット
                GridPane.setHgrow(cell, Priority.ALWAYS);
                GridPane.setVgrow(cell, Priority.ALWAYS);
                
                add(cell, j, i);
                day++;
            }
        }
    }
    
}
