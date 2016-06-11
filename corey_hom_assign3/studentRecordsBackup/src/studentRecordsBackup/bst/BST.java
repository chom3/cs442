package studentRecordsBackup.bst;

import studentRecordsBackup.util.OddEvenFilterI;
import studentRecordsBackup.util.OddFilterImpl;
import studentRecordsBackup.util.EvenFilterImpl;
/**
 * Create a class binary search tree (BST) to store Nodes
 * in accordance with the BST rules applied to the B-Number of each Node.
 * Used:
 * http://codereview.stackexchange.com/questions/65265/inserting-a-node-in-binary-search-tree
 * For help on figuring out how to insert a node recursively!
 * */

//Looking online https://dzone.com/articles/observer-pattern-java at articles
//Decide that arrayList is best to hold the observers.

//BST Deals with all the nodes... so should it implement both observer and subject?
public class BST {
    private Node root;
    private int sum;
    private int UPDATE_VALUE;
    
    
    /**
     * Construct a tree, explicit constructor with only root node
     **/
     
    public BST(Node rootIn)
    {
        root = rootIn;
    }
    
    /**
     * Getter for root
     * @params none
     * @returns root node
     **/
     public Node getRoot()
     {
         return root;
     }
     
     /**
      * Setter for root.
      * @params node
      * @returns none
      **/
    public void setRoot(Node rootIn)
    {
        root = rootIn;
    }
    
    /**
     * Getter for update value
     * @params none
     * @returns update value
     **/
    public int getUpVal()
    {
        return UPDATE_VALUE;
    }
    
    /**
     * Setter for update value
     * @params UPDATE_VALUE int
     * @returns none
     **/
    public void setUpVal(int upValIn){
        UPDATE_VALUE = upValIn;
    }
    
    /**
     * Need an insert function. Recursion maybe?
     * @params the node we want to put in the tree
     * @returns
     **/
    public void insert(Node currentNode, int valueIn)
    {
        if (valueIn < currentNode.getbNum())
        {
            if (currentNode.getNodeL() == null)
            {
                currentNode.setNodeL(new Node(valueIn));
            }
            else
            {
                insert(currentNode.getNodeL(), valueIn);
            }
        }
        else
        {
            if (currentNode.getNodeR() == null)
            {
                currentNode.setNodeR(new Node(valueIn));
            }
            else
            {
                insert(currentNode.getNodeR(), valueIn);
            }
        }
    }
    //what else does a BST need....
    
    /**
     * Inorder traversal
     * Recursive, overload because driver can't have access to rootnode?
     * @params root node
     **/
    public void printInOrder()
    {
        inOrderTraversal(root);
    }
    
    public void inOrderTraversal(Node rootNode){
        if (rootNode != null)
        {
            inOrderTraversal(rootNode.getNodeL());
            System.out.println(rootNode.getbNum());
            inOrderTraversal(rootNode.getNodeR());
        }
    }
    
    /**
     * Return the bNum sum.
     * @params none
     * @returns int
     **/
    public void printBSum()
    {
        sum = 0;
        printBSum(root);
        System.out.println("The sum of all the B-Numbers is: " + sum);
    }
    
    public void printBSum(Node rootNode)
    {
        if (rootNode != null)
        {
            sum += rootNode.getbNum();
            printBSum(rootNode.getNodeL());
            printBSum(rootNode.getNodeR());
        }
    }
     
    
    /**
     * Find max number in BST.
     * The right most side is always the maximum.. so... Again overloaded for driver convenience.
     **/
    public int getBSTMax()
    {
        return getBSTMax(root);
    }
    
    public int getBSTMax(Node rootIn){
        int max = 0;
        if (rootIn.getNodeR() == null)
        {
            return rootIn.getbNum();
        }
        else
        {
            return getBSTMax(rootIn.getNodeR());
        }
    }

}