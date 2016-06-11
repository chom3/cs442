package wordCount.visitors;

import java.io.File;
import wordCount.util.FileProcessor;
import wordCount.treesForStrings.Tree;
import wordCount.treesForStrings.Node;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.ArrayList;

public class WordCountVisitor implements TreeProcessingVisitorI{
    private File outputFile;
    private int numWords = 0;
    private String freqWord;
    private ArrayList<String> freqWords;
    private int numFreqWord = 0;
    private int numChars = 0;
    private int searchOccur = 0;
    private String search;
    public WordCountVisitor(File outIn, String searchIn)
    {
      outputFile = outIn;
      search = searchIn;
      freqWord = "";
      freqWords = new ArrayList<String>();
    }

// The total number of words is: NMNMN
// The most frequently used word is: ABC
// The frequency of the most frequently used word is: NNNN
// The number of characters (without whitespaces) is: MMMMM

    //Used http://stackoverflow.com/questions/10667734/java-file-open-a-file-and-write-to-it
    public void visit(Tree treeIn)
    {
      if (treeIn.getRoot() != null)
      {
        inOrderTraversal(treeIn.getRoot());
      }
      
      BufferedWriter out = null;
      try {
        //Clear the file
        PrintWriter writer = new PrintWriter(outputFile);
        writer.print("");
        writer.close();
        //Write into the file
        FileWriter fstream = new FileWriter(outputFile, true);
        out = new BufferedWriter(fstream);
        out.write("The total number of words is: " + numWords + "\n");
        out.write("The most frequently used word is: " +
          freqWordStringBuilder() + "\n");
        out.write("The frequency of the most frequently used word is: " + numFreqWord + "\n");
        out.write("The number of characters (without whitespaces) is: " + numChars + "\n");
        
      } catch(IOException e) {
        System.err.println("There was no output to write!");
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
    
    private String freqWordStringBuilder(){
      String freqWordString = "";
      for(String word : freqWords){
        freqWordString += word + " ";
      }
      return freqWordString;
    }


    //Just reuse my code from Tree.java
    //Traverse the tree in order
    //Figure out the statistics based on this
    public void inOrderTraversal(Node rootNode){
        if (rootNode != null)
        {
            numWords += rootNode.getNumOccurences();
            numChars += rootNode.getNumChars();
            String currentWord = rootNode.getWord();
            if (numFreqWord < rootNode.getNumOccurences())
            {
              //if we find a new most frequent word, we need to clear
              //the previously most frequent words. i.e. we need to
              //start our record keeping with a clean slate.
              freqWords.clear();
              freqWord = currentWord;
              freqWords.add(currentWord);
              //System.out.println(freqWord);
              numFreqWord = rootNode.getNumOccurences();
              // System.out.println(numFreqWord);
            } else if(numFreqWord == rootNode.getNumOccurences()){
              freqWords.add(currentWord);
              //System.out.println(currentWord);
            }
            if (search.equals(rootNode.getWord()))
            {
              searchOccur++;
            }
            inOrderTraversal(rootNode.getNodeL());
            inOrderTraversal(rootNode.getNodeR());
        }
    }
    
    public int getNumWords()
    {
      return numWords;
    }
    
    public String getFreqWord()
    {
      return freqWord;
    }
    
    public int getNumFreqWord()
    {
      return numFreqWord;
    }
    
    public int getNumChars(){
      return numChars;
    }
}
