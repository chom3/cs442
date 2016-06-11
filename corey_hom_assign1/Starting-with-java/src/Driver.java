import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * The Driver class is the main file, it will take in the arguments and use
 * FileProcessor.java and StringOperations.java for help on finding a solution.
 **/
public class Driver{
    public static void main (String[] args)
    {
        //Check that the count of command line arguments is correct.
        if (args.length == 0)
        {
            System.err.println ("No arguments!");
            System.exit(0);
        }
        else if (args.length > 1)
        {
            System.err.println ("Invalid number of arguments! Example usage: java Driver -file-");
            System.exit(0);
        }
        
        //Read the file appropriately, we can use a buffered input stream.
        File input = new File(args[0]);
        FileProcessor proc = new FileProcessor(input);
        StringOperations res = new StringOperations();
        String currentLine = proc.readLineFromFile();
        while (currentLine != null)
        {
            res.findName(currentLine);
            currentLine = proc.readLineFromFile();
        }
        // res.printOut();
        
        
        //Display the results!
        ArrayList<String> mostWordList = null;
        int mostWordNum = 0;
        try {
            mostWordList = res.findMostWord();
            mostWordNum = res.findMostWordNum();
        }
        catch (NoSuchElementException none)
        {
            System.out.println("There are no words that fill the requirement in this document.");
            none.printStackTrace(System.out);
            System.exit(1);
        }
        System.out.print("The most frequently occurring element(s) is/are ");
        //We start the counter at 1 because we're printing the word before we increment
        //Naturally we're 1 word behind.
        int counter = 1;
        for (String word : mostWordList) 
        {
            if (counter == mostWordList.size())
            {
                System.out.print( (word) + ". ");
            }
            else
            {
                System.out.print( (word) + ", ");
            }
            counter++;
        }
        System.out.print("It/they occurred " + mostWordNum + " times.\n");
    }
}