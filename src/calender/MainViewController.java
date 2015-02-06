/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import java.util.function.Function;;

/**
 * FXML Controller class
 *
 * @author bookstore
 */
public class MainViewController implements Initializable {

    private Function<Integer,Node> cellFactory;
    
    /**
     * 日付を作成する関数型インターフェイスの実装を外部へ要求
     * @param cellFactory 
     */
    public void setCellFactory(Function<Integer,Node> cellFactory){
        this.cellFactory = cellFactory;
    }
    
    @FXML
    private BorderPane baseBorderPane;
    
    @FXML
    private GridPane baseGrid;
    
    @FXML
    private ListView calenderList;
    
    /**
     * カレンダーリストを表す文字列を格納
     */
    private final ObservableList<String> calenderNameList = FXCollections.observableArrayList();
    
    /**
     * baseGridの各セルを初期化します。
     */
    private void initCell(){
        //セルを初期化
        int day = 1;
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                
                Node cell = cellFactory.apply(day);     //セルの作成
                
                //縦、横に関して、開いているスペースを埋めるように自由に拡張するようにセット
                GridPane.setHgrow(cell, Priority.ALWAYS);
                GridPane.setVgrow(cell, Priority.ALWAYS);
                
                baseGrid.add(cell, j, i);
                day++;
            }
        }
    }
    
    /**
     * calenderListを初期化します。
     */
    private void initCalenderList(){
        calenderList.setItems(calenderNameList);
        calenderNameList.add("DefaultCalender");
        calenderNameList.add("SecondCalender");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        baseGrid.setAlignment(Pos.TOP_LEFT);
        baseGrid.setGridLinesVisible(true);
        
        initCell(); //セルを初期化
        initCalenderList(); //カレンダーリストの初期化
    }    
}