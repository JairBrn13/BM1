package com.example.bm1;
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
            this.head=nodo;
        }else{
            //se crea un nodo temporal para ir recorriendo la lista sin modificarla
            Node temp=this.head;
            //mienrtras el nodo tenga nodos consecuentes se sigue recorriendo la lista
            while(temp.getNext()!=null){
                temp=temp.getNext();
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
            this.head=nodo.getNext();
        }else{
            //se crea un nodo temporal para recorrer la lista sin modificarla
            Node temp=this.head;
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
     */
    public Node buscarAleatorio(){
        //posicion actual en la mina
        int contador=0;
        //posicion aleatoria a buscar en la lista
        int b= (int)(Math.random()*this.tamaño);
        //se genera un nodo temporal para recorrer la lista sin modificarla
        Node temp=this.head;
        //se aumenta la posicion actual de la lista hasta llegar a la posicion aleaoria
        while(b!=contador){
            temp=temp.getNext();
            contador++;
        }
        //retorna el nodo aleatorio que se busco
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



/*
public class Lista {

        public Node head;
        private int size;

        public Lista() {
            this.head = null;
            this.size = 0;

        }

        public boolean isEmpty() {
            return this.head == null;

        }

    public void insertarLast(Tupla data){
        Node node = new Node(data);
        Node current; //= new Node(data);
        if (Lista.this.size == 0) {
            Lista.this.head = node;
            current = Lista.this.head;
            Lista.this.size++;
        }
        else {
            current = Lista.this.head;
            while (current.getNext() != null){
                current.setNext(nodo);
            }
            current = node;
            Lista.this.size++;
            }
        }



    public void insertarLast(Tupla data) {
        Node nodo = new Node(data);

        if (this.head == null) {
            this.head = nodo;
        } else {
            Node nodoActual = this.head;
            while (nodoActual.getNext() != null) {
                nodoActual = nodoActual.getNext();
            }
            nodoActual.setNext(nodo);
        }
        this.size++;
    }







        public Tupla getLast() {
            Node current;
            if (Lista.this.size == 0) {
                return null;
            } else {
                current = Lista.this.head;
                while (current.getNext() != null) {
                    current.setNext();
                }
                return current.getData();
            }
        }





    public Tupla getLast() {
        if (head == null) {
            // la lista está vacía, no hay último elemento
            return null;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return current.getData();
        }
    }



        public int getSize(){
            return this.size;
        }


    public void eliminarTodos() {
        this.head = null;
        this.size = 0;
    }

        public int[] getValues(){
            int[] values = new int[Lista.this.size()];
            Node current;
            if (Lista.this.size == 0) {
                return null;
            }
            else {
                current = Lista.this.head;
                while (current.getNext() != null){
                    current.setNext();
                }
                for (int i = 0; i < Lista.this.size(); i++) {
                    values[i] = current.getData();
                }
                return values;
            }
    }


}

 */
