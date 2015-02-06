/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.dayregion;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author bookstore
 */
public class DayRegion extends Region {

    /**
     * 日付
     */
    private final Text dayString = new Text("[Error]");
    
    /**
     * デフォルトの設定
     * @param day 日付
     */
    public DayRegion(int day) {
        setId("dayRegion");

        setMinSize(50,60);
        
        //日付表示の設定
        settingsText(day);
        
        getChildren().add(dayString);
    }
    
    /**
     * dayStirngフィールドの設定を行う
     */
    private void settingsText(int day){
        dayString.setFill(Color.BLACK);
        dayString.setText(String.valueOf(day));
    }
    
    @Override
    protected void layoutChildren(){
        layoutInArea(dayString, 5, 5, 100, 100, getBaselineOffset(), HPos.LEFT, VPos.TOP);
    }
}
