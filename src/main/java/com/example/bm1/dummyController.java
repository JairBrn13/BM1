package com.example.bm1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class dummyController implements Initializable {
    private MenuController menuController;
    private Stage stage;
    //int numFilas=8;
    //int numColumnas=8;
    //int numMinas=16;
    @FXML
    Button Cero_Cero;
    @FXML
    Button Cero_Uno;
    @FXML
    Button Cero_Dos;
    @FXML
    Button Cero_Tres;
    @FXML
    Button Cero_Cuatro;
    @FXML
    Button Cero_Cinco;
    @FXML
    Button Cero_Seis;
    @FXML
    Button Cero_Siete;
    @FXML
    Button Uno_Cero;
    @FXML
    Button Uno_Uno;
    @FXML
    Button Uno_Dos;
    @FXML
    Button Uno_Tres;
    @FXML
    Button Uno_Cuatro;
    @FXML
    Button Uno_Cinco;
    @FXML
    Button Uno_Seis;
    @FXML
    Button Uno_Siete;
    @FXML
    Button Dos_Cero;
    @FXML
    Button Dos_Uno;
    @FXML
    Button Dos_Dos;
    @FXML
    Button Dos_Tres;
    @FXML
    Button Dos_Cuatro;
    @FXML
    Button Dos_Cinco;
    @FXML
    Button Dos_Seis;
    @FXML
    Button Dos_Siete;
    @FXML
    Button Tres_Cero;
    @FXML
    Button Tres_Uno;
    @FXML
    Button Tres_Dos;
    @FXML
    Button Tres_Tres;
    @FXML
    Button Tres_Cuatro;
    @FXML
    Button Tres_Cinco;
    @FXML
    Button Tres_Seis;
    @FXML
    Button Tres_Siete;
    @FXML
    Button Cuatro_Cero;
    @FXML
    Button Cuatro_Uno;
    @FXML
    Button Cuatro_Dos;
    @FXML
    Button Cuatro_Tres;
    @FXML
    Button Cuatro_Cuatro;
    @FXML
    Button Cuatro_Cinco;
    @FXML
    Button Cuatro_Seis;
    @FXML
    Button Cuatro_Siete;
    @FXML
    Button Cinco_Cero;
    @FXML
    Button Cinco_Uno;
    @FXML
    Button Cinco_Dos;
    @FXML
    Button Cinco_Tres;
    @FXML
    Button Cinco_Cuatro;
    @FXML
    Button Cinco_Cinco;
    @FXML
    Button Cinco_Seis;
    @FXML
    Button Cinco_Siete;
    @FXML
    Button Seis_Cero;
    @FXML
    Button Seis_Uno;
    @FXML
    Button Seis_Dos;
    @FXML
    Button Seis_Tres;
    @FXML
    Button Seis_Cuatro;
    @FXML
    Button Seis_Cinco;
    @FXML
    Button Seis_Seis;
    @FXML
    Button Seis_Siete;
    @FXML
    Button Siete_Cero;
    @FXML
    Button Siete_Uno;
    @FXML
    Button Siete_Dos;
    @FXML
    Button Siete_Tres;
    @FXML
    Button Siete_Cuatro;
    @FXML
    Button Siete_Cinco;
    @FXML
    Button Siete_Seis;
    @FXML
    Button Siete_Siete;
    @FXML
    ImageView imageView;


    //Button[][] Matrizbotones1= {{Cero_Cero, Cero_Uno, Cero_Dos, Cero_Tres, Cero_Cuatro, Cero_Cinco,Cero_Seis,Cero_Siete},{Uno_Cero, Uno_Uno, Uno_Dos, Uno_Tres, Uno_Cuatro, Uno_Cinco, Uno_Seis, Uno_Siete},{Dos_Cero, Dos_Uno, Dos_Dos, Dos_Tres, Dos_Cuatro, Dos_Cinco, Dos_Seis, Dos_Siete},{Tres_Cero, Tres_Uno, Tres_Dos, Tres_Tres, Tres_Cuatro, Tres_Cinco, Tres_Seis, Tres_Siete},{Cuatro_Cero, Cuatro_Uno, Cuatro_Dos, Cuatro_Tres, Cuatro_Cuatro, Cuatro_Cinco, Cuatro_Seis, Cuatro_Siete},{Cinco_Cero, Cinco_Uno, Cinco_Dos, Cinco_Tres, Cinco_Cuatro, Cinco_Cinco, Cinco_Seis, Cinco_Siete},{Seis_Cero, Seis_Uno, Seis_Dos, Seis_Tres, Seis_Cuatro, Seis_Cinco, Seis_Seis, Seis_Siete},{Siete_Cero, Siete_Uno, Siete_Dos, Siete_Tres, Siete_Cuatro, Siete_Cinco, Siete_Seis, Siete_Siete}};
    String[][] matrizbotones= {{"Cero_Cero", "Cero_Uno","Cero_Dos","Cero_Tres","Cero_Cuatro","Cero_Cinco","Cero_Seis","Cero_Siete"},{String.valueOf(Uno_Cero), String.valueOf(Uno_Uno), String.valueOf(Uno_Dos), String.valueOf(Uno_Tres), String.valueOf(Uno_Cuatro), String.valueOf(Uno_Cinco), String.valueOf(Uno_Seis), String.valueOf(Uno_Siete)},{String.valueOf(Dos_Cero), String.valueOf(Dos_Uno), String.valueOf(Dos_Dos), String.valueOf(Dos_Tres), String.valueOf(Dos_Cuatro), String.valueOf(Dos_Cinco), String.valueOf(Dos_Seis), String.valueOf(Dos_Siete)},{String.valueOf(Tres_Cero), String.valueOf(Tres_Uno), String.valueOf(Tres_Dos), String.valueOf(Tres_Tres), String.valueOf(Tres_Cuatro), String.valueOf(Tres_Cinco), String.valueOf(Tres_Seis), String.valueOf(Tres_Siete)},{String.valueOf(Cuatro_Cero), String.valueOf(Cuatro_Uno), String.valueOf(Cuatro_Dos), String.valueOf(Cuatro_Tres), String.valueOf(Cuatro_Cuatro), String.valueOf(Cuatro_Cinco), String.valueOf(Cuatro_Seis), String.valueOf(Cuatro_Siete)},{String.valueOf(Cinco_Cero), String.valueOf(Cinco_Uno), String.valueOf(Cinco_Dos), String.valueOf(Cinco_Tres), String.valueOf(Cinco_Cuatro), String.valueOf(Cinco_Cinco), String.valueOf(Cinco_Seis), String.valueOf(Cinco_Siete)},{String.valueOf(Seis_Cero), String.valueOf(Seis_Uno), String.valueOf(Seis_Dos), String.valueOf(Seis_Tres), String.valueOf(Seis_Cuatro), String.valueOf(Seis_Cinco), String.valueOf(Seis_Seis), String.valueOf(Seis_Siete)},{String.valueOf(Siete_Cero), String.valueOf(Siete_Uno), String.valueOf(Siete_Dos), String.valueOf(Siete_Tres), String.valueOf(Siete_Cuatro), String.valueOf(Siete_Cinco), String.valueOf(Siete_Seis), String.valueOf(Siete_Siete)}};
    //Button[][] Matrizbotones = new Button[8][8];
    Button[][] MatrizbotonesAux = new Button[8][8];
    TableroBuscaminas tableroBuscaminas;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //String[][] matrizbotones= {{"Cero_Cero", "Cero_Uno","Cero_Dos","Cero_Tres","Cero_Cuatro","Cero_Cinco","Cero_Seis","Cero_Siete"},{String.valueOf(Uno_Cero), String.valueOf(Uno_Uno), String.valueOf(Uno_Dos), String.valueOf(Uno_Tres), String.valueOf(Uno_Cuatro), String.valueOf(Uno_Cinco), String.valueOf(Uno_Seis), String.valueOf(Uno_Siete)},{String.valueOf(Dos_Cero), String.valueOf(Dos_Uno), String.valueOf(Dos_Dos), String.valueOf(Dos_Tres), String.valueOf(Dos_Cuatro), String.valueOf(Dos_Cinco), String.valueOf(Dos_Seis), String.valueOf(Dos_Siete)},{String.valueOf(Tres_Cero), String.valueOf(Tres_Uno), String.valueOf(Tres_Dos), String.valueOf(Tres_Tres), String.valueOf(Tres_Cuatro), String.valueOf(Tres_Cinco), String.valueOf(Tres_Seis), String.valueOf(Tres_Siete)},{String.valueOf(Cuatro_Cero), String.valueOf(Cuatro_Uno), String.valueOf(Cuatro_Dos), String.valueOf(Cuatro_Tres), String.valueOf(Cuatro_Cuatro), String.valueOf(Cuatro_Cinco), String.valueOf(Cuatro_Seis), String.valueOf(Cuatro_Siete)},{String.valueOf(Cinco_Cero), String.valueOf(Cinco_Uno), String.valueOf(Cinco_Dos), String.valueOf(Cinco_Tres), String.valueOf(Cinco_Cuatro), String.valueOf(Cinco_Cinco), String.valueOf(Cinco_Seis), String.valueOf(Cinco_Siete)},{String.valueOf(Seis_Cero), String.valueOf(Seis_Uno), String.valueOf(Seis_Dos), String.valueOf(Seis_Tres), String.valueOf(Seis_Cuatro), String.valueOf(Seis_Cinco), String.valueOf(Seis_Seis), String.valueOf(Seis_Siete)},{String.valueOf(Siete_Cero), String.valueOf(Siete_Uno), String.valueOf(Siete_Dos), String.valueOf(Siete_Tres), String.valueOf(Siete_Cuatro), String.valueOf(Siete_Cinco), String.valueOf(Siete_Seis), String.valueOf(Siete_Siete)}};
        //tableroBuscaminas = new TableroBuscaminas();
        //tableroBuscaminas.inicializarCasillas();
        imageView.setVisible(false);
        this.MatrizbotonesAux = new Button[][]{{Cero_Cero, Cero_Uno, Cero_Dos, Cero_Tres, Cero_Cuatro, Cero_Cinco, Cero_Seis, Cero_Siete}, {Uno_Cero, Uno_Uno, Uno_Dos, Uno_Tres, Uno_Cuatro, Uno_Cinco, Uno_Seis, Uno_Siete}, {Dos_Cero, Dos_Uno, Dos_Dos, Dos_Tres, Dos_Cuatro, Dos_Cinco, Dos_Seis, Dos_Siete}, {Tres_Cero, Tres_Uno, Tres_Dos, Tres_Tres, Tres_Cuatro, Tres_Cinco, Tres_Seis, Tres_Siete}, {Cuatro_Cero, Cuatro_Uno, Cuatro_Dos, Cuatro_Tres, Cuatro_Cuatro, Cuatro_Cinco, Cuatro_Seis, Cuatro_Siete}, {Cinco_Cero, Cinco_Uno, Cinco_Dos, Cinco_Tres, Cinco_Cuatro, Cinco_Cinco, Cinco_Seis, Cinco_Siete}, {Seis_Cero, Seis_Uno, Seis_Dos, Seis_Tres, Seis_Cuatro, Seis_Cinco, Seis_Seis, Seis_Siete}, {Siete_Cero, Siete_Uno, Siete_Dos, Siete_Tres, Siete_Cuatro, Siete_Cinco, Siete_Seis, Siete_Siete}};
    }


/*
    public void crearTableroBuscaminas() {
        tableroBuscaminas = new TableroBuscaminas();
    }

 */


    public void init(Stage stage, MenuController menuController) {
        this.menuController = menuController;
        this.stage = stage;
    }

    public void clickBtn00(MouseEvent e) {
        if(e.getButton() == MouseButton.PRIMARY) {
           // this.tableroBuscaminas.imprimirTablero();
            //this.tableroBuscaminas.seleccionarCasilla(0,0);
            //System.out.println(MatrizbotonesAux[0][0].getOnAction());
            /*
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++){

             */
            MatrizbotonesAux[0][0].setDisable(true);
            /*if(!tableroBuscaminas.getCasilla(0,0).isMina()){
                MatrizbotonesAux[0][0].setText(tableroBuscaminas.obtenerCasillasAlrededor(0,0)+"");
            }

             */
            MatrizbotonesAux[0][0].setStyle("-fx-background-color: #FF0000");

            int cont = 0;
            //this.tableroBuscaminas.seleccionarCasilla(0,0);
            /*
                System.out.println("huevofrito"+ cont+"");
                MatrizbotonesAux[tableroBuscaminas.getAbiertas()[cont].getPosFila()][tableroBuscaminas.getAbiertas()[cont].getPosColumna()].setStyle("-fx-background-color: #0000FF");
                MatrizbotonesAux[tableroBuscaminas.getAbiertas()[cont].getPosFila()][tableroBuscaminas.getAbiertas()[cont].getPosColumna()].setText(tableroBuscaminas.obtenerCasillasAlrededor(0,0)+"");
                MatrizbotonesAux[tableroBuscaminas.getAbiertas()[cont].getPosFila()][tableroBuscaminas.getAbiertas()[cont].getPosColumna()].setDisable(true);
                cont ++ ;

             */


        } else if(e.getButton() == MouseButton.SECONDARY) {
            imageView.setVisible(!imageView.isVisible());
            System.out.println("HOLA gay");
        }
    }
    /*
    public void clickBtn00(ActionEvent event) {
        if (this.tableroBuscaminas.imprimirTablero()[0][0]=="*"){
            System.out.println("HOLA");
        }else {
            System.out.println("HOLA gay");
        }

    }
     */

}
