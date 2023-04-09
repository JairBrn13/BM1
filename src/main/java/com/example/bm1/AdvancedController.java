package com.example.bm1;

import javafx.scene.control.Button;
import javafx.stage.Stage;



public class AdvancedController {
    private MenuController menuController;
    private Stage stage;

    private Button[][] matrizbotones= new Button[8][8];

    public void init(Stage stage, MenuController menuController) {
        this.menuController = menuController;
        this.stage = stage;
    }
}
