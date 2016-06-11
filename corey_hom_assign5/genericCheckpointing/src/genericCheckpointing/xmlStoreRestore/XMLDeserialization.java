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
import java.util.Vector;
import java.lang.InstantiationException;
import java.lang.ClassNotFoundException;
import java.lang.NoSuchMethodException;
import java.lang.IllegalAccessException;
import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class XMLDeserialization implements SerStrategy {
    private static Vector retVect;
    public void processInput(Object sObject, Method m, File output) {
        BufferedReader reader = null;
        retVect = new Vector();
        try {
            reader = new BufferedReader(new FileReader(output));
            String line = reader.readLine();
            String[] getFields = null;
            Class<?> className = null;
            Field[] fieldList = null;
            Object obj = null;
            while(line != null)
            {
            	// System.out.println(line);
            	//Create the object
            	if (line.contains("complexType xsi:type"))
            	{
            		getFields = line.split("type=");
            		getFields[1] = getFields[1].replace("\"", "");
            		getFields[1] = getFields[1].replace(">", "");
            		className = Class.forName(getFields[1]);
            		fieldList = className.getDeclaredFields();
            		obj = className.newInstance();
            	}
            	//Give the object parameters using set and invoke
            	else if (!(line.contains("DPSerialization") || line.contains("complexType")))
            	{
            		getFields = line.split(">");
            		getFields = getFields[1].split("<");
            		String param = getFields[0];
            		// System.out.println(param);
            		Method setMeth = null;
    				for (int i = 0; i < fieldList.length; i++)
    				{
    					Class fieldClass = fieldList[i].getType();
    					String fieldName = fieldList[i].getName();
    					String fieldType = fieldClass.toString();
    					Class<?>[] signature = new Class<?>[1];
    					signature[0] = fieldClass;
    					setMeth = className.getMethod("set"+fieldName, signature);
    					// System.out.println(fieldName);
    					if( line.contains("myBool") && fieldName.contains("myBool"))
    				    {
    				    	setMeth.invoke(obj,Boolean.parseBoolean(param));
    				    	// System.out.println(Boolean.parseBoolean(param));
    				    }
    				    else if( line.contains("myShortT") && fieldName.contains("myShortT"))
    				    {
    				    	setMeth.invoke(obj,Short.parseShort(param));
    				    	// System.out.println(Short.parseShort(param));
    				    }
    				    else if( line.contains("myInt") && fieldName.contains("myInt"))
    				    {
    				    	setMeth.invoke(obj,Integer.parseInt(param));
    				    	// System.out.println(Integer.parseInt(param));
    				    }
    				    else if(line.contains("myLong") && fieldName.contains("myLong"))
    				    {
    				    	setMeth.invoke(obj,Long.parseLong(param));
    				    	// System.out.println(Long.parseLong(param));
    				    }
    				    else if(line.contains("myFloatT") && fieldName.contains("myFloatT"))
    				   	{
    				   		setMeth.invoke(obj,Float.parseFloat(param));
    				   		// System.out.println(Float.parseFloat(param));
    				    }
    				    else if( line.contains("myDoubleT") && fieldName.contains("myDoubleT"))
    				    {
    				    	setMeth.invoke(obj,Double.parseDouble(param));
    				    	// System.out.println(Double.parseDouble(param));
    					}
    					else if (line.contains("myString") && fieldName.contains("myString"))
    					{
    						setMeth.invoke(obj, param);
    						// System.out.println(param);
    					}
    					else if (line.contains("myCharT") && fieldName.contains("myCharT"))
    					{
    						setMeth.invoke(obj, param.charAt(0));
    						// System.out.println(param);
    					}
    				}
        	    }
        	    else if (line.contains("</DPSerialization>"))
            	{
            		retVect.add(obj);
            	}
            	line = reader.readLine();
        	}
        }
        catch(IOException e) {
			System.err.println("There was no output to write!");
			e.printStackTrace(System.out);
            System.exit(1);
		}
		catch(InstantiationException e){
		    System.err.println("There was a problem with instantiation!");
			e.printStackTrace(System.out);
            System.exit(1);
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
   
   public Vector getVect()
   {
       return retVect;
   }
}