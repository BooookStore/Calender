/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import calender.calenderView.CalenderGridView;
import calender.dayregion.VBoxDayCell;
import calender.list.CalenderListCell;
import calender.list.ListViewFactory;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.function.Function;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

/**
 * アプリケーションスタート
 *
 * @author bookstore
 */
public class Calender extends Application {

    private ObservableList<CalenderModel> calenderList;

    @Override
    public void start(Stage primaryStage) throws IOException {

//        //コントローラーに対し、日付を表すNodeを作成するラムダ式をセット
//        CalenderBorderPane controller = new CalenderBorderPane();
//        controller.setCellFactory((Integer t) -> {
//            return new VBoxDayCell(t);
//        });
//        
//        //FXMLLoaderからメインのビューを作成
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/calender/MainView.fxml"));
//        loader.setController(controller);
//        Parent root = loader.load();
        
        //カレンダーモデルの作成
        createCalenderList();

        //Rootの作成
        BorderPane root = new BorderPane();

        //DayCell作成ラムダ式を作成
        Function<Integer, Node> func = ((Integer t) -> {
            return new VBoxDayCell(t);
        });

        //ListViewの設定
        ListView listView = new ListView();
        listView.setCellFactory(param -> {
            return new CalenderListCell();
        });
        listView.setItems(calenderList);

        root.setCenter(new CalenderGridView(func));
        root.setLeft(listView);

        Scene scene = new Scene(root, 1200, 700);

        primaryStage.setTitle("カレンダー - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * ListViewを作成します
     * @return 
     */
    ListView createCalenderListView(){
        return new ListViewFactory()
                .setItemList(calenderList)
                .setCellFactory(param -> new CalenderListCell())
                .create();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void createCalenderList() {
        calenderList = FXCollections.observableArrayList();
        calenderList.add(new CalenderModel("Main Calender", Color.RED));
        calenderList.add(new CalenderModel("Second Calender", Color.AQUA));
        calenderList.add(new CalenderModel("Thared Calender", Color.CORAL));
    }

}
