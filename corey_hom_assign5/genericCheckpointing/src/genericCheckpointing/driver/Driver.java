package genericCheckpointing.driver;

import java.util.Vector;
import java.io.File;
import java.lang.Integer;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

// import the other types used in this file

public class Driver {
    public static void main(String[] args) {
		// FIXME: read the value of checkpointFile from the command line
		int NUM_ARGS = 3;
		File output = null;
		File input = null;
		if(args.length != NUM_ARGS){
	      System.err.println("Expected " + NUM_ARGS + "arguments." +
	                          " Got " + args.length + ".");
	      System.err.println("Usage: <mode> <NUM_OF_OBJECTS_OF_ONE_KIND> <iterations>" +
	                          " <output_file>");
	      System.exit(1);
	    }
		String mode = args[0];
		if (!(mode.equals("serdeser") || mode.equals("deser")))
		{
			System.err.println("Expected one of two modes: <serdeser> or <deser>");
			System.exit(1);
		}
		//Need to do output vs input
		if(mode.equals("serdeser"))
		{
			output = new File(args[2]);
		}
		else
		{
			input = new File(args[2]);
		}
		int NUM_OF_OBJECTS = Integer.parseInt(args[1]);
	    
	    
	    //Quick check
	    // System.out.println(mode);
	    // System.out.println(NUM_OBJECTS);
	    // System.out.println(output.getName());
	    
		ProxyCreator pc = new ProxyCreator();
		
		// create an instance of StoreRestoreHandler (which implements
		// the InvocationHandler
		
		StoreRestoreHandler handler = new StoreRestoreHandler();
		
		// create a proxy
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
									 new Class[] {
									     StoreI.class, RestoreI.class
									 }, 
									 new StoreRestoreHandler()
									 );
			
		// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
		if(mode.equals("serdeser"))
		{
			handler.setFile(output);
			handler.cleanFile();
		
			MyAllTypesFirst myFirst;
			MyAllTypesSecond  mySecond;
		
			// Use an if/switch to proceed according to the command line argument
			// For deser, just deserliaze the input file into the data structure and then print the objects
			// The code below is for "serdeser" mode
			// For "serdeser" mode, both the serialize and deserialize functionality should be called.
		
			// create a data structure to store the objects being serialized
			Vector serObj = new Vector();
			for (int i=0; i<NUM_OF_OBJECTS; i++) {
				short shortex = 5;
			    // FIXME: create these object instances correctly using an explicit value constructor
			    // use the index variable of this loop to change the values of the arguments to these constructors
			    myFirst = new MyAllTypesFirst(8, 314159, "shiny", true);
			    mySecond = new MyAllTypesSecond(2.0, 3.09f, shortex, 'c'); 
		
			    // FIXME: store myFirst and mySecond in the data structure
			    ((StoreI) cpointRef).writeObj(myFirst, "XML");
			    ((StoreI) cpointRef).writeObj(mySecond, "XML");
			    serObj.add(myFirst);
			    serObj.add(mySecond);
		
			}
		
			Vector myRecordRet = new Vector();
		
			// create a data structure to store the returned ojects
			Vector deserObj = new Vector();
			for (int j=0; j<2*NUM_OF_OBJECTS; j++) {
		
			    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
			    // FIXME: store myRecordRet in the vector
			}
			for (int i=0; i < myRecordRet.size(); i++)
			{
				// System.out.println(myRecordRet.get(i));
				deserObj.add(myRecordRet.get(i));
			}
		
			// FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)
			//already closed 
			
			// FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
			// The comparison should use the equals and hashCode methods. Note that hashCode 
			// is used for key-value based data structures
			int countEqual = 0;
			for (int i = 0; i < serObj.size(); i++)
			{
				if ((serObj.get(i)).equals(deserObj.get(i)))
				{
					countEqual++;
				}
			}
			System.out.println( (serObj.size() - countEqual) + " mismatched objects"); 
		}
		else
		{
			handler.setFile(input);
			Vector myRecordRet = new Vector();
			for (int j=0; j<2*NUM_OF_OBJECTS; j++) {
			    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
			}
			for (int i=0; i < myRecordRet.size(); i++)
			{
				System.out.println(myRecordRet.get(i));
			}
		}
    }
}