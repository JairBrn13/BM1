package com.example.bm1;

import java.util.Random;

public class Lista {
    //tamaño de la lista
    private int tamaño;
    //nodo inicial de la lista
    private Node head;

    /**
     * Constructor de la clase lista donde inicializa la estructura con tamaño 0 y sin
     * nodo inicial
     */
    public Lista(){
        //tamaño 0 de la lista
        this.tamaño=0;
        //nodo inicial nulo
        this.head=null;

    }

    /**
     * Metodo para eliminar todo el contenido de la lista mediante la eliminacion
     * de el nodo incial y debido al recolector de basura de java se eliminan los
     * nodos concecuentes
     */
    public void eliminarLista(){
        //nodo inicial nulo
        this.head=null;
        //tamaño a 0 debido a que se vacio
        this.tamaño=0;
    }

    /**
     * Metodo que permite agregar un nodo al final de la lista enlazada
     * @param nodo, nodo a agregar a la lista
     */


    public void agregar(Node nodo){
        //en caso de no tener nodo inicial se guarda el nodo como inicial
        if(this.head==null){
            setHead(nodo);
            //this.head.setNext(null);
        }else{
            Node temp = new Node(this.head.getI(),this.head.getJ());//se crea un nodo temporal para ir recorriendo la lista sin modificarla
            //mienrtras el nodo tenga nodos consecuentes se sigue recorriendo la lista
            while(temp.getNext()!=null){
                temp = temp.getNext();
                //System.out.println("mnl");
            }
            //al el nodo no tener un nodo siguiente se agrega el nodo del parametro como siguiente
            temp.setNext(nodo);
        }
        //se incrementa el tamaño de la lista
        this.tamaño++;
    }

    /**
     * Metodo que permite eliminar um nodo de la lista
     * @param nodo, nodo a eliminar de la lista
     */
    public void eliminar(Node nodo){
        //en caso de ser el nodo la cabeza de la lista, se cambia la cabeza por el nodo siguiente
        if(this.head==nodo){
            setHead(nodo.getNext());
        }else{
            //se crea un nodo temporal para recorrer la lista sin modificarla
            //Node temp=this.head;
            Node temp = new Node(this.head.getI(),this.head.getJ());
            //se recorre la lista mientras el nodo siguirente al temporal sea distinto al nodo del parametro
            while(temp.getNext()!=nodo){
                temp=temp.getNext();
            }
            //cuando el nodo siguiente al temporal sea igual al nodo se cambia el nodo siguiente del temporasl
            //por el siguiente al nodo a eliminar
            temp.setNext(temp.getNext().getNext());
        }
        //se reduce el tamaño de la lista
        this.tamaño--;
    }

    /**
     * Metodo que busca un nodo en la lista enlazada
     * @param i, informacion de fila del nodo
     * @param j, informacion de columna del nodo
     * @return nodo que coincide con la fila y la columna dada
     */
    public Node buscar(int i, int j){
        //se genera un nodo temporal para recorrer la lista sin modificarla
        Node temp=this.head;
        //verifica los datos del temporal hasta que se termine la lista
        while(temp!=null){
            //si el temporal tiene los datos de los parametros se retorna el nodo temporal
            if(temp.getI()==i&&temp.getJ()==j){
                return temp;
            }else{
                temp=temp.getNext();
            }
        }
        //en caso de no encontrar el nodo se retorna nulo
        return null;
    }

    /**
     * Metodo para buscar un nodo aleatorio de la lista
     * @return nodo aleatorio de la lista
     **/
    public Node buscarAleatorio(){
        Random Rs = new Random();
        //posicion actual en la mina
        //int contador=0;
        //int t = Rs.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
        //int t2 = Rs.nextInt(8); // Genera un número entre 0 y 7 (ambos inclusive)
        int t=(int)(Math.random()*8);
        int t2=(int)(Math.random()*8);
        while(buscar(t,t2) == null) {
            t=(int)(Math.random()*8);
            t2=(int)(Math.random()*8);
        }
        Node temp = new Node(t, t2);
        return temp;
    }

    /**
     * Metodo que cambia el nodo cabeza
     * @param nodo, nodo por el cual cambiar el nodo cabeza
     */
    public void setHead(Node nodo){
        this.head=nodo;
    }

    /**
     * Metodo que retorna el nodo cabeza
     * @return nodo cabeza
     */
    public Node getHead(){
        return this.head;
    }

    /**
     * Metodo que cambia el tamaño de la lista
     * @param tamaño, nuevo tamaño de la lista
     */
    public void setTamaño(int tamaño){
        this.tamaño=tamaño;
    }

    /**
     * Metodo que retorna el tamaño de la lista
     * @return tamaño de la lista
     */
    public int getTamaño(){
        return this.tamaño;
    }
}
