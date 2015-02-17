/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import calender.calendermodel.CalenderProperties;
import calender.list.CalenderListCell;
import calender.list.ListViewBuilder;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * アプリケーションスタート
 *
 * @author bookstore
 */
public class Calender extends Application {

    /**
     * カレンダーのリストです。
     */
    private final ObservableList<CalenderProperties> calenderList = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        //カレンダーのリストを初期化します
        initCalendeerList();
        
        //カレンダーのリストビューを作成します。
        ListView calenderListView = new ListViewBuilder()
                .setItemList(calenderList)
                .setCellFactory(p -> new CalenderListCell())
                .create();
        calenderListView.getStylesheets().add("/calender/ListViewStyle.css");
        
        BorderPane root = new BorderPane();
        root.setLeft(calenderListView);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("カレンダー - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        calenderList.stream().filter((CalenderProperties param) -> "None Name".equals(param.getCalenderName())).forEach(System.out::println);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void initCalendeerList(){
        try{
            calenderList.add(new CalenderProperties());
            calenderList.add(new CalenderProperties());
            calenderList.add(new CalenderProperties());
        }catch(IOException ex){
            
        }
    }
}
