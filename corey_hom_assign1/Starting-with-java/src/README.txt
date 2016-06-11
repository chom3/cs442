[
  adopted from http://www.cs.rochester.edu/u/www/courses/171/Fall-03/files/readme.txt
  by Deger Cenk Erdil
  for CS654 Distributed Systems
  This is a template README file about how you should form your own README file.
  In general,
        you should remove anything in between square brackets (i.e. [..]), and
        you should replace anything in between <> with a value.
]

CS542 Design Patterns
Spring 2016
PROJECT 1 README FILE

Due Date: Monday, Feburary 1, 2016
Submission Date: Monday, Feburary 1, 2016
Grace Period Used This Project: 0
Grace Period Remaining: 3
Author(s): Corey Hom
e-mail(s): chom3@binghamton.edu


PURPOSE:

[
  You will run the file using ja
]

PERCENT COMPLETE:

[
  I believe I completed 100% of the project, the output seems to be correct and
  they aren't any errors to my knowledge.
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

[
  Driver.java, the main class that will make the program work.
  FileProcessor.java, opens/reads the file line by line.
  StringOperations.java, works on the given string and counts the name occurrence.
  README.txt, the current file you are reading, explains the project.
]

JUSTIFICATION FOR DATA STRUCTURE:

[
  Decided to use a hashmap because it has an O(1) time to put an entry into it and
  also has, at worst, an O(n) time to look up the proper file.
  We use a for loop and only go through the entire hashmap once to find the most
  occurring words.
  
  An arraylist is also used to store the most occurring words to handle ties.
  It has an O(1) time to add a value, and only takes O(n) to print out all the 
  elements in the arraylist.

]
SAMPLE OUTPUT:

[
  The most frequently occurring element(s) is/are "ASIN". It/they occurred 15 times.
]

TO COMPILE:

[
  In terminal:
  javac *.java
]

TO RUN:

[
  In terminal: 
  
  java Driver -file name-
  
  In this case:
  
  java Driver amazon.wsdl
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Corey Hom

[
  Learning how to print the stack trace:
  http://stackoverflow.com/questions/6822968/print-the-stack-trace-of-an-exception
  Learning how to use BufferedReader:
  http://beginnersbook.com/2014/01/how-to-read-file-in-java-using-bufferedreader/
]

ACKNOWLEDGEMENT:

[
  N/A
]