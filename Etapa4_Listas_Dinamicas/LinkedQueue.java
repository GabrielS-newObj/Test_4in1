package Etapa4_Listas_Dinamicas;

import Etapa3_Listas_Estaticas.ExceptionsFromList.*;

public class LinkedQueue<E> implements Queue<E>{

    private Node<E> first;
    private Node<E> last;
    private int numElements;

    public LinkedQueue() {
        first = last = null;
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

    public void enqueue(E element) throws OverflowException{

        Node<E> newNode = new Node<>(element);

        if(isEmpty()) first = newNode;
        else last.setNext(newNode);

        last = newNode;
        numElements++;
    }

    public E dequeue() throws UnderflowException{

        if(isEmpty()) throw new UnderflowException();

        Node<E> removedNode = first;

        if (first.getNext() == null) first = last = null;
        else first = first.getNext();

        removedNode.setNext(null);

        System.gc();

        numElements--;
        return removedNode.getElement();
    }

    public E front() throws UnderflowException{
        if (isEmpty()) throw new UnderflowException();
        return first.getElement();
    }

    public E back() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return last.getElement();
    }


}
