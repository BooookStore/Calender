/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import calender.dayregion.VBoxDayCell;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * アプリケーションスタート
 *
 * @author bookstore
 */
public class Calender extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        //コントローラーに対し、日付を表すNodeを作成するラムダ式をセット
        MainViewController controller = new MainViewController();
        controller.setCellFactory((Integer t) -> {
            return new VBoxDayCell(t);
        });
        
        //FXMLLoaderからメインのビューを作成
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/calender/MainView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 1200,700);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
