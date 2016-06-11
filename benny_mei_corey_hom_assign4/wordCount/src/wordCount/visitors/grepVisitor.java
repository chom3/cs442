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

public class grepVisitor implements TreeProcessingVisitorI{
    
    private File outputFile;
    private int searchOccur = 0;
    private String search;
    
    //Literally the same as WordCountVisitor
    public grepVisitor(File outIn, String searchIn)
    {
      outputFile = outIn;
      search = searchIn;
    }

// The word < search-string > occurs the following times: MMMN

    //Used http://stackoverflow.com/questions/10667734/java-file-open-a-file-and-write-to-it
    public void visit(Tree treeIn)
    {
      if (treeIn.getRoot() != null)
      {
        inOrderTraversal(treeIn.getRoot());
      }
      
      BufferedWriter out = null;
      try {
        //Write into the file
        FileWriter fstream = new FileWriter(outputFile, true);
        out = new BufferedWriter(fstream);
        out.write("The word < " + search + " < occurs the following times: " + searchOccur + "\n");
        
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


    //Just reuse my code from Tree.java
    //Same code from WordCountVisitor
    public void inOrderTraversal(Node rootNode){
        if (rootNode != null)
        {
            String currentWord = rootNode.getWord();
            if (search.equals(rootNode.getWord()))
            {
              searchOccur = rootNode.getNumOccurences();
            }
            inOrderTraversal(rootNode.getNodeL());
            inOrderTraversal(rootNode.getNodeR());
        }
    }
}
