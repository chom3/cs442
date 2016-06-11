CS442 Design Patterns
Spring 2016
PROJECT 2 README FILE

Due Date: Due by 11.59 PM EST on Feb 29th.
Submission Date: February 23
Grace Period Used This Project: 0 Days
Grace Period Remaining: 3 Days
Author(s): Corey Hom
e-mail(s): chom3@binghamton.edu


PURPOSE:

[
  The project uses multithreading to read a file line by line. There are 
  options to select how many threads should be used from 1-5, and different levels
  of debugging to show different stdout results. The main goal is to 
  determine what are "prime" (non-even) numbers. The numbers are stored in a vector.
  Debug level 0 shows the sum of all the prime numbers. 1 shows the contents of
  the vector. 2 shows everytime an entry is added to the vector. 3 shows everytime
  a thread's run() method is called, and 4 shows everytime a constructor is called.
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

JUSTIFICATION FOR DATA STRUCTURE:

[
  I decided to use a vector because in class we were told that vectors were synchronized in java.
  This makes it thread safe as I add numbers to it and add is also a O(1) time in complexity. 
  Printing out all the contents of the vector and adding all the values in a vector is an O(n) complexity,
  which isn't terribly expensive in this file.
  A vector also doubles in size if it ever gets filled, but this is no issue as 5 threads should make the 
  program work pretty quickly, and I don't think the file being passed into the program will be of a 
  unbelievably large size. We were also told that the integer to strings will not be able to overflow the program,
  so any issues there are no threats to the usage of a vector. 
  I didn't use a vector for much else in the results so the only selling point of using a vector over an
  arraylist was that it was thread safe.

]

FILES:

[
  Driver.java - the main file that will run the entire program.
  Results.java - the file responsible for creating the storing object and
  displays sum of the prime numbers. 
  StdoutDisplay.java - the interface file responsible for writing the sum 
  to the screen.
  StoreData.java - the interface file responsible for adding a prime number to
  the vector.
  CreateWorkers.java - the file responsible for creating the threads.
  WorkerThreads.java - the file responsible for making the workers read the file
  and add to the results.
  FileProcessor.java - the file responsible for reading the input file.
  IsPrime.java - the file responsible for checking if a number is prime.
  Logger.java - A logger file that helps write messages for debugging.
  README.txt - The README file that helps clarify the project details.
]

SAMPLE OUTPUT:

[
  In this sample output, I display all 5 debugging levels (0,1,2,3,4) for 5 threads.
  chom3:~/workspace/corey_hom_assign2/primeThreads $ ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=5 -Darg2=0
Buildfile: /home/ubuntu/workspace/corey_hom_assign2/primeThreads/src/build.xml

jar:
      [jar] Building jar: /home/ubuntu/workspace/corey_hom_assign2/primeThreads/BUILD/jar/primeThreads.jar

run:
     [java] The sum of all the prime numbers is: 250

BUILD SUCCESSFUL
Total time: 0 seconds
chom3:~/workspace/corey_hom_assign2/primeThreads $ ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=5 -Darg2=1
Buildfile: /home/ubuntu/workspace/corey_hom_assign2/primeThreads/src/build.xml

jar:

run:
     [java] Print the contents of the store.
     [java] 1
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 5
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9
     [java] 1
     [java] 3
     [java] 5
     [java] 7
     [java] 9

BUILD SUCCESSFUL
Total time: 0 seconds
chom3:~/workspace/corey_hom_assign2/primeThreads $ ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=5 -Darg2=2
Buildfile: /home/ubuntu/workspace/corey_hom_assign2/primeThreads/src/build.xml

jar:

run:
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.
     [java] Entry added to Results data structure.

BUILD SUCCESSFUL
Total time: 0 seconds
chom3:~/workspace/corey_hom_assign2/primeThreads $ ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=5 -Darg2=3
Buildfile: /home/ubuntu/workspace/corey_hom_assign2/primeThreads/src/build.xml

jar:

run:
     [java] Run has been called.
     [java] Run has been called.
     [java] Run has been called.
     [java] Run has been called.
     [java] Run has been called.

BUILD SUCCESSFUL
Total time: 0 seconds
chom3:~/workspace/corey_hom_assign2/primeThreads $ ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=5 -Darg2=4
Buildfile: /home/ubuntu/workspace/corey_hom_assign2/primeThreads/src/build.xml

jar:

run:
     [java] FileProcessor constructor called.
     [java] Results constructor called.
     [java] IsPrime constructor called.
     [java] CreateWorkers constructor called.
     [java] WorkerThread constructor called.
     [java] WorkerThread constructor called.
     [java] WorkerThread constructor called.
     [java] WorkerThread constructor called.
     [java] WorkerThread constructor called.

BUILD SUCCESSFUL
Total time: 0 seconds
]

TO COMPILE:

[
    ## To compile: 
    ant -buildfile src/build.xml all
]

TO RUN:

[
    ## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
    ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=secondarg -Darg2=thirdarg
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<Corey Hom>

[
  None
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