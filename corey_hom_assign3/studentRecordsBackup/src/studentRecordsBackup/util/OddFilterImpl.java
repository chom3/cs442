package studentRecordsBackup.util;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;


public class OddFilterImpl implements OddEvenFilterI{
   private Node rootNode;
   
   
   /**
    * Constructor for this class
    * Takes in a node, root
    * @params root
    **/
   public OddFilterImpl(Node rootIn)
   {
       rootNode = rootIn;
   }
    /**
     * FilterOdd will change the flag in the node to all odd.
     * @params root node
     **/
    public void filterOdd()
    {
        filterOdd(rootNode);
    }
    public void filterOdd(Node rootIn)
    {
        if (rootIn != null)
        {
            rootIn.setOddFlag(true);
            filterOdd(rootIn.getNodeL());
            filterOdd(rootIn.getNodeR());
        }
    }
     /**
     * FilterEven will change the flag in the node to all even.
     * Since it is implemented by the interface I overwrote it
     * @params root node
     **/
     
    public void filterEven()
    {
        filterEven(rootNode);
    }
    public void filterEven(Node rootIn)
    {
        if (rootIn != null)
        {
            rootIn.setEvenFlag(true);
            filterEven(rootIn.getNodeL());
            filterEven(rootIn.getNodeR());
        }
    }
    
}