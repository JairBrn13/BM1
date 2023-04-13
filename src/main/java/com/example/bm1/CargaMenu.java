package com.example.bm1;

//import org.firmata4j.FirmataDevice;
//import org.firmata4j.SerialException;
//import org .firmata4j.firmata.FirmataSysexMessage;
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

public class CargaMenu extends Application {
    Lista list_general = new Lista();
    Lista list_segura = new Lista();
    Lista list_incert = new Lista();


    //Node node = new Node(0,0);
    @Override
    public void start(Stage primarystage) throws IOException, InterruptedException {


        Button btn1 = new Button("Abrir ventana 1");
        Button btn2 = new Button("Abrir ventana 2");


        // Manejador de eventos para el botón 2

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Crea el Grid para los botones del tablero
                Pane root = new Pane();
                GridPane gridPane = new GridPane();

                gridPane.setHgap(5);
                gridPane.setVgap(5);
                gridPane.setLayoutX(150);
                gridPane.setLayoutY(150);
                root.getChildren().add(gridPane);
                // Crear la escena para la ventana 2
                Scene scene2 = new Scene(root, 596, 620);
                // Crear una nueva instancia de Stage
                Stage ventana2 = new Stage();
                // Establecer la escena en la ventana 2
                ventana2.setScene(scene2);
                // Mostrar la ventana 2
                ventana2.show();
                ventana2.setResizable(false);
                primarystage.close();

                IniciarJuego(gridPane);

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
                        Mbotones[i][j].setGraphic(imagen);
                        Mbotones[i][j].getGraphic().setVisible(false);
                        imagen.setFitHeight(60);
                        imagen.setFitWidth(20);
                        /*
                        Lista list_general = new Lista();
                        Lista list_segura = new Lista();
                        Lista list_incert = new Lista();

                        */

                        Turnos2(Mbotones, tableroBuscaminas, turno, Rand);//, list_general, list_segura, list_incert);
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
                root.getChildren().add(gridPane);
                gridPane.setLayoutX(50);
                gridPane.setLayoutY(70);
                // Crear la escena para la ventana 1
                Scene scene1 = new Scene(root, 700, 720);
                // Crear una nueva instancia de Stage
                Stage ventana1 = new Stage();
                // Establecer la escena en la ventana 1
                ventana1.setScene(scene1);
                // Mostrar la ventana 1
                ventana1.show();
                ventana1.setResizable(false);
                primarystage.close();

                IniciarJuego(gridPane);
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


                        // Crea una variable para mantener el estado de la imagen en el botón
                        Turnos(Mbotones, tableroBuscaminas, turno, Rand);
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


    public static void Turnos(Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, Random Rand) {
        if (turno%2 == 0){
            //TurnosM(Mbotones, tableroBuscaminas, turno, imagen, Rand);
            TurnosJ(Mbotones, tableroBuscaminas, turno, Rand);
        }
        else {
            //TurnosJ(Mbotones, tableroBuscaminas, turno, imagen, Rand);
            TurnosM(Mbotones, tableroBuscaminas, turno, Rand);

        }
    }

    public void Turnos2(Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, Random Rand){//, Lista list_general, Lista list_segura, Lista list_incert) {
        if (turno%2 == 0){
            //TurnosMv2(Mbotones, tableroBuscaminas, turno, imagen, Rand, list_general, list_segura, list_incert);
            TurnosJv2(Mbotones, tableroBuscaminas, turno, Rand);//, list_general, list_segura, list_incert);
        }
        else {
            TurnosMv2(Mbotones, tableroBuscaminas, turno, Rand);//, list_general, list_segura, list_incert);
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
        list_segura.eliminarLista();
        System.out.println("si entra a las seguras");
        /*Random Rs = new Random();
        for (int i = 0; i < this.list_general.getTamaño(); i++) {
            int t = Rs.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
            int t2 = Rs.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
            while(this.list_general.buscar(t,t2) == null){
                Rs = new Random();
                t = Rs.nextInt(8);
                t2 = Rs.nextInt(8);
                try{
                while (this.list_general.buscar(t,t2) == null&&!this.list_general.buscar(t, t2).getInListaS()) {
                    Rs = new Random(); // Mueve la inicialización de Rs aquí
                    t = Rs.nextInt(8);
                    t2 = Rs.nextInt(8);
                }
                }catch (NullPointerException e){

                }
            }


            System.out.println("este es t:" + t+"");
            System.out.println("este es t2:" + t2+"");


            if (!tableroBuscaminas.casillas[this.list_general.buscar(t,t2).getI()][this.list_general.buscar(t,t2).getJ()].isMina() && !this.list_general.buscar(t, t2).getInListaS()){
                 list_segura.agregar(this.list_general.buscar(t,t2));
                 this.list_general.buscar(t,t2).setInListaS();
             }
        }

         */

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {//this.list_general.getTamaño(); i++) {
                Node tmp1 = new Node(i,j);
                System.out.println("Iteración: " + i + ", " + j);
                if (this.list_general.buscar(i,j)!=null){
                    System.out.println("tmp.getI(): " + tmp1.getI());
                    System.out.println("tmp.getJ(): " + tmp1.getJ());
                    if (!tableroBuscaminas.casillas[tmp1.getI()][tmp1.getJ()].isMina() && !tmp1.getInListaS() && !tmp1.getInListaI()){
                    list_segura.agregar(tmp1);
                    list_general.eliminar(tmp1);
                    tmp1.setInListaS();
                    }
                }
            }
        }
        System.out.println(list_segura);
        System.out.println(list_segura.getTamaño());
    }

    public void CasillasIncert( TableroBuscaminas tableroBuscaminas){
        list_incert.eliminarLista();
        System.out.println("si entra a las incert");
       /*
        Random Ri = new Random(); // Mueve la inicialización de Ri aquí
        for (int i = 0; i < this.list_general.getTamaño(); i++) {
            int ri = Ri.nextInt(8); // Actualiza el valor de ri en cada iteración
            int ri2 = Ri.nextInt(8); // Actualiza el valor de ri2 en cada iteración
            while (this.list_general.buscar(ri, ri2) == null) {
                Ri = new Random();
                ri = Ri.nextInt(8);
                ri2 = Ri.nextInt(8);
            }
            System.out.println("este es t:" + ri + "");
            System.out.println("este es t2:" + ri2 + "");
            if (tableroBuscaminas.casillas[this.list_general.buscar(ri, ri2).getI()][this.list_general.buscar(ri, ri2).getJ()].isMina() && !this.list_general.buscar(ri, ri2).getInListaI()) {
                list_incert.agregar(this.list_general.buscar(ri, ri2));
                this.list_general.buscar(ri, ri2).setInListaI();
            }
        }

        */
        //System.out.println(this.list_general.getTamaño());

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {//this.list_general.getTamaño(); i++) {
                Node tmp1 = new Node(i,j);
                //Node tmp = tmp1;
                System.out.println("Iteración: " + i + ", " + j);
                if (this.list_general.buscar(i,j)!=null){
                    System.out.println("tmp.getI(): " + tmp1.getI());
                    System.out.println("tmp.getJ(): " + tmp1.getJ());
                    System.out.println(tmp1.getI());
                    System.out.println(tmp1.getJ());
                    if (tableroBuscaminas.casillas[tmp1.getI()][tmp1.getJ()].isMina() && !tmp1.getInListaI() && !tmp1.getInListaS()) {
                        list_incert.agregar(tmp1);
                        tmp1.setInListaI();
                        list_general.eliminar(tmp1);
                    }
                }
            }
        }
        System.out.println(list_incert);
        System.out.println(list_incert.getTamaño());
    }
/*
    public void CasillasTotales(TableroBuscaminas tableroBuscaminas){
        Node node = new Node(0,0);
        list_general.eliminarLista();
        System.out.println("si entra a totales");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!tableroBuscaminas.casillas[i][j].isAbierta()){
                    System.out.println("si entra a los for");
                    node.setI(i);
                    System.out.println("si entra a I ");
                    node.setJ(j);
                    System.out.println("si entra a J ");
                    list_general.agregar(node);
                    System.out.println(list_general.buscar(i,j).getI());
                    System.out.println(list_general.buscar(i,j).getJ());
                    System.out.println(list_general.buscar(i,j).getNext());
                    System.out.println("si hace los totales");
                }
            }
        }
    }

 */



    public void CasillasTotales(TableroBuscaminas tableroBuscaminas){
        list_general.eliminarLista();
        System.out.println("si entra a totales");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!tableroBuscaminas.casillas[i][j].isAbierta()){
                    System.out.println("si entra a los for");
                    Node node = new Node(i,j);
                    System.out.println("si entra a I ");
                    System.out.println(node.getI());
                    System.out.println("si entra a J ");
                    System.out.println(node.getJ());
                    list_general.agregar(node);
                    System.out.println("si hace los totales");
                }
            }
        }
    }


    public void TurnosMv2 (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, Random Rand){
        System.out.println("si hace el turno M");
        CasillasTotales(tableroBuscaminas);
        CasillasSeguras(tableroBuscaminas);
        CasillasIncert(tableroBuscaminas);
        System.out.println("si hace los metodos");
        System.out.println(list_segura.getTamaño());
        System.out.println(list_incert.getTamaño());

       /*
        int inc = (int)(Math.random()*8);
        int inc2 = (int)(Math.random()*8);
        if (list_incert.getTamaño()>0){
        while(this.list_incert.buscar(inc,inc2)==null){
            //System.out.println("inc entra");
            inc = (int)(Math.random()*8);
            inc2 = (int)(Math.random()*8);
        }
        }
        System.out.println("inc sale");
        if (list_segura.getTamaño()>0) {
            int seg = (int) (Math.random() * 8);
            int seg2 = (int) (Math.random() * 8);
            while (this.list_segura.buscar(seg, seg2) == null) {
                //System.out.println("seg entra");
                seg = (int) (Math.random() * 8);
                seg2 = (int) (Math.random() * 8);
            }
        }

        System.out.println("seg sale");
        */
        if(this.list_segura.getTamaño()==0 || tableroBuscaminas.casillas[this.list_incert.buscarAleatorio().getI()][this.list_incert.buscarAleatorio().getJ()].isAbierta() ){
            if (tableroBuscaminas.casillas[this.list_incert.buscarAleatorio().getI()][this.list_incert.buscarAleatorio().getJ()].isMina()) {
                String mensaje;
                Mbotones[this.list_incert.buscarAleatorio().getI()][this.list_incert.buscarAleatorio().getJ()].setDisable(true);
                Mbotones[this.list_incert.buscarAleatorio().getI()][this.list_incert.buscarAleatorio().getJ()].setGraphic(null);
                Mbotones[this.list_incert.buscarAleatorio().getI()][this.list_incert.buscarAleatorio().getJ()].setText("X");
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if(tableroBuscaminas.casillas[k][l].isMina()){
                            System.out.println("holaaa");
                            Mbotones[k][l].setText("*");
                        }
                        else{
                            System.out.println("gay");
                            Mbotones[k][l].setText("xd");
                        }
                        Mbotones[k][l].setDisable(true);
                    }
                }
                mensaje = "   FELICIDADES!!! GANASTE!  ";
                mostrarMensaje(mensaje);//System.out.println("MAMO_PINGA");
            }
        }else {
            tableroBuscaminas.casillas[this.list_segura.buscarAleatorio().getI()][this.list_segura.buscarAleatorio().getJ()].setAbierta();
            //Mbotones[valorAleatorio1][valorAleatorio2].setStyle("CB3234");
            //Mbotones[valorAleatorio1][valorAleatorio2].setText("X");
            Mbotones[this.list_segura.buscarAleatorio().getI()][this.list_segura.buscarAleatorio().getJ()].setDisable(true);
            tableroBuscaminas.generarNumAdy();
            if (tableroBuscaminas.casillas[this.list_segura.buscarAleatorio().getI()][this.list_segura.buscarAleatorio().getJ()].getNumMinasAlrededor() != 0) {
                tableroBuscaminas.casillas[this.list_segura.buscarAleatorio().getI()][this.list_segura.buscarAleatorio().getJ()].setText(tableroBuscaminas.casillas[this.list_segura.buscarAleatorio().getI()][this.list_segura.buscarAleatorio().getJ()].getNumMinasAlrededor() + "");
                System.out.println("si entra al primero");
                tableroBuscaminas.revelarCeldasSinPistas(this.list_segura.buscarAleatorio().getI(),this.list_segura.buscarAleatorio().getJ());
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
            Turnos2(Mbotones, tableroBuscaminas, turno+1, Rand);//, list_general, list_segura, list_incert);
        }
    }

    public void TurnosJv2(Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, Random Rand){//, Lista list_general, Lista list_segura, Lista list_incert) {
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
                            Turnos2(Mbotones, tableroBuscaminas, turno+1, Rand);//, list_general, list_segura, list_incert);
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


    public static void TurnosM (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, Random Rand) {

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
            Turnos(Mbotones, tableroBuscaminas, turno, Rand);
        }

    }



    public static void TurnosJ (Button[][] Mbotones, TableroBuscaminas tableroBuscaminas, int turno, Random Rand) {
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
                            Turnos(Mbotones, tableroBuscaminas, turno + 1, Rand);
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


