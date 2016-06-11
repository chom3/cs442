package wordCount.treesForStrings;

import wordCount.visitors.TreeProcessingVisitorI;
import java.lang.String;


public class Tree{
    private Node root;
    
    public Tree()
    {
        root = null;
    }
    
    public Node getRoot()
    {
        return root;
    }
    
    public void setRoot(Node rootIn)
    {
        root = rootIn;
    }
    
    public void accept(TreeProcessingVisitorI visitor)
    {
        visitor.visit(this);
    }
    
    public void insert(Node currentNode, String wordIn)
    {
        if (currentNode == null)
        {
            currentNode = new Node(wordIn);
            root = currentNode;
        }
        else if (wordIn.compareTo(currentNode.getWord()) < 0)
        {
            if (currentNode.getNodeL() == null)
            {
                currentNode.setNodeL(new Node(wordIn));
            }
            else
            {
                insert(currentNode.getNodeL(), wordIn);
            }
        }
        else if (wordIn.compareTo(currentNode.getWord()) > 0)
        {
            if (currentNode.getNodeR() == null)
            {
                currentNode.setNodeR(new Node(wordIn));
            }
            else
            {
                insert(currentNode.getNodeR(), wordIn);
            }
        }
        else if (wordIn.equals(currentNode.getWord()))
        {
            currentNode.incrementOccurence();
        }
    }
    
    /**
    * Inorder traversal
    * Recursive, overload because driver can't have access to rootnode?
    * @params root node
    **/
    public void printInOrder()
    {
        inOrderTraversal(root);
    }
    
    public void inOrderTraversal(Node rootNode){
        if (rootNode != null)
        {
            inOrderTraversal(rootNode.getNodeL());
            System.out.println(rootNode.getWord());
            inOrderTraversal(rootNode.getNodeR());
        }
    }
    
}