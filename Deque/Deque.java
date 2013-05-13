import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;

public class Deque<Item> implements Iterable<Item> {
    
    private int N;          // size of the stack
    private Node first;     // Position 0 of stack
    private Node last;      // Position N-1 of Stack
    
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }
    
    public Deque(){
        N = 0;
        first = null;
        last = null;
    }
    
    public void addFirst(Item item){
        if (item == null){
            throw new NullPointerException();            
        }
        if (first == null){
            first = new Node();
            first.item = item;
            last = first;
            N++;
            test();
            return; 
        }
            
        
        Node oldFirst= first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        oldFirst.previous = first;
        N++;
        test();
    }
    
     public Item removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item =first.item;
        first = first.next;
        first.previous = null;
        N--;
        test();
        return item;
    }
     
    public void addLast(Item item){
        if (item == null){
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;
        oldLast.next = last;
        N++;
        test();
    }
    
    public Item removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.previous;
        last.next = null;
        N--;
        test();
        return item;
    }      
     
    public int size(){
        return N;
    }
    
    public boolean isEmpty(){
            return N == 0;
    }
    
   
  
    public Iterator<Item> iterator()  { return new ListIterator();  }
    
    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current.next != null; }
        public void remove()      { throw new UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
     }
    
    private void test(){
         boolean empty = (first == null)? true : false;
         StdOut.println("Is Empty: " + empty);
         StdOut.println("Stack count: " +N);
         StdOut.print("Stack: First ~~~~> ");
        if (N >0){
             Iterator iter =  iterator();
             while(iter.hasNext() ){
                 StdOut.print(iter.next());
                 StdOut.print(" | ");
             }
         }
        if(last != null){
             StdOut.print(last.item);
         }
         StdOut.println(" <~~~~ Last");   
    }
    
    public static void main(String[] args){
        Deque<String> s = new Deque<String>();
        while (true){
            String item = StdIn.readString();
            if (item.equals("-")){
                StdOut.println(s.removeFirst());
            }
            else if(item.equals("&")){
                s.addLast(item);
            }
            else if(item.equals("--")){
                StdOut.println(s.removeLast());
            }
                
            else{
            s.addFirst(item);
            }
        }
    }
}
   
            
        
        