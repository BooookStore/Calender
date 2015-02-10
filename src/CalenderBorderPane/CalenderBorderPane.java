package CalenderBorderPane;

import CalenderListView.CalenderListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * アプリケーションのメイン画面を構成するクラス
 * @author bookstore
 */
public class CalenderBorderPane extends BorderPane {
    
    //TODO:Object -> 予定データクラス
    private ObservableList<Object> calenderArray = FXCollections.observableArrayList();
    
    /**
     * カレンダーリストをセットします
     * @param n 
     */
    public void setCalenderList(CalenderListView n){
        super.setLeft(n);
    }
    
    /**
     * カレンダーをセットします
     * @param n 
     */
    public void setCalenderView(Node n){
        super.setCenter(n);
    }
}
