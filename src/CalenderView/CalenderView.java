/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalenderView;

import javafx.scene.layout.GridPane;

/**
 *
 * @author bookstore
 */
public abstract class CalenderView extends GridPane {
    public CalenderView(){
        initCell();
    }
    
    abstract void initCell();
}
