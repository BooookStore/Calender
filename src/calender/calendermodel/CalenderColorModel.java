/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.calendermodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * カレンダーを表すモデルクラスです。
 * 名前（文字列）のプロパティに加え、色のプロパティを持つ事ができます。
 * @author bookstore
 */
public class CalenderColorModel extends CalenderModel {

    /**
     * カレンダーが持つ色の要素です
     */
    private ObjectProperty<Color> color;

    public void setColor(Color color) {
        this.color.set(color);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> Property() {
        return color;
    }
    
    /**
     * フィールドを初期状態で初期化します。
     */
    public CalenderColorModel(){
        super();
        this.color = new SimpleObjectProperty<>(Color.WHITE);
    }

    /**
    * 引数により、初期値を指定可能です
    * @param calenderName
    * @param color 
    */
    public CalenderColorModel(String calenderName,Color color){
        super(calenderName);
        this.color = new SimpleObjectProperty<>(color);
    }

}
