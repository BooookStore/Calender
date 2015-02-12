/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import calender.calendermodel.CalenderModel;
import calender.calenderView.CalenderGridView;
import calender.calendermodel.CalenderColorModel;
import calender.dayregion.VBoxDayCell;
import calender.list.ColorCircleListCell;
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

    /**
     * カレンダーを表すモデルリストです
     */
    private ObservableList<CalenderModel> calenderList;

    @Override
    public void start(Stage primaryStage) throws IOException {

        //カレンダーモデルの作成
        createCalenderList();

        //Rootの作成
        BorderPane root = new BorderPane();

        //DayCell作成ラムダ式を作成
        Function<Integer, Node> func = ((Integer t) -> {
            return new VBoxDayCell(t);
        });

        root.setCenter(new CalenderGridView(func));
        root.setLeft(createCalenderListView());

        Scene scene = new Scene(root, 1200, 700);

        primaryStage.setTitle("カレンダー - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * ListViewを作成します
     * @return
     */
    ListView createCalenderListView() {

        ListView result = new ListViewFactory()
                .setItemList(calenderList)
                .setCellFactory(param -> new ColorCircleListCell())
                .create();

        result.getStylesheets().add("calender/ListViewStyle.css");
        
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 保持するカレンダーモデルを作成します。
     */
    private void createCalenderList() {
        calenderList = FXCollections.observableArrayList();
        calenderList.add(new CalenderColorModel("first", Color.AQUA));
        calenderList.add(new CalenderColorModel("second", Color.CORAL));
        calenderList.add(new CalenderColorModel("thared", Color.BLUE));
    }

}
