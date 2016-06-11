package wordCount.visitors;

import java.io.File;
import wordCount.util.FileProcessor;
import wordCount.treesForStrings.Tree;
import wordCount.treesForStrings.Node;

public class PopulateTreeVisitor implements TreeProcessingVisitorI{
    private FileProcessor fileProc;
    
    //Constructor
    public PopulateTreeVisitor(File fIn)
    {
        fileProc = new FileProcessor(fIn);
    }
    
    //Reads input file, populate tree data structure with the words.
    public void visit(Tree treeIn)
    {
        String currentLine = fileProc.readLineFromFile();
        while (currentLine != null){
            try{
                String[] words = splitToWords(currentLine);
                for (String word : words){
                    treeIn.insert(treeIn.getRoot(), word);
                }
                currentLine = fileProc.readLineFromFile();
            }
            catch (NumberFormatException e){
                System.err.println("This file doesn't follow the format of one integer per line!");
                System.exit(0);
            }
        }
    }


//Code Benny wrote, copied from the driver
  private int stringToInt(String str){
    int newint = 0;
    try{
      newint = Integer.parseInt(str);
    } catch (NumberFormatException e){
      System.err.println("Argument " + str + ", must be an integer.");
      System.exit(1);
    }
    return newint;
  }

  private String[] splitToWords(String str){
    //use regex instead of string literal to split by all white space
    //instead of simply splitting by a single whitespace character.
    //Splitting by a single white space character may lead to the case
    //where a whitespace character is the most common word in the file.
    return str.split("\\s+");
  }

  public String toString(){
    return "";
  }

}
