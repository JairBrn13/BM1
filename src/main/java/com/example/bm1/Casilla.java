package com.example.proyecto_bm;


import javafx.scene.control.Button;

public class Casilla  extends Button {
    private int posFila;
    private int posColumna;
    private boolean mina = false;
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

    public void setMina() {
        this.mina = true;
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



