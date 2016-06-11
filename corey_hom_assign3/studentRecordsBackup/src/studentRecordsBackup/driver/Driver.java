package studentRecordsBackup.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import studentRecordsBackup.otherPackages.FileProcessor;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.bst.BST;
import studentRecordsBackup.util.BSTBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *Your driver code should do the following:
 *Read command line arguments.
 *Use BSTBuilder to build the three trees.
 *Call inorder traversal to print the values from the three trees.
 *Call methods to print the sum of all the B-Numbers in each of the three trees.
 *Call a method to increment the nodes in the main BST with
 * UPDATE_VALUE (which will update the backups via the observer pattern).
 *Call methods to print the sum of all the B-Numbers in each of the three trees.
 */
 
public class Driver{
    public static void main (String[] args)
    {
        //Standard code that I've used to check valid parameters
        int UPDATE_VALUE = 0;
        if (args.length== 0)
        {
            System.err.println ("No arguments!");
            System.exit(0);
        }
        else if (args.length != 3)
        {
            System.err.println ("Invalid number of arguments! Example usage: ant -buildfile src/build.xml run -Darg0=-INPUT-  -Darg1=UPDATE_VALUE");
            System.exit(0);
        }
        else
        {
            try {
        		UPDATE_VALUE = Integer.parseInt(args[1]);
        	}
        	catch (NumberFormatException e){
        		System.err.println("Second argument must be an integer!");
        		System.exit(0);
        	}
        	finally {}
        }
        
        //Read the file appropriately, we can use a buffered input stream.
        File input = new File(args[0]);
        
        		
		//Let's check if the file is blank before we do anything.
		BufferedReader br = null;
		try{
		    br = new BufferedReader(new FileReader(input));
    		if (br.readLine() == null){
    		    System.err.println("The file was empty!");
    		    System.exit(0);
    		}
    		br.close();
		}
		catch (FileNotFoundException canOpen)
        {
            System.out.println("The file is invalid and cannot be opened!");
            canOpen.printStackTrace(System.out);
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("There was an exception in the opening of the file.");
            e.printStackTrace(System.out);
            System.exit(0);
        }
        
        //Begin BSTBuilder
        FileProcessor proc = new FileProcessor(input);
        BSTBuilder builder = new BSTBuilder(proc);
        //Use BSTBuildder to build the three trees
        BST bst1 = builder.createTree();
        BST bst2 = builder.getBackup1();
        BST bst3 = builder.getBackup2();
        //Call inorder traversal to print hte values from the 3 trees
        System.out.println("Printing out nodes in order for main-tree: ");
        bst1.printInOrder();
        System.out.println("Printing out nodes in order for backup-tree 1: ");
        bst2.printInOrder();
        System.out.println("Printing out nodes in order for backup-tree 2: ");
        bst3.printInOrder();
        
        //Call methods to print the sum of all the B-Numbers in each of the 3 trees
        System.out.println("The max value is: " + bst1.getBSTMax());
        System.out.print("Main-BST sum: ");
        bst1.printBSum();
        System.out.print("Backup-1 sum: ");
        bst2.printBSum();
        System.out.print("Backup-2 sum: ");
        bst3.printBSum();
        
        //Set in UPDATE_VALUE
        bst1.setUpVal(UPDATE_VALUE);
        // System.out.println(bst1.getUpVal());
        System.out.println("Applying UPDATE_VALUE!");
        bst1.getRoot().notifyObservers(bst1.getBSTMax(), UPDATE_VALUE);
        
        // TESTING
        // bst1.printInOrder();
        // bst2.printInOrder();
        // bst3.printInOrder();
        
        //Call methods to print the sum of all the B-Numbers in each of the 3 trees
        System.out.println("The max value is: " + bst1.getBSTMax());
        System.out.print("Main-BST sum: ");
        bst1.printBSum();
        System.out.print("Backup-1 sum: ");
        bst2.printBSum();
        System.out.print("Backup-2 sum: ");
        bst3.printBSum();
        
    }
}