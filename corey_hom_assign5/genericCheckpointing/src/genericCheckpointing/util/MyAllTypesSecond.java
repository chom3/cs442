package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
    private double myDoubleT;
    private float myFloatT;
    private short myShortT;
    private char myCharT;
    
    
    public MyAllTypesSecond()
    {
        
    }
    public MyAllTypesSecond(double myDoubleTIn, float myFloatTIn, short myShortTIn, char myCharTIn)
    {
        myDoubleT = myDoubleTIn;
        myFloatT = myFloatTIn;
        myShortT = myShortTIn;
        myCharT = myCharTIn;
    }
    
    public double getmyDoubleT()
    {
        return myDoubleT;
    }
    
    public float getmyFloatT()
    {
        return myFloatT;
    }
    
    public short getmyShortT()
    {
        return myShortT;
    }
    
    public char getmyCharT()
    {
        return myCharT;
    }
    
    public void setmyDoubleT(double myDoubleTIn)
    {
        myDoubleT = myDoubleTIn;
    }
    
    public void setmyFloatT(float myFloatTIn)
    {
        myFloatT = myFloatTIn;
    }
    
    public void setmyShortT(short myShortTIn)
    {
        myShortT = myShortTIn;
    }
    
    public void setmyCharT(char myCharTIn)
    {
        myCharT = myCharTIn;
    }
    
    public String toString()
    {
        System.out.println("MyAllTypesSecond Object");
        System.out.println("Double: " + myDoubleT);
        System.out.println("Float: " + myFloatT);
        System.out.println("Short: " + myShortT);
        System.out.println("Char: " + myCharT);
        return "";
    }
    
    @Override
    public boolean equals(Object obj)
    {
        MyAllTypesSecond in = (MyAllTypesSecond) obj;
        
        if (myDoubleT == in.getmyDoubleT() &&
        myShortT == in.getmyShortT() &&
        myFloatT == in.getmyFloatT() &&
        myCharT == in.getmyCharT())
        {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
    int hash = 5;
    hash = hash * (int) myDoubleT;
    hash = hash * (int) myFloatT;
    hash = hash * (int) myShortT;
    hash = hash * (int) myCharT;
    return hash;
    }
}