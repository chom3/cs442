
package primeThreads.threadMgmt;

import primeThreads.store.Results;
import primeThreads.util.IsPrime;
import primeThreads.util.FileProcessor;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.store.StoreData;
import primeThreads.util.Logger;

public class CreateWorkers  {
        private FileProcessor fileProc;
        private StdoutDisplayInterface resOut;
        private StoreData resStore;
        private IsPrime prime;
        private Logger log;
    // this class has the method startWokers(...)
    /**
     * CreateWorkers -- constructor
     * @param FileProcessor, Results, IsPrime
     * @return none
     **/
     public CreateWorkers(FileProcessor fPass, StdoutDisplayInterface rPass, StoreData sPass, IsPrime pPass)
     { 
        log.writeMessage("CreateWorkers constructor called.", Logger.DebugLevel.CONSTRUCTOR);
        fileProc = fPass;
        resOut = rPass;
        resStore = sPass;
        prime = pPass;
     }
     
    /**
    * Setter/Mutator for the CreateWorkers construction of the file processor
    * @param FileProcessor instance that you will pass
    * @returns none
    **/ 
    public void setFileProc (FileProcessor newFile)
    {
        fileProc = newFile;
    }
    
    /**
     * Getter/Accessor for the CreateWorkers construction of the file processor
     * @param none
     * @returns the current file processor
     **/     
    public FileProcessor getFileProc()
    {
        return fileProc;
    }
    
    /**
    * Setter/Mutator for the CreateWorkers construction of the results instance
    * @param Results instance that you will pass
    * @returns none
    **/ 
    public void setResults (StdoutDisplayInterface newRes)
    {
        resOut = newRes;
    }
    
    /**
     * Getter/Accessor for the CreateWorkers construction of the results  instance
     * @param none
     * @returns the current Results instance being used
     **/     
    public StdoutDisplayInterface getResults()
    {
        return resOut;
    }
    
    /**
    * Setter/Mutator for the CreateWorkers construction of the results instance
    * @param Results instance that you will pass
    * @returns none
    **/ 
    public void setData (StoreData newData)
    {
        resStore = newData;
    }
    
    /**
     * Getter/Accessor for the CreateWorkers construction of the results instance
     * @param none
     * @returns the current Results instance being used
     **/     
    public StoreData getData()
    {
        return resStore;
    }
    
    /**
    * Setter/Mutator for the CreateWorkers construction of the isPrime instance
    * @param isPrime instance that you will pass
    * @returns none
    **/ 
    public void setPrime (IsPrime newPrime)
    {
        prime = newPrime;
    }
    
    /**
     * Getter/Accessor for the CreateWorkers construction of the isPrime instance
     * @param none
     * @returns the current isPrime instance that is being used
     **/     
    public IsPrime getPrime()
    {
        return prime;
    }
    
    /**
     * StartWorkers creates NUM_THREADS threads
     * Starts them and joins them
     * @param int number of threads
     * @returns none
     **/ 
    public void startWorkers(int numThreads)
    {
        try{
            Thread[] threads = new Thread[numThreads];
            for (int i = 0; i < threads.length; i++)
            {
                threads[i] = new Thread(new WorkerThread(fileProc, resOut, resStore, prime));
                threads[i].start();
            }
            for (int i = 0; i < threads.length; i++)
            {
                threads[i].join();
            }
        }
        catch(InterruptedException e)
        {
    		System.err.println("There was an error in the execution of the threads!");
    		System.exit(0);
        }
    }
}