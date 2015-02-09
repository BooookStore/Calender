/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import calender.list.CalenderListCell;
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
import java.util.function.Function;
import javafx.scene.paint.Color;
import java.util.Map;import javafx.collections.ObservableMap;
;

/**
 * FXML Controller class
 *
 * @author bookstore
 */
public class MainViewController implements Initializable {

    /**
     * カレンダーのDayCellを作り出すファクトリです。外部から設定されます。
     */
    private Function<Integer,Node> dayCellFactory;
    
    /**
     * 日付を作成する関数型インターフェイスの実装を外部へ要求します
     * @param cellFactory 
     */
    public void setCellFactory(Function<Integer,Node> cellFactory){
        this.dayCellFactory = cellFactory;
    }
    
    @FXML
    private BorderPane baseBorderPane;
    
    @FXML
    private GridPane baseGrid;
    
    @FXML
    private ListView<CalenderModel> calenderList;
    
    /**
     * calenderListのためのCalenderModelクラスを格納します
     */
    private final ObservableList<CalenderModel> calenderModelList = FXCollections.observableArrayList();
    
    /**
     * baseGridの各セルを初期化します。
     */
    private void initCell(){
        //セルを初期化
        int day = 1;
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                
                Node cell = dayCellFactory.apply(day);     //セルの作成
                
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
        calenderList.setItems(calenderModelList);
        calenderModelList.add(new CalenderModel());
        calenderModelList.add(new CalenderModel("バイト",Color.BROWN));
        calenderModelList.add(new CalenderModel("学校",Color.BEIGE));
        
        calenderList.setCellFactory(param -> {
            return new CalenderListCell();
        });
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