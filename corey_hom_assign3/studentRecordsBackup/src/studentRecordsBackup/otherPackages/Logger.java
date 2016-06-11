
package studentRecordsBackup.otherPackages;

import java.util.Vector;

public class Logger{

    public static enum DebugLevel { NONE, CONSTRUCTOR, THREAD_RUN, ADD_RESULTS, PRINT_INDEX
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 0: debugLevel = DebugLevel.NONE; break;
	  case 1: debugLevel = DebugLevel.PRINT_INDEX; break;
	  case 2: debugLevel = DebugLevel.ADD_RESULTS; break;
	  case 3: debugLevel = DebugLevel.THREAD_RUN; break;
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
    
}
