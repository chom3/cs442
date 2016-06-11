CS442 Design Patterns
Spring 2016
PROJECT 5 README FILE

Due Date: Due by 11.59 PM on May 8th.
Submission Date: May 5th
Grace Period Used This Project: 0 Days
Grace Period Remaining: 2 Days
Author(s): Corey Hom
e-mail(s): chom3@binghamton.edu


PURPOSE:

[
    The purpose of this assignment was to use a dynamic proxy and reflection to serialize or deserialize an XML file containing objects,
    store those objects in a vector, and later compare them to see if the serialization/deserialization process was correct. Also the
    strategy pattern was incorporated into the program.
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
  README.txt - The README file that helps clarify the project details.
  RestoreI.java - the interface responsible for reading the objects.
  StoreI.java - the interface responsible for writing the objects.
  StoreRestoreI.java - a tag interface.
  MyAllTypesFirst.java - an extension of SerializableObject, creates an object with different fields.
  MyAllTypesSecond.java - an extension of SerializableObject, creates an object with different fields from MyAllTypesFirst.java.
  SerializableObject.java - an empty base class.
  ProxyCreator.java - A given file responsible for creating the proxy.
  StoreRestoreHandler.java - the majority of the code responsible for the invocation of readObj() and writeObj().
]

SAMPLE OUTPUT:

[
WHEN RUNNING SERDESER AS AN ARGUMENT
ant -buildfile src/build.xml run -Darg0=serdeser -Darg1=4  -Darg2=output.txt 
Buildfile: /home/ubuntu/workspace/corey_hom_assign5/genericCheckpointing/src/build.xml

jar:
      [jar] Building jar: /home/ubuntu/workspace/corey_hom_assign5/genericCheckpointing/BUILD/jar/genericCheckpointing.jar

run:
     [java] 0 mismatched objects
]

WHEN RUNNING DESER AS AN ARGUMENT
ant -buildfile src/build.xml run -Darg0=deser -Darg1=4  -Darg2=output.txt                                                            
Buildfile: /home/ubuntu/workspace/corey_hom_assign5/genericCheckpointing/src/build.xml

jar:

run:
     [java] 8
     [java] Int: 8
     [java] Long: 314159
     [java] String: shiny
     [java] Bool: true
     [java] 
     [java] Double: 2.0
     [java] Float: 3.09
     [java] Short: 5
     [java] Char: c
     [java] 
     [java] Int: 8
     [java] Long: 314159
     [java] String: shiny
     [java] Bool: true
     [java] 
     [java] Double: 2.0
     [java] Float: 3.09
     [java] Short: 5
     [java] Char: c
     [java] 
     [java] Int: 8
     [java] Long: 314159
     [java] String: shiny
     [java] Bool: true
     [java] 
     [java] Double: 2.0
     [java] Float: 3.09
     [java] Short: 5
     [java] Char: c
     [java] 
     [java] Int: 8
     [java] Long: 314159
     [java] String: shiny
     [java] Bool: true
     [java] 
     [java] Double: 2.0
     [java] Float: 3.09
     [java] Short: 5
     [java] Char: c
     [java] 

TO COMPILE:

[
    ## To compile: 
    ant -buildfile src/build.xml all
]

TO RUN:

[
    ## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]

    ant -buildfile src/build.xml run -Darg0=<deser or serdeser> -Darg1=<some number of how many times you want to write>  -Darg2=<text file>
    We use output.txt in this case.
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<Corey Hom>

[
  
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