package studentRecordsBackup.bst;

import java.util.ArrayList;
/**
 * Create a class Node to store the B-Number and a description. 
 * The data type of the B-Number and description should be int and String respectively.
 * Assume that a student record just has a B-Number.
 * */
 //A BST has a left/right node as well
public class Node implements ObserverI, SubjectI{
    
    private ArrayList<ObserverI> observers;
    private int bNum;
    private Node left;
    private Node right;
    private Boolean isMax;
    private Boolean evenFlag;
    private Boolean oddFlag;
    /**
     * Constructor for Node
     * @params int, string
     * @returns none
     **/
    public Node(int bNumIn)
    {
        observers = new ArrayList();
        bNum = bNumIn;
        isMax = false;
        evenFlag = false;
        oddFlag = false;
    }
    
    /**
     * Flag setter for max boolean.
     **/
    public void isMaxNode(int max)
    {
        if (max == bNum)
        {
            isMax = true;
        }
    }
    
    /**
     * Flag setter for evenFlag
     **/
    public void setEvenFlag(Boolean val)
    {
        evenFlag = val;
    }
    
    /**
     * Flag setter for oddFlag
     **/
    public void setOddFlag(Boolean val)
    {
        oddFlag = val;
    }
    
    /**
     * Return even flag
     * @returns bool
     **/
    public Boolean isEvenFlag()
    {
        return evenFlag;
    }
    
    /**
     * Return odd flag
     * @returns bool
     **/
    public Boolean isOddFlag()
    {
        return oddFlag;
    }
    
    /**
     * Getter/Accessor for bNumber
     * @params none
     * @returns bNumber
     **/
    public int getbNum()
    {
        return bNum;
    }
     
     /**
      * Setter/Mutator for bNumber
      * @params int bNumIn
      * @returns none
      **/
    public void setbNum(int bNumIn)
    {
        bNum = bNumIn;
    }
     
    /**
     * Getter/Accessor for right node
     * @params none
     * @returns right node of current node
     **/
    public Node getNodeR()
    {
        return right;
    }
     
     /**
      * Setter/Mutator for right node
      * @params Node object
      * @returns none
      **/
    public void setNodeR(Node rightIn)
    {
        right = rightIn;
    }
    
    /**
     * Getter/Accessor for left node
     * @params none
     * @returns left node of current node
     **/
    public Node getNodeL()
    {
        return left;
    }
     
     /**
      * Setter/Mutator for left node
      * @params Node object
      * @returns none
      **/
    public void setNodeL(Node leftIn)
    {
        left = leftIn;
    } 
    
    
    /**
     * Getter for observer list.
     * @returns list
     **/
    public ArrayList<ObserverI> getObs()
    {
        return observers;
    }
    
    /**
     * Setter for observer list.
     * @params observerList incoming
     **/
    public void setObs(ArrayList<ObserverI> obsIn)
    {
        observers = obsIn;
    }
    
     
    /**
     * RegisterObserver method, which data structure to use? ArrayList, Vector?
     * @params ObserverI o
     **/
    public void registerObserver(ObserverI oIn)
    {
        observers.add(oIn);
    }
    
    /**
     * Remove observe from the data structure
     * @params ObserverI o
     **/ 
    public void removeObserver(ObserverI oIn)
    {
        observers.remove(oIn);
    }
    
    /**
     * Notify all the observers of an update
     * @params Node, int
     **/
    public void notifyObservers(int max, int valueIn)
    {
        isMaxNode(max);
        if (max == bNum)
        {
            int check = bNum + (valueIn * 2);
            if (oddFlag == false && evenFlag == false)
            {
                setbNum(bNum + valueIn*2);
            }
            else if (check % 2 == 0 && evenFlag == true){
                setbNum(bNum + valueIn*2);
            }
            else if (check % 2 != 0 && oddFlag == true)
            {
                setbNum(bNum + valueIn*2);
            }
        }
        else
        {   
            int check = bNum + (valueIn);
            if (oddFlag == false && evenFlag == false)
            {
                setbNum(bNum + valueIn);
            }
            else if (check % 2 == 0 && evenFlag == true){
                setbNum(bNum + valueIn);
            }
            else if (check % 2 != 0 && oddFlag == true)
            {
                setbNum(bNum + valueIn);
            }
        }
        for (ObserverI obs : observers)
        {
            obs.update(max, valueIn);
        }
        if (left != null)
        {
            left.notifyObservers(max, valueIn);
        }
        if (right != null)
        {
            right.notifyObservers(max, valueIn);
        }
    }
    
    
    /**
     * Update method to override
     * @params node, int to update
     * @returns none
     */
    public void update(int max, int valueIn)
    {
        if (max == bNum)
        {
            int check = bNum + (valueIn);
            if (oddFlag == false && evenFlag == false)
            {
                setbNum(bNum + valueIn*2);
            }
            else if (check % 2 == 0 && evenFlag == true){
                setbNum(bNum + valueIn*2);
            }
            else if (check % 2 != 0 && oddFlag == true)
            {
                setbNum(bNum + valueIn*2);
            }
        }
        else
        {   
            int check = bNum + (valueIn);
            if (oddFlag == false && evenFlag == false)
            {
                setbNum(bNum + valueIn);
            }
            else if (check % 2 == 0 && evenFlag == true){
                setbNum(bNum + valueIn);
            }
            else if (check % 2 != 0 && oddFlag == true)
            {
                setbNum(bNum + valueIn);
            }
        }
    }
}