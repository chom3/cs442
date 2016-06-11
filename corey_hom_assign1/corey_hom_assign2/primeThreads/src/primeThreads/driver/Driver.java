package primeThreads.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.store.Results;
import primeThreads.threadMgmt.CreateWorkers;
import java.util.Properties;
import primeThreads.util.Logger;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.store.StoreData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {
    public static void main (String[] args)
    {
    	int NUM_THREADS = 0;
    	int DEBUG_VALUE = 0;
        //Check that the count of command line arguments is correct.
        if (args.length == 0)
        {
            System.err.println ("No arguments!");
            System.exit(0);
        }
        else if (args.length != 4)
        {
            System.err.println ("Invalid number of arguments! Example usage: ant -buildfile src/build.xml run -Darg0=-INPUT-  -Darg1=-[NUM_THREADS 1-5] -Darg2=[DEBUG_VALUE 0-4]");
            System.exit(0);
        }
        else
        {
        	try {
        		NUM_THREADS = Integer.parseInt(args[1]);
        	}
        	catch (NumberFormatException e){
        		System.err.println("Second argument must be an integer!");
        		System.exit(0);
        	}
        	finally {}
        	try{
        		DEBUG_VALUE = Integer.parseInt(args[2]);
        	}
        	catch (NumberFormatException e)
        	{
        		System.err.println("Third argument must be an integer!");
        		System.exit(0);
        	}
        	finally {}
        }
		if (NUM_THREADS == 0 || NUM_THREADS > 5 || NUM_THREADS < 0)
		{
			System.err.println("Invalid number for number of threads. Choose a number between 1 and 5.");
			System.exit(0);
		}
		else if (DEBUG_VALUE > 4 || DEBUG_VALUE < 0)
		{
			System.err.println("Invalid number for debug value. Choose a number between 0 and 4.");
			System.exit(0);
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
        

		
        //Construct the various tools needed to read through, check, and store the numbers.
		Logger log = new Logger();
		log.writeMessage("Logger constructor called.", Logger.DebugLevel.CONSTRUCTOR);
		log.setDebugValue(DEBUG_VALUE);
		
        FileProcessor proc = new FileProcessor(input);
        
        Results res = new Results();
        StdoutDisplayInterface writeOut = res;
        StoreData store = res;
        
        IsPrime prime = new IsPrime();
        
        //Create an instance of CreateWorkers and pass FileProcessor, Results, IsPrime
        CreateWorkers cw = new CreateWorkers(proc, writeOut, store, prime);
        cw.startWorkers(NUM_THREADS);
        
        //Take care of specific DEBUG_VALUE goals.
        log.writeOutput(res, DEBUG_VALUE);
	}
}



