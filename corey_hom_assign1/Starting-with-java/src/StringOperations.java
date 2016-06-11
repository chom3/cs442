/**
 * This class is going to parse based on "element name" and the resulting name.
 * Use a map -- We can initialize one and add an element when we find the word.
 * Increment that value on the map using add.
 **/

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;

public class StringOperations{
    private Map<String, Integer> wordMap;
    
    /**
     * Constructor to make a object that is a map.
     **/
    public StringOperations()
    {
        wordMap = new HashMap<String, Integer>();
    }
    
    /**
     * Setter/Mutator for the StringOperations construction.
     * @param any map of Map<String, Integer>
     **/ 
    public void setStrOp(Map<String, Integer> map)
    {
        wordMap = map;
    }
    
    /**
     * Getter/Accessor for the StringOperations construction.
     * @param none
     * @returns the current map that is being incremented on.
     **/ 
    public Map<String, Integer> getStrOp()
    {
        return wordMap;
    }
    
    /**
     * @params String line that we will operate on
     * Creates a hash map to increment based on what we find?
     **/
    public void findName(String line)
    {
        String search = "<xs:element name=";
        String name = null;
        if (line.indexOf(search) > 0)
        {
            name = line.split("name=")[1].split("( )|(>)")[0];
        }
        this.incrementValue(name);
    }
    
    /**
     * Increment an element on a hash list.
     * If element is null don't do anything.
     * If the current element doesn't exist in the hashmap
     * then we will make one
     * Else we will increment it.
     * @param Map<String,Integer, String elementName
     * @returns none
    **/
    public void incrementValue(String elementName) {
        Integer key = wordMap.get(elementName);
        if (elementName == null){} // or else we'll have 1000 nulls as an entry
        else if (key == null)
        {
            wordMap.put(elementName, 1);
        }
        else
        {
            wordMap.put(elementName, key+1);
        }
    }
    
    /**
     * A way to print out the values to check if the map is working correct
     * not really related to the project but I used it to understand 
     * where exactly my code was taking me.
     * Default toString that returns null
     * Mostly used in the driver as an action.
     * @param none
     * @returns null
     **/ 
    public String toString()
    {
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        return null;
    }
    
    /**
     * Finds the number of the most occurring word.
     * Use the Collections function to find the max value.
     * @param none
     * @returns an integer that represents the max value.
     **/
    public Integer findMostWordNum()
    {
        int maxValue = Collections.max(wordMap.values());
        return maxValue;
    }
    
     /**
     * Finds the most occurring word. Use a for loop on the map.
     * Find the matching high value with the string.
     * @param none
     * @returns a string of the most occurring word
     **/
    public ArrayList<String> findMostWord()
    {
        int maxValue = Collections.max(wordMap.values());
        ArrayList<String> words = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() == maxValue)
            {
                words.add(entry.getKey());
            }
        }
        return words;
    }
}