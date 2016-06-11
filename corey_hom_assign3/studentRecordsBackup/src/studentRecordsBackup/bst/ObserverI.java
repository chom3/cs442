package studentRecordsBackup.bst;

import studentRecordsBackup.bst.Node;


//Copying from the slides...
public interface ObserverI
{
    //Going to pass the max to make it easier to update the max 2 * UPDATE_VALUE
    public void update(int max, int valueIn);
}