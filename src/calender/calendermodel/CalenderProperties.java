package calender.calendermodel;

import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * カレンダーを表すもっとも基礎的なモデルクラスです
 * このモデルクラスではカレンダーが名前（文字列）のプロパティを持ちます。
 * @author bookstore
 */
public class CalenderProperties {

    /**
     * デフォルトのアイコンを生成し、セットします
     * @throws IOException 
     */
    public CalenderProperties() throws IOException {
        //デフォルトのアイコンを設定します。
        Node defaultIcon = FXMLLoader.load(getClass().getResource("/calender/list/defaultIcon.fxml"));
        calenderIcon.set(defaultIcon);
    }
    
    /**
     * カレンダーのアイコンです。
     */
    private final ObjectProperty<Node> calenderIcon = new SimpleObjectProperty<>();

    public Node getCalenderIcon() {
        return calenderIcon.get();
    }

    public void setCalenderIcon(Node value) {
        calenderIcon.set(value);
    }

    public ObjectProperty calenderIconProperty() {
        return calenderIcon;
    }
    
    /**
     * カレンダーの名前です。
     */
    private final StringProperty calenderName = new SimpleStringProperty("None Name");

    public String getCalenderName() {
        return calenderName.get();
    }

    public void setCalenderName(String value) {
        calenderName.set(value);
    }

    public StringProperty calenderNameProperty() {
        return calenderName;
    }
    
    /**
     * カレンダーを識別するID番号です。
     */
    private final ReadOnlyIntegerWrapper calenderID = new ReadOnlyIntegerWrapper(1);

    public int getCalenderID() {
        return calenderID.get();
    }

    public ReadOnlyIntegerProperty calenderIDProperty() {
        return calenderID.getReadOnlyProperty();
    }
    
    /**
     * カレンダーが持つ色を表します
     */
    private final ObjectProperty<Color> calenderColor = new SimpleObjectProperty<>(Color.WHITE);

    public Color getCalenderColor() {
        return calenderColor.get();
    }

    public void setCalenderColor(Color value) {
        calenderColor.set(value);
    }

    public ObjectProperty calenderColorProperty() {
        return calenderColor;
    }

    
}
