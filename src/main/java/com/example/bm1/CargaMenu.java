package com.example.bm1;

import jssc.SerialPort;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CargaMenu extends Application {

    @Override
    public void start(Stage primarystage) throws IOException {

        SerialPort serialPort = new SerialPort("COM3");

        Button btn1 = new Button("Abrir ventana 1");
        Button btn2 = new Button("Abrir ventana 2");


        // Manejador de eventos para el botón 2

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Crea el Grid para los botones del tablero
                GridPane root = new GridPane();

                root.setHgap(5);
                root.setVgap(5);
                // Crear una nueva instancia de Stage
                Stage ventana2 = new Stage();
                // Crear la escena para la ventana 2
                Scene scene2 = new Scene(new VBox(), 596, 596);
                // Establecer la escena en la ventana 2
                ventana2.setScene(scene2);
                // Mostrar la ventana 2
                ventana2.show();
                primarystage.close();

                IniciarJuego(root);

            }


            public void IniciarJuego(GridPane root){

                // Agregar efecto al botón
                TableroBuscaminas tableroBuscaminas = new TableroBuscaminas(8, 8);
                //tableroBuscaminas.inicializarCasillas();
                Button[][] Mbotones = new Button[8][8];
                tableroBuscaminas.inicializarCasillas();
                Random rand = new Random();
                Random Rand = new Random();
                AtomicBoolean turno = new AtomicBoolean(false);
                turno.set(true);//rand.nextBoolean();
                System.out.println(turno.get());

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        Casilla boton = tableroBuscaminas.casillas[i][j];
                        boton.setStyle("-fx-background-color: #40CFFF");
                        boton.setOnMouseEntered(event -> boton.setStyle("-fx-background-color: #6699CC"));
                        boton.setOnMouseExited(event -> boton.setStyle("-fx-background-color: #40CFFF"));
                        boton.setPrefHeight(70);
                        boton.setPrefWidth(70);

                        GridPane.setConstraints(boton, i, j);
                        root.getChildren().addAll(boton);
                        Mbotones[i][j] = boton;

                    }
                }

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        final int fila = i;
                        final int columna = j;
                        Image bandera = new Image("file:///Users/jbc/Documents/U/III SEMESTRE U/DATOS I/LogicaProyecto1/BM1/src/main/resources/com/example/bm1/bandera.png");

                        ImageView imagen = new ImageView(bandera);
                        // Asigna el ImageView a cada botón

                        imagen.setFitHeight(60);
                        imagen.setFitWidth(20);

                        //Mbotones[i][j].setGraphic(imagen);
                        //Button boton = Mbotones[i][j];

                        // Asigna el ImageView a cada botón
                        //boton.setGraphic(null);

                        // Crea una variable para mantener el estado de la imagen en el botón
                        //Turnos(Mbotones, tableroBuscaminas, turno.get(), imagen, Rand);
                    }
                }
            }




        });



        // Manejador de eventos para el botón 1
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                // Crea el Grid para los botones del tablero
                GridPane root = new GridPane();

                root.setHgap(5);
                root.setVgap(5);
                // Crear la escena para la ventana 1
                Scene scene1 = new Scene(root, 596, 596);
                // Crear una nueva instancia de Stage
                Stage ventana1 = new Stage();
                // Establecer la escena en la ventana 1
                ventana1.setScene(scene1);
                // Mostrar la ventana 1
                ventana1.show();
                primarystage.close();

                IniciarJuego(root);
            }
            public void IniciarJuego(GridPane root){

                // Agregar efecto al botón
                TableroBuscaminas tableroBuscaminas = new TableroBuscaminas(8, 8);
                //tableroBuscaminas.inicializarCasillas();
                Button[][] Mbotones = new Button[8][8];
                tableroBuscaminas.inicializarCasillas();
                //Random rand = new Random();
                Random Rand = new Random();
                int turno = 0;
                //turno.set(true);//rand.nextBoolean();
                System.out.println(turno);

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        Casilla boton = tableroBuscaminas.casillas[i][j];
                        boton.setStyle("-fx-background-color: #40CFFF");
                        boton.setOnMouseEntered(event -> boton.setStyle("-fx-background-color: #6699CC"));
                        boton.setOnMouseExited(event -> boton.setStyle("-fx-background-color: #40CFFF"));
                        boton.setPrefHeight(70);
                        boton.setPrefWidth(70);

                        GridPane.setConstraints(boton, i, j);
                        root.getChildren().addAll(boton);
                        Mbotones[i][j] = boton;

                    }
                }

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        //final int fila = i;
                        //final int columna = j;
                        Image bandera = new Image("file:///Users/jbc/Documents/U/III SEMESTRE U/DATOS I/LogicaProyecto1/BM1/src/main/resources/com/example/bm1/bandera.png");

                        ImageView imagen = new ImageView(bandera);
                        // Asigna el ImageView a cada botón
                        Mbotones[i][j].setGraphic(imagen);
                        Mbotones[i][j].getGraphic().setVisible(false);
                        imagen.setFitHeight(60);
                        imagen.setFitWidth(20);
                        //Mbotones[i][j].setGraphic(null);

                        //Mbotones[i][j].setGraphic(imagen);
                        //Button boton = Mbotones[i][j];

                        // Asigna el ImageView a cada botón
                        //boton.setGraphic(null);

                        // Crea una variable para mantener el estado de la imagen en el botón
                        Turnos(Mbotones, tableroBuscaminas, turno, imagen, Rand);
                    }
                }

            }

            /*
            public static void TurnosM (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, Boolean turno, ImageView imagen, Random Rand) {
                    String mensaje;
                    int valorAleatorio1 = Rand.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
                    int valorAleatorio2 = Rand.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
                    while (tableroBuscaminas.casillas[valorAleatorio1][valorAleatorio2].isAbierta()) {
                        Rand = new Random();
                        valorAleatorio1 = Rand.nextInt(8);
                        valorAleatorio2 = Rand.nextInt(8);
                        }

                    int ColumnaA = GridPane.getRowIndex(Mbotones[valorAleatorio1][valorAleatorio2]);
                    int FilaA = GridPane.getColumnIndex(Mbotones[valorAleatorio1][valorAleatorio2]);

                    if (tableroBuscaminas.casillas[valorAleatorio1][valorAleatorio2].isMina()) {
                            Mbotones[valorAleatorio1][valorAleatorio2].setDisable(true);
                            Mbotones[valorAleatorio1][valorAleatorio2].setGraphic(null);
                            Mbotones[valorAleatorio1][valorAleatorio2].setText("X");
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    Mbotones[k][l].setDisable(true);
                                }
                            }
                            mensaje = "   FELICIDADES!!! GANASTE!  ";
                            mostrarMensaje(mensaje);//System.out.println("MAMO_PINGA");
                        } else {
                            tableroBuscaminas.casillas[FilaA][ColumnaA].setAbierta();
                            //Mbotones[valorAleatorio1][valorAleatorio2].setStyle("CB3234");
                            //Mbotones[valorAleatorio1][valorAleatorio2].setText("X");
                            Mbotones[FilaA][ColumnaA].setDisable(true);
                            tableroBuscaminas.generarNumAdy();
                            if (tableroBuscaminas.casillas[FilaA][ColumnaA].getNumMinasAlrededor() != 0) {
                                tableroBuscaminas.casillas[FilaA][ColumnaA].setText(tableroBuscaminas.casillas[FilaA][ColumnaA].getNumMinasAlrededor() + "");
                                System.out.println("si entra al primero");
                                tableroBuscaminas.revelarCeldasSinPistas(FilaA, ColumnaA);
                                Turnos(Mbotones, tableroBuscaminas, true, imagen, Rand);
                            }else{
                                System.out.println("si entra");
                                tableroBuscaminas.revelarCeldasSinPistas(FilaA, ColumnaA);
                                Turnos(Mbotones, tableroBuscaminas, true, imagen, Rand);
                            }
                    }

                }

             */


            /*
                // Crear la escena para la ventana 1
                Scene scene1 = new Scene(root, 596, 596);
                // Crear una nueva instancia de Stage
                Stage ventana1 = new Stage();
                // Establecer la escena en la ventana 1
                ventana1.setScene(scene1);
                // Mostrar la ventana 1
                ventana1.show();
                primarystage.close();

             */
    });


        // Crear un VBox para los botones
        Pane pane = new Pane(btn1, btn2);

        btn1.setLayoutX(160);
        btn1.setLayoutY(355);
        btn1.setText("Dummy");
        btn1.setPrefHeight(40);

        btn2.setLayoutX(160);
        btn2.setLayoutY(415);
        btn2.setText("Advanced");
        btn2.setPrefHeight(40);

        // Cargar la imagen de fondo
        Image imagenFondo = new Image("file:///Users/jbc/Documents/U/III SEMESTRE U/DATOS I/LogicaProyecto1/BM1/src/main/resources/com/example/bm1/Messi_menu_bm 2.jpg");
        BackgroundImage fondo = new BackgroundImage(imagenFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        // Establecer el fondo de la ventana principal
        pane.setBackground(new Background(fondo));


        // Crear la escena para la ventana principal
        Scene scene = new Scene(pane, 400, 710);



        // Establecer la escena en la ventana principal
        primarystage.setScene(scene);

        primarystage.setResizable(false);

        // Mostrar la ventana principal
        primarystage.show();
    }


    public static void Turnos(Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, ImageView imagen, Random Rand) {
        if (turno%2 == 0){
            //TurnosM(Mbotones, tableroBuscaminas, turno, imagen, Rand);
            TurnosJ(Mbotones, tableroBuscaminas, turno, imagen, Rand);
        }
        else {
            //TurnosJ(Mbotones, tableroBuscaminas, turno, imagen, Rand);
            TurnosM(Mbotones, tableroBuscaminas, turno, imagen, Rand);

        }
    }


    public static void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Buscaminas");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        //System.exit(0);
    }


    public static void TurnosM (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, ImageView imagen, Random Rand) {
        int valorAleatorio1 = Rand.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
        int valorAleatorio2 = Rand.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
        while (tableroBuscaminas.casillas[valorAleatorio1][valorAleatorio2].isAbierta()) {
            Rand = new Random();
            valorAleatorio1 = Rand.nextInt(8);
            valorAleatorio2 = Rand.nextInt(8);
        }

        int ColumnaA = GridPane.getRowIndex(Mbotones[valorAleatorio1][valorAleatorio2]);
        int FilaA = GridPane.getColumnIndex(Mbotones[valorAleatorio1][valorAleatorio2]);

        if (tableroBuscaminas.casillas[FilaA][ColumnaA].isMina()) {
            String mensaje;
            Mbotones[FilaA][ColumnaA].setDisable(true);
            Mbotones[FilaA][ColumnaA].setGraphic(null);
            Mbotones[FilaA][ColumnaA].setText("X");
            for (int k = 0; k < 8; k++) {
                for (int l = 0; l < 8; l++) {
                    Mbotones[k][l].setDisable(true);
                }
            }
            mensaje = "   FELICIDADES!!! GANASTE!  ";
            mostrarMensaje(mensaje);//System.out.println("MAMO_PINGA");
        }
        else {
            tableroBuscaminas.casillas[FilaA][ColumnaA].setAbierta();
            //Mbotones[valorAleatorio1][valorAleatorio2].setStyle("CB3234");
            //Mbotones[valorAleatorio1][valorAleatorio2].setText("X");
            Mbotones[FilaA][ColumnaA].setDisable(true);
            tableroBuscaminas.generarNumAdy();
            if (tableroBuscaminas.casillas[FilaA][ColumnaA].getNumMinasAlrededor() != 0) {
                tableroBuscaminas.casillas[FilaA][ColumnaA].setText(tableroBuscaminas.casillas[FilaA][ColumnaA].getNumMinasAlrededor() + "");
                System.out.println("si entra al primero");
                tableroBuscaminas.revelarCeldasSinPistas(FilaA, ColumnaA);
                //Turnos(Mbotones, tableroBuscaminas, true, imagen, Rand);
                System.out.println("si entra");
                //tableroBuscaminas.revelarCeldasSinPistas(FilaA, ColumnaA);
                //turno ++;
                //System.out.println(turno);
                //Turnos(Mbotones, tableroBuscaminas, turno, imagen, Rand);
            }
            System.out.println("si sale");
            turno+=1;
            System.out.println(turno);
            Turnos(Mbotones, tableroBuscaminas, turno, imagen, Rand);
        }

    }



    public static void TurnosJ (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, ImageView imagen, Random Rand) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int fila = i;
                int columna = j;
                int finalI = i;
                int finalJ = j;
                //int finalT = turno;
                Mbotones[i][j].setOnMouseClicked((MouseEvent event) -> {

                    int Columna = GridPane.getRowIndex(Mbotones[fila][columna]);
                    int Fila = GridPane.getColumnIndex(Mbotones[fila][columna]);
                    if (event.getButton() == MouseButton.PRIMARY) {
                        System.out.println("Hola, se preciono el boton en la posicion " + fila + "" + columna + "");
                        Mbotones[Fila][Columna].setDisable(true);
                        if (tableroBuscaminas.casillas[Fila][Columna].isMina()) {
                            String mensaje;
                            Mbotones[finalI][finalJ].setGraphic(null);
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    Mbotones[k][l].setDisable(true);
                                }
                            }
                            mensaje = "perdiste";
                            mostrarMensaje(mensaje);
                            return;
                        } else {
                            tableroBuscaminas.generarNumAdy();
                            if (tableroBuscaminas.casillas[Fila][Columna].getNumMinasAlrededor() != 0) {
                                tableroBuscaminas.casillas[Fila][Columna].setText(tableroBuscaminas.casillas[Fila][Columna].getNumMinasAlrededor() + "");
                            }
                            tableroBuscaminas.revelarCeldasSinPistas(Fila, Columna);
                            System.out.println(turno + 1);
                            Turnos(Mbotones, tableroBuscaminas, turno + 1, imagen, Rand);
                        }
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        // Realizar acción para clic derecho
                        if (Mbotones[Fila][Columna].getGraphic().isVisible()){//Mbotones[Fila][Columna].getGraphic() == imagen) {
                            // Si la imagen está activa, elimina la imagen del ImageView
                            Mbotones[Fila][Columna].getGraphic().setVisible(false);
                        } else {
                            // Si la imagen no está activa, carga la imagen en el ImageView
                            Mbotones[Fila][Columna].getGraphic().setVisible(true);
                            //System.out.println("SI");
                        }
                    }
                });
            }
        }}


        public static void main (String[]args){
            launch();
        }
    }


