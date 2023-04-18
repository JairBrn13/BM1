package com.example.proyecto_bm;

public class PilaS{

    private int maxSize = 6;

    private Node[] pilaArray;

    private int top;


    public PilaS(){
        this.pilaArray = new Node[maxSize];
        this.top = -1;
    }

    public void push(Node newObject) {
        if (top < maxSize ){
            this.pilaArray[++top] = newObject;
        }
        else{
            System.out.println("La pila está llena");
        }
    }

    public Node pop() {
        return this.pilaArray[top--];
    }

    public Node peek() {
        return this.pilaArray[top];
    }

    public int getTop(){
        return top;
    }

}

