/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 * カレンダーを表すモデルクラス
 * @author bookstore
 */
public class CalenderModel {
    private StringProperty calenderName;
    private ObjectProperty<Color> iconColor;
    
    //--ここからJavaFX Property　メソッド
    public void setCalenerName(String str){
        calenderName.set(str);
    }
    
    public String getCalenderName(){
        return calenderName.getValue();
    }
    
    public StringProperty calenderNameProperty(){
        return calenderName;
    }
 
    public void setIconColor(Color color){
        iconColor.set(color);
    }
    
    public Color getIconColor(){
        return iconColor.get();
    }
    
    public ObjectProperty<Color> iconColorProperty(){
        return iconColor;
    }
    //--ここまでJavaFX Property　メソッド
    
    /**
     * フィールドを初期状態で初期化します。
     */
    public CalenderModel(){
        calenderName = new SimpleStringProperty(this,"calenderName","None Name");
        iconColor = new SimpleObjectProperty<>(this,"iconColor",Color.WHITE);
    }
    
    /**
     * 引数により、初期値を指定可能です
     * @param name
     * @param color 
     */
    public CalenderModel(String name,Color color){
        calenderName = new SimpleStringProperty(name);
        iconColor = new SimpleObjectProperty<>(color);
    }
    
}
