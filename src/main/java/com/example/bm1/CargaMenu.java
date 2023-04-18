package com.example.proyecto_bm;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class CargaMenu extends Application {


//    Enumeration portList = CommPortIdentifier.getPortIdentifiers();
//    CommPortIdentifier portId;
    Lista list_general = new Lista();
    Lista list_segura = new Lista();
    Lista list_incert = new Lista();
    int segundos = 0;
    Label timer = new Label("0 segundos");
    TableroBuscaminas tableroBuscaminas = new TableroBuscaminas(8, 8);
    Button[][] Mbotones = new Button[8][8];
    Button sugerencia1 = new Button("Sugerencia");
    Button sugerencia2 = new Button("Sugerencia");
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        segundos++;
        timer.setText(segundos + " segundos");
    }));
    boolean turno = true;
    PilaS pilaS = new PilaS();
    int cuentaT = 0;
    Random Rand = new Random();

    @Override
    public void start(Stage primarystage) throws IOException, InterruptedException {


//        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
//        CommPortIdentifier portId;
//
//        while (portList.hasMoreElements()) {
//            portId = (CommPortIdentifier) portList.nextElement();
//            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
//                if (portId.getName().equals("COM3")) {
//                    System.out.println("Port found!");
//                    break;
//                }
//            }
//        }
        Button btn1 = new Button("Abrir ventana 1");
        Button btn2 = new Button("Abrir ventana 2");
        // Manejador de eventos para el botón 2

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Crea el Grid para los botones del tablero
                Pane root = new Pane();
                GridPane gridPane = new GridPane();

                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
                timer.setLayoutX(440);
                timer.setLayoutY(15);
                timer.setStyle("");
                gridPane.setHgap(5);
                gridPane.setVgap(5);
                gridPane.setLayoutX(58);
                gridPane.setLayoutY(50);
                sugerencia2.setLayoutX(350);
                sugerencia2.setLayoutY(15);
                root.getChildren().add(gridPane);
                root.getChildren().add(timer);
                root.getChildren().add(sugerencia2);
                // Crear la escena para la ventana 2
                Scene scene2 = new Scene(root, 880, 780);
                // Crear una nueva instancia de Stage
                Stage ventana2 = new Stage();
                // Establecer la escena en la ventana 2
                ventana2.setScene(scene2);
                // Mostrar la ventana 2
                ventana2.show();
                ventana2.setResizable(false);
                primarystage.close();

                sugerencia2.setDisable(true);

                sugerencia2.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle (ActionEvent e){
                        darSugerencia(1);
                    }
                });

                IniciarJuego(gridPane);

            }


            public void IniciarJuego(GridPane root){

                tableroBuscaminas.inicializarCasillas();
                tableroBuscaminas.generarNumAdy();

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        Casilla boton = tableroBuscaminas.casillas[i][j];
                        boton.setStyle("-fx-background-color: #40CFFF");
                        boton.setOnMouseEntered(event -> boton.setStyle("-fx-background-color: #6699CC"));
                        boton.setOnMouseExited(event -> boton.setStyle("-fx-background-color: #40CFFF"));
                        boton.setPrefHeight(75);
                        boton.setPrefWidth(75);

                        GridPane.setConstraints(boton, i, j);
                        root.getChildren().addAll(boton);
                        Mbotones[i][j] = boton;

                    }
                }

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        Image bandera = new Image("file:///Y:/Documents/U/III%20SEMESTRE%20U/DATOS%20I/Proyecto_BM/src/main/resources/com/example/proyecto_bm/banderabuena.png");

                        ImageView imagen = new ImageView(bandera);
                        Mbotones[i][j].setGraphic(imagen);
                        Mbotones[i][j].getGraphic().setVisible(false);
                        imagen.setFitHeight(60);
                        imagen.setFitWidth(20);

                        Turnos2(Mbotones, tableroBuscaminas);
                    }
                }

            }

        });



        // Manejador de eventos para el botón 1
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                // Crea el Grid para los botones del tablero
                Pane root = new Pane();
                GridPane gridPane = new GridPane();

                gridPane.setHgap(5);
                gridPane.setVgap(5);
                gridPane.setLayoutX(78);
                gridPane.setLayoutY(70);
                sugerencia1.setLayoutX(350);
                sugerencia1.setLayoutY(15);
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
                timer.setLayoutX(440);
                timer.setLayoutY(15);
                timer.setStyle("");
                root.getChildren().add(gridPane);
                root.getChildren().add(timer);
                root.getChildren().add(sugerencia1);
                // Crear la escena para la ventana 1
                Scene scene1 = new Scene(root, 880, 780);
                // Crear una nueva instancia de Stage
                Stage ventana1 = new Stage();
                // Establecer la escena en la ventana 1
                ventana1.setScene(scene1);
                // Mostrar la ventana 1
                ventana1.show();
                ventana1.setResizable(false);
                primarystage.close();

                sugerencia1.setDisable(true);

                sugerencia1.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle (ActionEvent e){
                        darSugerencia(0);
                    }
                });

                IniciarJuego(gridPane);
            }
            public void IniciarJuego(GridPane root){

                tableroBuscaminas.inicializarCasillas();
                tableroBuscaminas.generarNumAdy();
                Random Rand = new Random();
                System.out.println(turno);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        Casilla boton = tableroBuscaminas.casillas[i][j];
                        boton.setStyle("-fx-background-color: #40CFFF");
                        boton.setOnMouseEntered(event -> boton.setStyle("-fx-background-color: #6699CC"));
                        boton.setOnMouseExited(event -> boton.setStyle("-fx-background-color: #40CFFF"));
                        boton.setPrefHeight(75);
                        boton.setPrefWidth(75);
                        GridPane.setConstraints(boton, i, j);
                        root.getChildren().addAll(boton);
                        Mbotones[i][j] = boton;

                    }
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        Image bandera = new Image("file:///Y:/Documents/U/III%20SEMESTRE%20U/DATOS%20I/Proyecto_BM/src/main/resources/com/example/proyecto_bm/banderabuena.png");

                        ImageView imagen = new ImageView(bandera);
                        // Asigna el ImageView a cada botón
                        Mbotones[i][j].setGraphic(imagen);
                        Mbotones[i][j].getGraphic().setVisible(false);
                        imagen.setFitHeight(60);
                        imagen.setFitWidth(20);

                        // Crea una variable para mantener el estado de la imagen en el botón
                        Turnos(Mbotones, tableroBuscaminas);
                    }
                }

            }


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
        Image imagenFondo = new Image("file:///Y:/Documents/U/III%20SEMESTRE%20U/DATOS%20I/Proyecto_BM/src/main/resources/com/example/proyecto_bm/Messi_menu_bm%202.jpg");
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


    public void Turnos(Button[][] Mbotones, TableroBuscaminas tableroBuscaminas) {
        if (this.turno){
            TurnosJ(Mbotones, tableroBuscaminas);
        }
        else {
            TurnosM(Mbotones, tableroBuscaminas);

        }
    }

    public void Turnos2(Button[][] Mbotones, TableroBuscaminas tableroBuscaminas){//, Lista list_general, Lista list_segura, Lista list_incert) {
        if (this.turno){
            //TurnosMv2(Mbotones, tableroBuscaminas, turno, imagen, Rand, list_general, list_segura, list_incert);
            TurnosJv2(Mbotones, tableroBuscaminas);
        }
        else {
            TurnosMv2(Mbotones, tableroBuscaminas);
            //TurnosJv2(Mbotones, tableroBuscaminas, turno, imagen, Rand, list_general, list_segura, list_incert);
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


    public void CasillasSeguras(TableroBuscaminas tableroBuscaminas){
        list_segura.eliminarTodos();
        System.out.println("si entra a las seguras");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Node tmp = new Node(i,j);
                System.out.println("Iteración: " + i + ", " + j);
                if (this.list_general.buscar(tmp.getI(), tmp.getJ())!=null){
                    System.out.println("tmp.getI(): " + tmp.getI());
                    System.out.println("tmp.getJ(): " + tmp.getJ());
                    System.out.println(!tableroBuscaminas.casillas[tmp.getI()][tmp.getJ()].isMina()  && !tmp.getInListaS() && tableroBuscaminas.casillas[tmp.getI()][tmp.getJ()].getNumMinasAlrededor()!=-333 && !tmp.getInListaI());
                    if (tableroBuscaminas.casillas[tmp.getI()][tmp.getJ()].isMina() == false && !tmp.getInListaS() && tableroBuscaminas.casillas[tmp.getI()][tmp.getJ()].getNumMinasAlrededor()!=-333 && !tmp.getInListaI()){
                        list_segura.agregar(tmp);
                        tmp.setInListaS();
                    }
                }
            }
        }
        System.out.println(list_segura);
        System.out.println(list_segura.getTamaño());
    }

    public void CasillasIncert( TableroBuscaminas tableroBuscaminas){
        list_incert.eliminarTodos();
        System.out.println("si entra a las incert");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Node tmp = new Node(i,j);
                System.out.println("Iteración: " + i + ", " + j);
                if (this.list_general.buscar(tmp.getI(), tmp.getJ())!=null){
                    System.out.println("tmp.getI(): " + tmp.getI());
                    System.out.println("tmp.getJ(): " + tmp.getJ());
                    if (tableroBuscaminas.casillas[tmp.getI()][tmp.getJ()].isMina() && !tmp.getInListaI() && tableroBuscaminas.casillas[tmp.getI()][tmp.getJ()].getNumMinasAlrededor() ==-333){
                        System.out.println(tableroBuscaminas.casillas[tmp.getI()][tmp.getJ()].isMina());
                        list_incert.agregar(tmp);
                        tmp.setInListaI();
                    }
                }
            }
        }
        System.out.println(list_incert);
        System.out.println(list_incert.getTamaño());
    }

    public void CasillasTotales(TableroBuscaminas tableroBuscaminas){
        list_general.eliminarTodos();
        System.out.println("si entra a totales");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!tableroBuscaminas.casillas[i][j].isAbierta()){
                    System.out.println(tableroBuscaminas.casillas[i][j].isAbierta());
                    Node node = new Node(i,j);
                    System.out.println("node.getI(): " +node.getI());
                    System.out.println("node.getJ(): " +node.getJ());
                    list_general.agregar(node);
                    System.out.println(list_general.buscar(node.getI(), node.getJ()));
                    System.out.println("si hace los totales");
                }
            }
        }
    }


    public void TurnosMv2 (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas){
        System.out.println("Cuenta T:"+cuentaT);
        if (cuentaT>=5){
            sugerencia2.setDisable(false);
        }else{
            sugerencia2.setDisable(true);
        }
        ContarSugerencias();
        System.out.println("si hace el turno M");
        CasillasTotales(tableroBuscaminas);
        CasillasSeguras(tableroBuscaminas);
        CasillasIncert(tableroBuscaminas);
        System.out.println("si hace los metodos");
        System.out.println(list_segura.getTamaño());
        System.out.println(list_incert.getTamaño());

        int refIx = list_incert.buscarAleatorio().getI();
        int refIy = list_incert.buscarAleatorio().getJ();
        System.out.println(refIx);
        System.out.println(refIy);

        if(this.list_segura.getTamaño()<=0 ){
            if (tableroBuscaminas.casillas[refIx][refIy].isMina() || tableroBuscaminas.casillas[refIx][refIy].getNumMinasAlrededor()==-333) {
                System.out.println("ENCONTRO UNA BOMBA");
                String mensaje;
                sugerencia2.setDisable(true);
                Mbotones[refIx][refIy].setDisable(true);
                Mbotones[refIx][refIy].getGraphic().setVisible(false);
                Mbotones[refIx][refIy].setStyle("-fx-background-color: #FF0000");
                Mbotones[refIx][refIy].setText("X");
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if(tableroBuscaminas.casillas[k][l].isMina()){
                            Mbotones[k][l].setText("X");
                        }
                        else{
                            Mbotones[k][l].setText("O");
                        }
                        Mbotones[k][l].getGraphic().setVisible(false);
                        Mbotones[k][l].setDisable(true);
                    }
                }
                timeline.stop();
                mensaje = "   FELICIDADES!!! GANASTE!  ";
                mostrarMensaje(mensaje);
            }
        }else {
            cuentaT++;
            int refSx = list_segura.buscarAleatorio().getI();
            int refSy = list_segura.buscarAleatorio().getJ();
            if (tableroBuscaminas.casillas[refSx][refSy].isMina() || tableroBuscaminas.casillas[refSx][refSy].getNumMinasAlrededor()==-333){
                System.out.println("ENCONTRO UNA BOMBA EN LAS SEGURAS");
            }
            Mbotones[refSx][refSy].setDisable(true);
            if (tableroBuscaminas.casillas[refSx][refSy].getNumMinasAlrededor() != 0) {
                tableroBuscaminas.casillas[refSx][refSy].setText(tableroBuscaminas.casillas[refSx][refSy].getNumMinasAlrededor() + "");
                System.out.println("si entra");
            }
            System.out.println(refSx);
            System.out.println(refSy);
            System.out.println("si entra");
            tableroBuscaminas.revelarCeldasSinPistas(refSx,refSy);
            Mbotones[refSx][refSy].setStyle("-fx-background-color: #008000");
            System.out.println("si sale");
            //turno+=1;
            //System.out.println(turno);
            this.turno = true;
            Turnos2(Mbotones, tableroBuscaminas);
        }
    }

    public void TurnosJv2(Button[][] Mbotones, TableroBuscaminas tableroBuscaminas){
        System.out.println("Cuenta T:"+cuentaT);
        if (cuentaT>=5){
            sugerencia2.setDisable(false);
        }else{
            sugerencia2.setDisable(true);
        }
        ContarSugerencias();
        System.out.println("si hace turno j");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int fila = i;
                int columna = j;
                int finalI = i;
                int finalJ = j;

                Mbotones[i][j].setOnMouseClicked((MouseEvent event) -> {
                    int Columna = GridPane.getRowIndex(Mbotones[fila][columna]);
                    int Fila = GridPane.getColumnIndex(Mbotones[fila][columna]);
                    if (event.getButton() == MouseButton.PRIMARY) {
                        System.out.println("Hola, se preciono el boton en la posicion " + fila + "," + columna + "");
                        Mbotones[Fila][Columna].setDisable(true);
                        if (tableroBuscaminas.casillas[Fila][Columna].isMina()) {
                            String mensaje;
                            sugerencia2.setDisable(true);
                            Mbotones[finalI][finalJ].setGraphic(null);
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    Mbotones[k][l].setDisable(true);
                                }
                            }
                            mensaje = "perdiste";
                            timeline.stop();
                            mostrarMensaje(mensaje);
                            return;
                        } else {
                            cuentaT++;
                            Mbotones[fila][columna].setStyle("-fx-background-color: FF8000");
                            Mbotones[fila][columna].setDisable(true);
                            tableroBuscaminas.revelarCeldasSinPistas(Fila, Columna);
                            this.turno = false;
                            Turnos2(Mbotones, tableroBuscaminas);
                        }
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        // Realizar acción para clic derecho
                        if (Mbotones[Fila][Columna].getGraphic().isVisible()){
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


    public void TurnosM (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas) {
        System.out.println("Cuenta T:"+cuentaT);
        if (cuentaT>=5){
            sugerencia1.setDisable(false);
        }else{
            sugerencia1.setDisable(true);
        }
        ContarSugerencias();
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
            sugerencia1.setDisable(true);
            Mbotones[FilaA][ColumnaA].setDisable(true);
            Mbotones[FilaA][ColumnaA].getGraphic().setVisible(false);
            Mbotones[FilaA][ColumnaA].setStyle("-fx-background-color: #FF0000");
            Mbotones[FilaA][ColumnaA].setText("X");
            for (int k = 0; k < 8; k++) {
                for (int l = 0; l < 8; l++) {
                    if(tableroBuscaminas.casillas[k][l].isMina()){
                        Mbotones[k][l].setText("X");
                    }
                    else{
                        Mbotones[k][l].setText("O");
                    }
                    Mbotones[k][l].getGraphic().setVisible(false);
                    Mbotones[k][l].setDisable(true);
                }
            }

            mensaje = "   FELICIDADES!!! GANASTE!  ";
            timeline.stop();
            mostrarMensaje(mensaje);

        }
        else {
            cuentaT++;
            Mbotones[FilaA][ColumnaA].setDisable(true);
            //tableroBuscaminas.generarNumAdy();
            if (tableroBuscaminas.casillas[FilaA][ColumnaA].getNumMinasAlrededor() != 0) {
                tableroBuscaminas.casillas[FilaA][ColumnaA].setText(tableroBuscaminas.casillas[FilaA][ColumnaA].getNumMinasAlrededor() + "");
                //Turnos(Mbotones, tableroBuscaminas, true, imagen, Rand);
                System.out.println("si entra");
            }
            tableroBuscaminas.revelarCeldasSinPistas(FilaA, ColumnaA);
            Mbotones[FilaA][ColumnaA].setStyle("-fx-background-color: #008000");
            System.out.println("si sale");
            System.out.println(turno);
            this.turno = true;
            Turnos(Mbotones, tableroBuscaminas);
        }

    }



    public void TurnosJ (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas) {
        System.out.println("Cuenta T:"+cuentaT);
        if (cuentaT>=5){
            sugerencia1.setDisable(false);
        }else{
            sugerencia1.setDisable(true);
        }
        ContarSugerencias();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int fila = i;
                int columna = j;
                int finalI = i;
                int finalJ = j;

                Mbotones[i][j].setOnMouseClicked((MouseEvent event) -> {

                    int Columna = GridPane.getRowIndex(Mbotones[fila][columna]);
                    int Fila = GridPane.getColumnIndex(Mbotones[fila][columna]);
                    if (event.getButton() == MouseButton.PRIMARY) {
                        System.out.println("Hola, se preciono el boton en la posicion " + fila + "" + columna + "");
                        //Mbotones[Fila][Columna].setDisable(true);
                        if (tableroBuscaminas.casillas[Fila][Columna].isMina()) {
                            String mensaje;
                            sugerencia1.setDisable(true);
                            Mbotones[finalI][finalJ].setGraphic(null);
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    Mbotones[k][l].setDisable(true);
                                }
                            }
                            mensaje = "perdiste";
                            timeline.stop();
                            mostrarMensaje(mensaje);
                            return;
                        } else {
                            cuentaT++;
                            tableroBuscaminas.revelarCeldasSinPistas(Fila, Columna);
                            Mbotones[fila][columna].setStyle("-fx-background-color: FF8000");
                            this.turno = false;
                            Turnos(Mbotones, tableroBuscaminas);
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

    public void ContarSugerencias(){
        if (pilaS.getTop()>-1){
        if (pilaS.peek()!= null){
            if (tableroBuscaminas.casillas[pilaS.peek().getI()][pilaS.peek().getJ()].isAbierta()){
                pilaS.pop();
            }
        }
        }
        boolean bandera = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!bandera && pilaS.getTop()<5){
                    if (!tableroBuscaminas.casillas[i][j].isMina()&&!tableroBuscaminas.casillas[i][j].isAbierta()){
                        Node sug = new Node(i, j);
                        pilaS.push(sug);
                        bandera = true;
                    }
                } else if (pilaS.getTop()>=6) {
                    System.out.println("Demasiadas sugerencias, pila llena");
                }
            }
        }
    }

    public void darSugerencia(int modo){
        cuentaT = cuentaT-5;
        Node Sug = pilaS.peek();
        pilaS.pop();
        if (tableroBuscaminas.casillas[Sug.getI()][Sug.getJ()].getNumMinasAlrededor()!=0){
        Mbotones[Sug.getI()][Sug.getJ()].setText(tableroBuscaminas.casillas[Sug.getI()][Sug.getJ()].getNumMinasAlrededor()+"");
        }
        Mbotones[Sug.getI()][Sug.getJ()].setStyle("-fx-background-color: #800080");
        Mbotones[Sug.getI()][Sug.getJ()].setDisable(true);
        tableroBuscaminas.revelarCeldasSinPistas(Sug.getI(),Sug.getJ());
        if (modo == 0){
            this.turno = false;
            Turnos(Mbotones,tableroBuscaminas);
        }else{
            this.turno = false;
            Turnos2(Mbotones,tableroBuscaminas);
        }


    }

        public static void main (String[]args){
            launch();
        }
    }


