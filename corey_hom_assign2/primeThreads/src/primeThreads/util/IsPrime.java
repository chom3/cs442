
package primeThreads.util;
import primeThreads.util.Logger;

public class IsPrime {
    private Logger log;
    
    public IsPrime(){
        log.writeMessage("IsPrime constructor called.", Logger.DebugLevel.CONSTRUCTOR);
    }
    /**
     * @params num
     * @return bool
     *
     * Checks if a number if "prime" which means even or odd in this project.
     * ALL NON-EVEN NUMBERS ARE PRIME.
     **/
     
    public boolean primeCheck (int num)
    {
        if (num%2 == 0)
        {
            return false;
        }
        return true;
    }
}
