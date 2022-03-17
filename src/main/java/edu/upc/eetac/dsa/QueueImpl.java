package edu.upc.eetac.dsa;
import java.util.LinkedList;
import java.util.List;
public class QueueImpl<Object> implements Queue<Object>{
    Object myList;
    private int count;
    private int size;
    public QueueImpl(int s){
        this.size = s;
        this.count = 0;
        myList = new LinkedList<Object>();
    }
    public int size(){
        return count;
    }
    private boolean isFull(){
        if(count == size)
            return true;
        else
            return false;
    }
    public void push(Object e) throws FullQueueException{
        if(this.isFull())
            throw new FullQueueException();
        else{
            this.myList.add(e);
            this.count++;
        }
    }
    public Object pop() throws EmptyQueueException{
        Object o;
        if(count == 0)
            throw new EmptyQueueException();
        else {
            o = myList.get(0);
            this.myList.add(0,null);
            for(int i = 0; i < count-1; i++){
                myList.add(i,myList.get(i+1));
            }
            myList.remove(count-1);
            count--;
        }
        return o;
    }
}
