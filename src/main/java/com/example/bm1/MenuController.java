package com.example.bm1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {
    private Stage stage1;

    @FXML
    private void chargeDum(ActionEvent event) throws IOException {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dummy.fxml"));
                // Cargo la ventana
                Parent root = loader.load();
                // Cojo el controlador
                dummyController controller = loader.getController();
                 //controlador.

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
                stage1.close();
                //controller.crearTableroBuscaminas();
                controller.init(stage, this);
        }





    @FXML
    private void chargeAdv(ActionEvent event) throws IOException {

        // Cargo la vista
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Advanced.fxml"));
        // Cargo la ventana
        Parent root = loader.load();
        // Cojo el controlador
        AdvancedController controller = loader.getController();
        //controlador.

        // Creo el Scene
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        stage1.close();
        controller.init(stage, this);

    }

    public void setStage(Stage primarystage) {
        stage1 = primarystage;
    }

}
