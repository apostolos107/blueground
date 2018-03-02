# Json Parser ( wunderground )
Blueground Test Program

Library used json-simple-1.1.1

All the classes are in src directory.
Also in src is a makefile.

## To run
Just type make at the terminal and the program will be compiled and run (linux-makefile).
The output is a txt file with name metrics.txt.

## Clean
You can clean the .class files and the output by just typing make clean(linux-makefile).

## class SearchInfo
This class just have the information for the search that you want.

## class DailyResults
It has the metrics that we need. This class has a funtcion called Calculate in which
you have to pass an SearchInfo object (specifically the information that you want to search).
This function connects with the url, it parses the json , it gets the object "dailysummary" 
where are the information that we need and update its metrics with this information.
The other function that this class has, is the writeFile which simply writes a file(metrics.txt) 
with the metrics.

## class Main 
Just make an object SearchInfo and DailyResults. After the main calls the Calculate funtion 
of the DailyResults object and then the wirteFile function.
