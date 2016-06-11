package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.server.SerStrategy;
import java.lang.reflect.Method;
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
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.lang.NoSuchMethodException;
import java.lang.IllegalAccessException;
import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class XMLSerialization implements SerStrategy {
    
    public void processInput(Object sObject, Method m, File output) {
    BufferedWriter out = null;
    try {
        FileWriter fstream = new FileWriter(output, true);
        out = new BufferedWriter(fstream);
		String allTypes = m.getParameterTypes()[0].toString();
		String[] outTypes = allTypes.split(" ");
		Class<?> className = Class.forName(outTypes[1]);
		Field[] fieldList = className.getDeclaredFields();
		//Write into the file
		out.write("<DPSerialization>");
		out.newLine();
		out.write(" <complexType xsi:type=\"");
		out.write(outTypes[1]);
		out.write("\">");
		out.newLine();
		for (int i = 0; i < fieldList.length; i++)
		{
			Class fieldClass = fieldList[i].getType();
			String fieldName = fieldList[i].getName();
			String fieldType = fieldClass.toString();
			if (fieldType.contains("String"))
			{
				fieldType = "string";
			}
			Method getMeth = className.getMethod("get"+fieldName);
			out.write("  <" + fieldName + " xsi:type=\"");
			out.write("xsd:");
			out.write(fieldType + ">");
			out.write(getMeth.invoke(sObject).toString());
			out.write("</" + fieldName + ">");
			out.newLine();
		}
		out.write(" </complexType>");
		out.newLine();
		out.write("</DPSerialization>");
		out.newLine();
    }
     catch(IOException e) {
    			System.err.println("There was no output to write!");
    		}
    catch (ClassNotFoundException canOpen)
    {
        System.out.println("The class wasn't found!");
        canOpen.printStackTrace(System.out);
        System.exit(1);
    }
    catch (NoSuchMethodException canOpen)
    {
        System.out.println("The method doesn't exist!");
        canOpen.printStackTrace(System.out);
        System.exit(1);
    }
    catch (IllegalAccessException canOpen)
    {
        System.out.println("Method illegally accessed!");
        canOpen.printStackTrace(System.out);
        System.exit(1);
    }
    catch (InvocationTargetException canOpen)
    {
        System.out.println("Invocation target exception!");
        canOpen.printStackTrace(System.out);
        System.exit(1);
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
   }
}