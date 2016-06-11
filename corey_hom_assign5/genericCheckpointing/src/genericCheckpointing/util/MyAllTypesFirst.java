package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
    //setters and getters for int long string bool
    private int myInt;
    private long myLong;
    private String myString;
    private boolean myBool;
    
    public MyAllTypesFirst()
    {
        
    }
    public MyAllTypesFirst(int myIntIn, long myLongIn, String myStringIn, boolean myBoolIn)
    {
        myInt = myIntIn;
        myLong = myLongIn;
        myString = myStringIn;
        myBool = myBoolIn;
    }
    
    public int getmyInt()
    {
        return myInt;
    }
    
    public long getmyLong()
    {
        return myLong;
    }
    
    public String getmyString()
    {
        return myString;
    }
    
    public boolean getmyBool()
    {
        return myBool;
    }
    
    public void setmyInt(int myIntIn)
    {
        myInt = myIntIn;
    }
    
    public void setmyLong(long myLongIn)
    {
        myLong = myLongIn;
    }
    
    public void setmyString(String myStringIn)
    {
        myString = myStringIn;
    }
    
    public void setmyBool(boolean myBoolIn)
    {
        myBool = myBoolIn;
    }
    
    public String toString()
    {
        System.out.println("MyAllTypesFirst Object");
        System.out.println("Int: " + myInt);
        System.out.println("Long: " + myLong);
        System.out.println("String: " + myString);
        System.out.println("Bool: " + myBool);
        return "";
    }
    
    @Override
    public boolean equals(Object obj)
    {
        MyAllTypesFirst in = (MyAllTypesFirst) obj;
        
        if (myInt == in.getmyInt() &&
        myLong == in.getmyLong() &&
        myString.equals(in.getmyString()) &&
        myBool == in.getmyBool())
        {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        int boolH = 1237;
        if (myBool == true)
        {
            boolH = 1231;
        }
        int hash = 5;
        hash = hash * myInt;
        hash = hash * (int)myLong;
        hash = hash * boolH;
        hash = hash * myString.hashCode();
        return hash;
    }
}