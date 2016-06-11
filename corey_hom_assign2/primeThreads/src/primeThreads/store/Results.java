
package primeThreads.store;

import java.util.Vector;
import primeThreads.util.Logger;

public class Results implements StdoutDisplayInterface, StoreData {
    // appropriate data structure as private data member
    private Vector<Integer> storage;
    private Logger log;
    /**
     * Constructor to make vector data structure
     **/
     public Results()
     {
        log.writeMessage("Results constructor called.", Logger.DebugLevel.CONSTRUCTOR );
        storage = new Vector<Integer>();
     }
    /**
     * Getter/Accessor for storage
     * @params none
     * @returns Vector<Integer>
     **/
     public Vector<Integer> getStorage(){
         return storage;
     }
     
     /**
      * Setter/Mutator for storage
      * @params Vector<Integer>
      * @returns none
      **/
      public void setStorage(Vector<Integer> newStruc)
      {
          storage = newStruc;
      }
      
    /**
     * @param num
     * @returns none
     * Adds to the data structure
     **/
    // appropriate method to save prime number to the data structure
    public void writeToStore(int num)
    {
        log.writeMessage("Entry added to Results data structure.", Logger.DebugLevel.ADD_RESULTS);
        storage.add(num);
    }
    
    
    /**
     * writeSumToScreen adds all the values in the vector and gives the total
     * @params none
     * @returns none
     **/
    public void writeSumToScreen() {
	    int total = 0;
	    for (int i = 0; i < storage.size(); i++)
	    {
	        total += storage.get(i);
	    }
	    System.out.println("The sum of all the prime numbers is: " + total);
    }
    
} 


