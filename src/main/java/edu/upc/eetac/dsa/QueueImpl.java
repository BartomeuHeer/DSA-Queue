package edu.upc.eetac.dsa;
import java.util.LinkedList;
import java.util.List;
public class QueueImpl<E> implements Queue<E>{
    E[] myArray;
    //List<E> myList;
    private int count;
    public QueueImpl(int s){
        this.count = 0;
        myArray = (E[]) new Object[s];

    }
    public int size(){
        return count;
    }
    private boolean isFull(){
        return count == myArray.length;
    }
    public void push(E e) throws FullQueueException{
        if(this.isFull())
            throw new FullQueueException();
        else{
            this.myArray[count] = e;
            this.count++;
        }
    }
    public E pop() throws EmptyQueueException{
        E element;
        if(count == 0)
            throw new EmptyQueueException();
        else {
            element = myArray[0];
            for(int i = 0; i < count-1; i++)
                myArray[i] = myArray[i+1];
            myArray[count-1]=null;
            count--;
        }
        return element;
    }
}
