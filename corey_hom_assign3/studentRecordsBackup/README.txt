CS442 Design Patterns
Spring 2016
PROJECT 3 README FILE

Due Date: Due by 11.59 PM EST on March 22nd.
Submission Date: March 16
Grace Period Used This Project: 0 Days
Grace Period Remaining: 3 Days
Author(s): Corey Hom
e-mail(s): chom3@binghamton.edu


PURPOSE:

[
    The purpose of this assignment was to create one binary search tree and two replicas and to implement the observers/subject pattern.
    An UPDATE_VALUE integer would be passed in to increment all the nodes in the tree and the replicas by that amount.
    The max value in the tree would get the UPDATE_VALUE * 2.
    Both backup trees have filters, however, one would filter only even numbers and the other odd.
    If the UPDATE_VALUE post increment was even/odd, it would not be incremented depending on the tree.
]

PERCENT COMPLETE:

[
  I believe I completed 100% of the project. 
]

PARTS THAT ARE NOT COMPLETE:

[
  N/A
]

BUGS:

[
  N/A
]

FILES:

[
  Driver.java - the main file that will run the entire program.
  FileProcessor.java - the file responsible for reading the input file.
  Logger.java - A logger file that helps write messages for debugging.
  README.txt - The README file that helps clarify the project details.
  BST.java - responsible for creating a binary search tree object
  Node.java - responsible for creating a Node, a building block for a BST
  ObserverI.java - creates the Observer interface for the Node
  SubjectI.java - creates the Subject interface for the node
  BSTBuilder.java - responsible for building the tree as the file is read
  EvenFilterImpl.java - responsible for creating the even filter 
  OddFilterImpl.java - responsible for creating the odd filter
  OddEvenFilterI.java - responsible for creating the filter interfaces
]

SAMPLE OUTPUT:

[
I used my own file and used the number 100 as the UPDATE_VALUE.
 ant -buildfile src/build.xml run -Darg0=bstInput.txt  -Darg1=100
Buildfile: /home/ubuntu/workspace/corey_hom_assign3/studentRecordsBackup/src/build.xml

jar:

run:
     [java] Printing out nodes in order for main-tree: 
     [java] 1
     [java] 2
     [java] 3
     [java] 4
     [java] 5
     [java] 6
     [java] 7
     [java] 8
     [java] 9
     [java] 10
     [java] Printing out nodes in order for backup-tree 1: 
     [java] 1
     [java] 2
     [java] 3
     [java] 4
     [java] 5
     [java] 6
     [java] 7
     [java] 8
     [java] 9
     [java] 10
     [java] Printing out nodes in order for backup-tree 2: 
     [java] 1
     [java] 2
     [java] 3
     [java] 4
     [java] 5
     [java] 6
     [java] 7
     [java] 8
     [java] 9
     [java] 10
     [java] The max value is: 10
     [java] Main-BST sum: The sum of all the B-Numbers is: 55
     [java] Backup-1 sum: The sum of all the B-Numbers is: 55
     [java] Backup-2 sum: The sum of all the B-Numbers is: 55
     [java] Applying UPDATE_VALUE!
     [java] The max value is: 210
     [java] Main-BST sum: The sum of all the B-Numbers is: 1155
     [java] Backup-1 sum: The sum of all the B-Numbers is: 655
     [java] Backup-2 sum: The sum of all the B-Numbers is: 555
]

TO COMPILE:

[
    ## To compile: 
    ant -buildfile src/build.xml all
]

TO RUN:

[
    ## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]

    ant -buildfile src/build.xml run -Darg0=[bstInput.txt]  -Darg1=[UPDATE_VALUE]
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<Corey Hom>

[
  Some links were used and commented in for helping do some binary search tree methods.
]

ACKNOWLEDGEMENT:

[
    The CSx42 list serv.
]


OTHER COMMANDS LEFT IN THE README:
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile src/build.xml run

## To create tarball for submission
ant -buildfile src/build.xml tarzip