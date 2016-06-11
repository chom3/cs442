
package primeThreads.threadMgmt;

import primeThreads.store.Results;
import primeThreads.util.IsPrime;
import primeThreads.util.FileProcessor;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.store.StoreData;
import primeThreads.util.Logger;

public class WorkerThread implements Runnable  {
    
    private FileProcessor fileProc;
    private StdoutDisplayInterface resOut;
    private StoreData resStore;
    private IsPrime prime;
    private Logger log;
    
    /**
     * Constructor of WorkerThread
     * Pass file processor, Results, and IsPrime instances
     **/
    public WorkerThread(FileProcessor fPass, StdoutDisplayInterface rPass, StoreData sPass, IsPrime pPass)
    {
        log.writeMessage("WorkerThread constructor called.", Logger.DebugLevel.CONSTRUCTOR );
        fileProc = fPass;
        resOut = rPass;
        resStore = sPass;
        prime = pPass;
    }

    /**
     * Run method :
     * When not end of file
     * Invoke readLineFromFile()
     * Check if prime number
     * Store in results
     *
     **/
    public void run() {
        log.writeMessage("Run has been called.", Logger.DebugLevel.THREAD_RUN);
        String currentLine = fileProc.readLineFromFile();
        int check;
        while (currentLine != null){
            try{
                check = Integer.parseInt(currentLine);
                if (prime.primeCheck(check))
                {
                    resStore.writeToStore(check);
                }
                currentLine = fileProc.readLineFromFile();
            }
            catch (NumberFormatException e){
                System.err.println("This file doesn't follow the format of one integer per line!");
                System.exit(0);
            }
        }
	}
    

}