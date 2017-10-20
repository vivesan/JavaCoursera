
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private class  Node
    {
        Item item;
        Node next;
    }
    private Node first = null;
    
    private int  Size = 0;
   
    public RandomizedQueue()   {}              // construct an empty randomized queue
   public boolean isEmpty()  
   {
       if(first == null){
            return true;
        }
        else{
            return false;
        }
    } // is the randomized queue empty?
    public int size(){                     // return the number of items on the deque
        return Size;
   }
   
   public void enqueue(Item item)    
   {
       if(item != null){
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            Size += 1;
            
        }
        else{
            throw new java.lang.IllegalArgumentException();
        }
   }// add the item
   public Item dequeue() 
   {
       int num;
       num = StdRandom.uniform( Size);
       int i=0;
       if (!isEmpty()){
       Node current = new Node();
       current = first;
       while(i<num){
           i+=1;
           current = current.next;
       }
       Item oldItem = current.item;
       current.item = null;
       current = current.next;
       Size -= 1;
       return oldItem;
       }
       throw new java.util.NoSuchElementException();
   }// remove and return a random item
   public Item sample()
   {
       if (!isEmpty()){
       int num;
       num = StdRandom.uniform( Size);
       int i=0;
       Node current = new Node();
       current = first;
       while(i<num){
           i+=1;
           current = current.next;
       }
       return current.item;
   }
       throw new java.util.NoSuchElementException();
   }// return a random item (but do not remove it)
   public Iterator<Item> iterator() {
   return new RandomIterator();
   }        // return an independent iterator over items in random order
   private class RandomIterator implements Iterator<Item>
{
    private Item[] llista;
    private int[] index;
    private int mida;
    private int currentIndex;
    RandomIterator()
    {
        mida = Size;
        llista = (Item[]) new Object[mida];
        index = new int[mida];
        Node actual = new Node();
        actual = first;
        for(int i=0; i < mida; i++)
        {
                llista[i]=actual.item;
                actual = actual.next;
                index[i]=i;
        }
        StdRandom.shuffle(index);
        currentIndex=0;
        
    }
    public boolean hasNext(){return currentIndex < mida;}
    public void remove(){throw  new java.lang.UnsupportedOperationException();}
    public Item next()
    {
        if (!hasNext()){throw new java.util.NoSuchElementException();}
        return llista[index[currentIndex++]];
    }
}
}




