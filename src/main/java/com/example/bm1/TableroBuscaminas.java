package com.example.proyecto_bm;

public class TableroBuscaminas {
    private static int filas;
    private static int columnas;
    private static int numMinas = 8;

    public Casilla[][] casillas;

    public TableroBuscaminas(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = new Casilla[filas][columnas];
    }

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }


    public void inicializarCasillas(){

        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                this.casillas[i][j] = new Casilla(filas,columnas);
            }
        }
        int minasGeneradas=0;
        while(minasGeneradas != this.numMinas){
            int posTmpFila=(int)(Math.random()*this.casillas.length);
            int posTmpColumna=(int)(Math.random()*this.casillas[0].length);
            System.out.println(posTmpColumna+"" +","+ posTmpFila+"");
            if (!this.casillas[posTmpFila][posTmpColumna].isMina()){
                this.casillas[posTmpFila][posTmpColumna].setMina();
                System.out.println(minasGeneradas+"");
                minasGeneradas++;
            }
            else{
                minasGeneradas = minasGeneradas;
                System.out.println(minasGeneradas+"");
            }
        }
        getCasillas();
    }



    public Casilla[][] getCasillas(){
        //System.out.println(this.casillas+"");
        return this.casillas;
    }


    //Revela de forma recursiva las Celdas que no poseen pistas
    public void revelarCeldasSinPistas(int fila, int columna){

        if (fila < 0 || columna < 0 || fila >= getFilas() || columna >= getColumnas()) {  //Si está fuera del tablero retorne nada
            System.out.println("termina1");
            return;
        }

        if (casillas[fila][columna].isAbierta()) {  //Si la celda fue relevada salga de la ejecucion
            System.out.println("termina2");
            return;
        }

        if (casillas[fila][columna].getNumMinasAlrededor() != 0) {  //Si la casilla tiene pistas, termine la ejecución


            casillas[fila][columna].setAbierta();
            casillas[fila][columna].setText(casillas[fila][columna].getNumMinasAlrededor()+"");
            casillas[fila][columna].setDisable(true);
            System.out.println("termina3");
            return;
        }

        casillas[fila][columna].setAbierta();  //Se marca la celda como revelada
        casillas[fila][columna].setStyle("-fx-background-color: #FFFF00");  //Se le asigna un color
        casillas[fila][columna].setDisable(true);
        System.out.println("termina4");

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                revelarCeldasSinPistas(fila + i, columna + j);
            }
        }
        //System.out.println("tambien entra aqui");

    }




    public boolean pos(int i ,int j){
     if(i>=0&&j>=0&&i<=7&&j<=7){
         return true;
     }else {
         return false;
     }
    }


    /**
     * Se generan los numeros de minas
     * adyacentes y se agregan a la variable
     * numrev en la matriz de valores. Esto
     * se hace para todos los espacios en la matriz.
     */
    public void generarNumAdy() { // genera los numeros de minas adyacentes y los añade a matrizvalores.numrev
        for (int i=0; i<=7; i++) {
            for (int j=0; j<=7; j++) { // indices para recorrer la matriz
                int contador = 0;
                if (!casillas[i][j].isMina()) { // si no hay una mina en el espacio
                    if (pos(i-1, j-1)) { // si el espacio de arriba a la izquierda no se sale del arreglo
                        if (casillas[i-1][j-1].isMina()) { // si el espacio de arriba a la izquierda es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    if (pos(i-1, j)) { // si el espacio de arriba no se sale del arreglo
                        if (casillas[i-1][j].isMina()) { // si el espacio de arriba es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    if (pos(i-1, j+1)) { // si el espacio de arriba a la derecha no se sale del arreglo
                        if (casillas[i-1][j+1].isMina()) { // si el espacio de arriba a la derecha es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    if (pos(i, j-1)) { // si el espacio de la izquierda no se sale del arreglo
                        if (casillas[i][j-1].isMina()) { // si el espacio de la izquierda es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    if (pos(i, j+1)) { // si el espacio de la derecha no se sale del arreglo
                        if (casillas[i][j+1].isMina()) { // si el espacio de la derecha es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    if (pos(i+1, j-1)) { // si el espacio de abajo a la izquierda no se sale del arreglo
                        if (casillas[i+1][j-1].isMina()) { // si el espacio de abajo a la izquierda es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    if (pos(i+1, j)) { // si el espacio de abajo no se sale del arreglo
                        if (casillas[i+1][j].isMina()) { // si el espacio de abajo es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    if (pos(i+1, j+1)) { // si el espacio de abajo a la derecha no se sale del arreglo
                        if (casillas[i+1][j+1].isMina()) { // si el espacio de abajo a la derecha es una mina
                            contador++; // se aumenta el contador
                        }
                    }
                    casillas[i][j].setNumMinasAlrededor(contador); // se asigna el contador a la variable numrev en la matriz de valores
                }
                else if (casillas[i][j].isMina()){ // si el espacio es una mina
                    casillas[i][j].setNumMinasAlrededor(-333); // se le asigna un -333 para representar que hay una mina
                }
            }
        }
    }
}
