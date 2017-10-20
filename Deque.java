
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class  Node
    {
        Item item;
        Node next;
        Node previous;
    }
    public Node first = null;
    public Node last = null ;
    public int  Size = 0;
    public Deque(){                         // construct an empty deque
        
    }
    
    public String toString() {
        String res = "";
        Iterator<Item> it = this.iterator();
        while (it.hasNext()) {
            res += it.next() + " ";
        }
        
        return res;
    }
    
    public boolean isEmpty(){               // is the deque empty?
        return (Size == 0);
    }
    public int size(){                     // return the number of items on the deque
        return Size;
    }
    public void addFirst(Item item) {        // add the item to the front
        if(item != null){
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            if (Size>0){
                oldFirst.previous = first;}
            Size += 1;
            if (Size == 1){
                last = first;
            }
        }
        else{
            throw new java.lang.IllegalArgumentException();
        }
    }
    public void addLast(Item item){           // add the item to the end
        if(item != null){
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.previous = oldLast;
            if (Size>0){
            oldLast.next = last;
            }
            Size += 1;
            if (Size == 1){
                first = last;
            }
        }
        else{
             throw new java.lang.IllegalArgumentException();
        }
    }
    public Item removeFirst(){            // remove and return the item from the front
        if(Size!=0){
            Item oldFirst = first.item;
            first.item = null;
            first = first.next;
            Size -= 1;
            return oldFirst;
        }
        else{
            throw new java.util.NoSuchElementException();
        }
    }
    public Item removeLast(){              // remove and return the item from the end
        if(Size!=0){
            Item oldLast = last.item;
            last.item = null;
            last = last.previous;
            Size -= 1;
            return oldLast;
        }
        else{
            throw new java.util.NoSuchElementException();
        }
    }
    public Iterator<Item> iterator(){
        
    
        
          return new ListIterator();
        }       // return an iterator over items in order from front to end
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        
        public boolean hasNext() { return current!= null; }
        public void remove() { throw  new java.lang.UnsupportedOperationException(); }
        public Item next()
        {
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
                current = current.next;
                return item;
            
            
        }
        
    }
}