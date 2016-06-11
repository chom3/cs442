package genericCheckpointing.xmlStoreRestore;

import java.io.File;
import java.lang.String;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.xmlStoreRestore.XMLSerialization;
import genericCheckpointing.xmlStoreRestore.XMLDeserialization;
import genericCheckpointing.server.SerStrategy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class StoreRestoreHandler implements InvocationHandler
{
	//Should be static since I am setting it in the handler object
	//But writeObj/readObj are using invoke so they are different
	private static File output;
	private static Object obj;
	public void setFile(File outputIn)
	{
		output = outputIn;
	}

	public void serializeData(Object sObject, SerStrategy sStrategy, Method m, File out){
		sStrategy.processInput(sObject, m, out);
	}
	
	
	public void cleanFile()
	{
    	//Clear the filee
    	try{
	    	PrintWriter writer = new PrintWriter(output);
	        writer.print("");
	        writer.close();
    	}
    	catch (IOException e)
    	{
    		System.err.println("There was an error with opening the file!");
    	}
    	finally{}
	}
	public File getFile()
	{
		return output;
	}

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
  		BufferedWriter out = null;
  		BufferedReader reader = null;
		String methodName = m.getName();
		Vector retVect = new Vector();
		try {
			//Serialize
			if (methodName.equals("writeObj")){
				serializeData( args[0], new XMLSerialization(), m, output);
			}
			//Deserialize
			else if (methodName.equals("readObj"))
			{
				XMLDeserialization deser = new XMLDeserialization();
				serializeData( args[0], deser, m, output);
				retVect = deser.getVect();
			}
		}
		finally{
			if (out != null){
			  try{
			    out.close();
			  }
			  catch (Exception e){
			    System.err.println("An exception occurred when trying to close the file.");
			  }
			}
		}
		return retVect;
    }
}