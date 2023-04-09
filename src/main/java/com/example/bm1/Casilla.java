package com.example.bm1;


import javafx.scene.control.Button;

public class Casilla  extends Button {
    private int posFila;
    private int posColumna;
    private boolean mina;
    private int numMinasAlrededor;

    private boolean abierta;

    public Casilla(int posFila, int posColumna){
        this.posFila = posFila;
        this.posColumna = posColumna;
    }

    public int getPosFila() {
        return posFila;
    }

    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    public int getPosColumna() {
        return posColumna;
    }

    public void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isAbierta(){
        return this.abierta;
    }


    public void setAbierta(){
        this.abierta = true;
    }


    public int getNumMinasAlrededor() {
        return numMinasAlrededor;
    }


    public void setNumMinasAlrededor(int numMinasAlrededor) {
        this.numMinasAlrededor = numMinasAlrededor;
    }}
/*
    public void incrementarNumeroMinasAlrededor(){
        this.numMinasAlrededor++;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }


}

/*
import javafx.scene.control.Button;

public class Casilla extends Button{
    private Button boton;
    private boolean esMina;

    public Casilla() {
        //this.boton = new Button();
        this.esMina = false;
    }

    public Button getBoton() {
        return this.boton;
    }

    public void setBoton(Button boton) {
        this.boton = boton;
    }

    public boolean esMina() {
        return this.esMina;
    }

    public void setMina(boolean esMina) {
        this.esMina = esMina;
    }
}

     */


