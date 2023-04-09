package com.example.bm1;

public class Node {

    private Casilla data;
    private Node next;

    public Node(Casilla data) {
        this.next = null;
        this.data = data;
    }

    public Casilla getData() {
        return this.data;
    }

    public void setData(Casilla data) {
        this.data = data;
    }
    public void setNext() {
        this.next = next;
    }
    public Node getNext() {
        return this.next;
    }

}
