package studentRecordsBackup.util;

import studentRecordsBackup.bst.Node;
/**
 * Register even/odd
 * Overloaded method calls
 **/
 
public interface OddEvenFilterI
{
    public void filterEven();
    public void filterEven(Node root);
    public void filterOdd();
    public void filterOdd(Node root);
}