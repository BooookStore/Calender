/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalenderView.DayCell;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author bookstore
 */
public class VBoxDayCell extends VBox {

    @FXML
    private Text day;
    
    /**
     * サイズを初期化
     */
    private void initSize(){
        setMinSize(50, 60);
    }
    
    public VBoxDayCell(int day) {
        try {
            URL fxmlURL = getClass().getResource("/CalenderView/DayCell/vboxDayCell.fxml");
            if (fxmlURL == null) {
                System.out.println("vboxDayCell.fxml file not found.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlURL);
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //セルが表すサイズを初期設定
        initSize();
        
        //引数により、日にちを設定
        this.day.setText(String.valueOf(day));
    }

}
