package studentRecordsBackup.bst;

import studentRecordsBackup.bst.Node;


//Copying from the slides...

public interface SubjectI
{
    public void registerObserver(ObserverI o);
    public void removeObserver(ObserverI o);
    //Going to pass the max to make it easier
    public void notifyObservers(int max, int valueIn); //parameters?
}