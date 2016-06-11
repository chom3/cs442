package wordCount.treesForStrings;

public class Node{

  private String word;
  private int numChars = 0;
  private int numOccurences = 1;
  
  public Node left;
  public Node right;

  public Node(String wordIn){
    word = wordIn;
    numChars = word.length();
  }

  public String getWord(){
    return word;
  }
  
  
  /**
  * Getter/Accessor for right node
  * @params none
  * @returns right node of current node
  **/
  public Node getNodeR()
  {
    return right;
  }
  
  /**
  * Setter/Mutator for right node
  * @params Node object
  * @returns none
  **/
  public void setNodeR(Node rightIn)
  {
    right = rightIn;
  }
  
  /**
  * Getter/Accessor for left node
  * @params none
  * @returns left node of current node
  **/
  public Node getNodeL()
  {
    return left;
  }
  
  /**
  * Setter/Mutator for left node
  * @params Node object
  * @returns none
  **/
  public void setNodeL(Node leftIn)
  {
    left = leftIn;
  }
  
  public int getNumChars()
  {
    return numOccurences*numChars;
  }
  
  public void incrementOccurence()
  {
    numOccurences++;
  }
  
  public int getNumOccurences()
  {
    return numOccurences;
  }

}
