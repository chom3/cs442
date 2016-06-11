package studentRecordsBackup.util;

import studentRecordsBackup.otherPackages.FileProcessor;
import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.util.OddFilterImpl;
import studentRecordsBackup.util.EvenFilterImpl;
/**
 *Create a class BSTBuilder that reads a line from the input file,
 *and calls the insert(...) method of the BST.
 *The input values will not have any duplicates.
 * Create two copies of the BST tree
 **/
 
public class BSTBuilder
{
    private FileProcessor fileProc;
    private BST backup1;
    private BST backup2;
    private BST start;
    /**
     * Constructor to pass in File
     **/
    public BSTBuilder(FileProcessor fIn)
    {
        fileProc = fIn;
        backup1 = null;
        backup2 = null;
        start = null;
    }
    
    /**
     * Use BSTBuilder to read a line from the input file
     * call insert of BST.
     * Code pretty much used from the first two assignments.
     * 3 trees should be the instances of the same BST class! Check
     **/
    public BST createTree()
    {
        String currentLine = fileProc.readLineFromFile();
        int check;
        while (currentLine != null){
            try{
                check = Integer.parseInt(currentLine);
                if (start == null)
                {
                    Node rootNode = new Node(check);
                    Node rootNode2 = new Node(check);
                    Node rootNode3 = new Node(check);
                    start = new BST(rootNode);
                    backup1 = new BST(rootNode2);
                    backup2 = new BST(rootNode3);
                }
                else
                {
                    start.insert(start.getRoot(), check);
                    backup1.insert(backup1.getRoot(), check);
                    backup2.insert(backup2.getRoot(), check);
                }
                currentLine = fileProc.readLineFromFile();
            }
            catch (NumberFormatException e){
                System.err.println("This file doesn't follow the format of one integer per line!");
                System.exit(0);
            }
        }
        EvenFilterImpl evenFilter = new EvenFilterImpl(backup1.getRoot());
        OddFilterImpl oddFilter = new OddFilterImpl(backup2.getRoot());
        createListeners(start.getRoot(), backup1.getRoot(), backup2.getRoot());
        evenFilter.filterEven();
        oddFilter.filterOdd();
        //need to iterate through bst and assign node to node/node as subject/listener
        return start;
    }
    /**
     * Recursive visit node
     **/
    public void createListeners(Node root1, Node root2, Node root3)
    {
        if (root1 != null && root2 != null && root3 != null){
            root1.registerObserver(root2);
            root1.registerObserver(root3);
            createListeners(root1.getNodeL(), root2.getNodeL(), root3.getNodeL());
            createListeners(root1.getNodeR(), root2.getNodeR(), root3.getNodeR());
        }
    }
    
    //Gotta make sure that backup1/2 work.. make getters for them
    public BST getBackup1()
    {
        return backup1;
    }
    
    public BST getBackup2()
    {
        return backup2;
    }
}