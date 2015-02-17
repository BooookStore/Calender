package calender.list;

import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author bookstore
 */
public final class CalenderListCellGraph extends HBox {

    /**
     * カレンダーのアイコンプロパティです。 テキストで初期化します。
     */
    private ObjectProperty<Node> icon = new SimpleObjectProperty<>(new Text("[none icon]"));

    @FXML
    private Label nameLabel;

    public CalenderListCellGraph() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/calender/list/CalenderListCellGraph.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CalenderListCell.fxml load error");
        }

        //デフォルトアイコンを左側に表示します。
        getChildren().add(0, icon.getValue());

        //アイコンが変わったら、反映させます。
        iconProperty().addListener((obv, ov, nv) -> {
            getChildren().set(0, obv.getValue());
        });
    }

    /**
     * カレンダーの名前を表示するLabelのText Propertyを返します。
     *
     * @return
     */
    public StringProperty nameLabelTextProperty() {
        return nameLabel.textProperty();
    }

    /**
     * アイコンのプロパティを返します
     *
     * @return
     */
    public ObjectProperty<Node> iconProperty() {
        return icon;
    }

}
