ant -buildfile src/build.xml all

ant -buildfile src/build.xml run -Darg0=test.txt -Darg1=output.txt  -Darg2=4 -Darg3=aaa 

CS442 Design Patterns
Spring 2016
PROJECT 4 README FILE

Due Date: Tuesday, April 19, 2016 
Submission Date: Tuesday, April 20, 2016
Grace Period Used This Project: 1 Days
Grace Period Remaining: 4 Days
Author(s): Corey Hom, Benny Mei 
e-mail(s): chom3@binghamton.edu, bmei3@binghamton.edu 


PURPOSE:

The purpose of this project is to demonstrate an understanding of the
Visitor Design Pattern through manipulating data stored in a tree.

PERCENT COMPLETE:

[
  We believe we have completed 100% of the project.
]

PARTS THAT ARE NOT COMPLETE:

[
N/A
]

BUGS:

[
None
]

FILES:

Included with this project are 10 files:
Driver.java - the entry point into the program. Contains the main()
Node.java - Contains an implementation of a node which is stored within
the tree.

Tree.java - Contains an implementation of a binary search tree.
FileProcessor.java - Used to read and parse the input file.
grepVisitor.java - Used to implement "grep" functionality. 
PopulateTreeVisitor.java - This visitor is used to populate the tree at
the start of the program.

TreeProcessingVisitorI.java - An interface that all visitors implement.
We program to an interface, not an implementation.

WordCountVisitor.java - This visitor is used to calculate statistics
about the input file including the number of words, number of
characters, and the most frequent word.

build.xml - Provides instructions on how ant should operate.
README.txt - The text file that you are currently reading.

SAMPLE OUTPUT:

Buildfile: /home/ubuntu/workspace/benny_mei_corey_hom_assign4/wordCount/src/build.xml

jar:

run:
     [java] Total time: 0.9

BUILD SUCCESSFUL
Total time: 0 seconds


TO COMPILE:

Make sure that you are in the directory that this README.txt file is
located in.

Then, simply run the command

ant -buildfile src/build.xml all

TO RUN:

Make sure that you are in the directory that this README.txt file is
located in.

Then, simply run the command

ant -buildfile src/build.xml run -Darg0=<input file> 
-Darg1=<output file>  -Darg2=<number of iterations> 
-Darg3=<search string> 


EXTRA CREDIT:

N/A

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Corey Hom, Benny Mei

[
http://stackoverflow.com/questions/10667734/java-file-open-a-file-and-write-to-it
This was used to just write to the file, refreshing memory.
Also used previous project code, mostly from Corey's assignment 3.
]

ACKNOWLEDGEMENT:


DATA STRUCTURE:
We used a Binary Search Tree (BST) as our data structure. BSTs provide
quick (O(log(n))) insert time provided that the provided input is not
sorted. Because we had to base our data structure decision on the posted
sample input files in the listserv, AND because none of the posted input
files contained sorted input of any kind, we decided a BST was the best
choice for a data structure.
