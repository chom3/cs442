package wordCount.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * The FileProcessor class checks if the file input is valid.
 * Can also read line by line and return a string.
 **/
public class FileProcessor {
    private BufferedReader reader = null;
    /**
     * FileProcessor -- constructor
     * @param FileInputStream
     * @return none
    **/
    public FileProcessor(File input)
    {
        try {
            reader = new BufferedReader(new FileReader(input));
        }
        catch (FileNotFoundException canOpen)
        {
            System.out.println("The file is invalid and cannot be opened!");
            canOpen.printStackTrace(System.out);
            System.exit(1);
        }
        finally
        {
            if (reader == null)
            {
                try{
                    reader.close();
                }
                catch (IOException e)
                {
                    System.err.println("There was an error in closing the file.");
                    e.printStackTrace(System.out);
                    System.exit(0);
                }
            }
        }
    }

    
    
    /**
    * Setter/Mutator for the FileProcessor construction.
    * @param BufferedReader file that you will pass to the variable reader
    * @returns none
    **/ 
    public void setFileProc (BufferedReader newFile)
    {
        reader = newFile;
    }
    
    /**
     * Getter/Accessor for the FileProcessor construction.
     * @param none
     * @returns the current BufferedReader file that will be read.
     **/     
    public BufferedReader getFileProc()
    {
        return reader;
    }
    
    /**
     * Read line by line and return as a string. Use buffered reader.
     * readLineFromFile()
     * @param none
     * @return a string
    **/
    public synchronized String readLineFromFile(){
        String line = null;
        try
        {
            line = reader.readLine();
        }
        catch (IOException noLine)
        {
            System.err.println("There is no line to be read");
            noLine.printStackTrace(System.out);
            System.exit(0);
        }
        return line;
    }
    
    /**
     * Default toString()
     * Nothing really needed to debug/check for from this particular class.
     * @param none
     * @returns null
     **/ 
    public String toString(){
        return null;
    }
}
