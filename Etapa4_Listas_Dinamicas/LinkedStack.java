package Etapa4_Listas_Dinamicas;

import Etapa3_Listas_Estaticas.ExceptionsFromList.*;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;
    private int numElements;

    public LinkedStack() {
        top = null;
        numElements = 0;
    }

    public boolean isEmpty(){
        return numElements == 0;
    }

    public boolean isFull(){
        return false;
    }

    public int numElements(){
        return numElements;
    }

    public void push (E element) throws OverflowException{

        Node<E> newNode = new Node<>(element);

        if (!isEmpty()) newNode.setNext(top);

        top = newNode;
        numElements++;

    }

    public E pop() throws UnderflowException{

        if (isEmpty()) throw new UnderflowException();

        Node<E> removedNode = top;

        top = top.getNext();

        removedNode.setNext(null);

        System.gc();

        numElements--;

        return removedNode.getElement();
    }

    public E top() throws UnderflowException{

        if (isEmpty()) throw new UnderflowException();

        return top.getElement();
    }


}
