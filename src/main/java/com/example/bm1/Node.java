package com.example.proyecto_bm;

public class Node {
    //nodo siguiente
    private Node next;
    //coordenada de fila
    private int i;
    //coordenada de columna
    private int j;
    //estado si es completamente seguro para un humano saber si hay mina en la
    //casilla representada por el nodo
    private boolean isInListaS;
    private boolean isInListaI;


    /**
     * Constructor de Objeto nodo
     * @param i, coordenada de fila del nodo
     * @param j, coordenada de columna del nodo
     */
    public Node(int i,int j){
        System.out.println("q");
        this.i=i;
        this.j=j;
        //no tiene nodo siguiente ni se sabe si es mina
        this.next = null;
        this.isInListaS=false;
        this.isInListaI=false;
    }

    /**
     * Metodo que permite cambiar el valor de nodo siguiente
     * @param nodo, nodo que va a ser el siguiente al nodo actual
     */
    public void setNext(Node nodo){
        this.next=nodo;
        //System.out.println(nodo.getI());
        //System.out.println(nodo.getJ());
    }

    /**
     * Metodo que permite cambiar la coordenada i del nodo
     * @param i, coordenada de fila por la cual se va a cambiar
     */
    public void setI(int i){
        this.i=i;
    }

    /**
     * Metodo que permite cambiar la coordenada i del nodo
     * @param j, coordenada de fila por la cual se va a cambiar
     */
    public void setJ(int j){
        this.j=j;
    }

    /**
     * Metodo que retorna el nodo siguiente
     * @return nodo siguiente
     */
    public Node getNext() {
        return this.next;
    }

    /**
     * Metodo que retorna la coordenada i del nodo
     * @return coordenada i del nodo
     */
    public int getI(){
        return this.i;
    }

    /**
     * Metodo que retorna la coordenada j del nodo
     * @return coordenada j del nodo
     */
    public int getJ(){
        return this.j;
    }

    public void setInListaS(){
        this.isInListaS = true;
    }

    public void setInListaI(){
        this.isInListaI = true;
    }

    /**
     * Metodo que retorna si es humana mente posible saber si es mina
     * @return si es humana mente posible saber si es mina
     */
    public boolean getInListaS(){
        return this.isInListaS;
    }

    public boolean getInListaI(){
        return this.isInListaI;
    }
}


