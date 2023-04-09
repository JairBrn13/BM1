package com.example.bm1;

public class Lista {

        public Node head;
        public int size;

        public Lista() {
            this.head = null;
            this.size = 0;

        }

        public boolean isEmpty() {
            return this.head == null;

        }

        public int size() {
            return this.size;

        }

    public void insertarLast(Casilla data){
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
                current.setNext();
            }
            current = node;
            Lista.this.size++;
            }
        }

        public Casilla getLast() {
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
        public Casilla[] getValues(){
            Casilla[] values = new Casilla[Lista.this.size()];
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
