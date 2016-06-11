package wordCount.driver;

import wordCount.util.FileProcessor;
import java.io.File;
import wordCount.treesForStrings.Tree;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.WordCountVisitor;
import wordCount.visitors.grepVisitor;
public class Driver{

  int NUM_ARGS = 4;

  public static void main(String[] args){
    Driver driver = new Driver();

    if(args.length !=driver.NUM_ARGS){
      System.err.println("Expected " + driver.NUM_ARGS + "arguments." +
                          " Got " + args.length + ".");
      System.err.println("Usage: <input_file> <output_file> <iterations>" +
                          " <search_string>");
      System.exit(1);
    }

    //make sure that the input file is a valid file name
    File file = new File(args[0]);
    File output = new File(args[1]);
    //we don't need to make sure that the output file is a valid
    //file name. We can simply write to the file

    //We need to check the number of iterations is a number
    long NUM_ITERATIONS = driver.stringToLong(args[2]);
    //doesn't make sense to have number of iterations as < 1
    if(NUM_ITERATIONS < 1){
      System.err.println("NUM_ITERATIONS must be greater than 0");
      System.err.println("Exiting.");
      System.exit(1);
    }

    //save the search string
    String searchString = args[3];
    

    long startTime = System.currentTimeMillis();
    for (int i = 0; i < NUM_ITERATIONS; i++){
      Tree tree = new Tree();
      //PopulateTreeVisitor 
      TreeProcessingVisitorI popTree = new PopulateTreeVisitor(file);
      //WordCountVisitor 
      TreeProcessingVisitorI wordTree = new WordCountVisitor(output, searchString);
      //grepVisitor 
      TreeProcessingVisitorI grepTree = new grepVisitor(output, searchString);
      tree.accept(popTree);
      tree.accept(wordTree);
      tree.accept(grepTree);
    }
    long finishTime = System.currentTimeMillis();
    //System.out.println("total time: " + (finishTime - startTime));
    //System.out.println("iterations: " + NUM_ITERATIONS);
    //long total_time = (finishTime - startTime)/NUM_ITERATIONS;
    double total_time = (finishTime - startTime) / 
                          (double) NUM_ITERATIONS;
    System.out.println("Total time: " + total_time);
  }

  private long stringToLong(String str){
    long newLong = 0;
    try{
      newLong = Long.parseLong(str);
    } catch (NumberFormatException e){
      System.err.println("Argument " + str + ", must be an integer.");
      System.exit(1);
    }
    return newLong;
  }

  private String[] splitToWords(String str){
    return str.split(" ");
  }

  public String toString(){
    return "";
  }

}
