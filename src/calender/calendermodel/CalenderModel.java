package calender.calendermodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * カレンダーを表すもっとも基礎的なモデルクラスです
 * このモデルクラスではカレンダーが名前（文字列）のプロパティを持ちます。
 * @author bookstore
 */
public class CalenderModel {
    
    /**
     * カレンダーの名前です
     */
    final private StringProperty calenderName;

    public void setCalenerName(String str){
        calenderName.set(str);
    }
    
    public String getCalenderName(){
        return calenderName.getValue();
    }
    
    public StringProperty calenderNameProperty(){
        return calenderName;
    }
 
    /**
     * フィールドを初期状態で初期化します。
     */
    public CalenderModel(){
        calenderName = new SimpleStringProperty(this,"calenderName","None Name");
    }
    
    /**
     * 引数により、初期値を指定可能です
     * @param calenderName カレンダーの名前です
     */
    public CalenderModel(String calenderName){
        this.calenderName = new SimpleStringProperty(calenderName);
    }
    
}
