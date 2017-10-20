
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Permutation {
    
   public static void main(String[] args)
   {
       int k = Integer.parseInt(args[0]);
       RandomizedQueue<String> cua = new RandomizedQueue<String>();
       while (!StdIn.isEmpty())
       {
           String s = StdIn.readString();
           cua.enqueue(s);
       }
       Iterator<String> iterador =  cua.iterator();
       for (int i=0; i < k; i++)
       {
           System.out.println(iterador.next());
       }
   }
}