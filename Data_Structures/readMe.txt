/*
 * Homework3
 * Elena V. Gladoun
 * eg2850
 */


//--------------------------------------------------------------------------------
//PROGRAMMING
//--------------------------------------------------------------------------------

//Problem1

Code:
to compile:
javac ExpressionTree.java
javac MyStack.java
javac Problem1.java

to run:
java Problem1

Please note, the program will ask you for a post fix expression, enter such an expression after the prompt as a string using spaces to separate inputs. 


Notes: 
-I used myStack class from my previous submission.
 
-I decided to utilize the String split method to divide the tokens as per the recommendations of the professor and from the java API. 

-I created an additional private class called isNumber - it evaluates if the expression contains any operands. In the constructor of the main class itself, I surrounded this with a try catch in case the input was something outside of the scope of the operators and operands. In this try catch, I found in the java API a method System.exit that would terminate the program and not continue to try and call methods on an invalid input. 

-for the evaluate method, I had to compare characters to the operations and then apply the appropriate operations like that because you can’t really cast a character as an operator- as far as I saw. 

-I used the string builder class as was recommended in class as using only strings is inefficient since they are immutable. 


//--------------------------------------------------------------------------------

//Problem2

Code:
to compile:
(in no particular order)

javac AvlTree.java
javac Problem2.java
javac UnderflowException.java

to run:
(Please have the txt file in the same directory. The text file given to us in the assignment was used for testing purposes - 2016su.txt.) 

java Problem2 2016su.txt

Notes: 
- In the Problem2 class itself, as per the problem prompt, this is a command line program, meaning, in order to read in a file, you need to provide it as a command line argument (see the example above under to run where the text that was given to us in class is run through the program). 

- Also in Problem2, initially the program only tested if the character was a letter, stopped when it came to a space and then stored the letter. However, for some reason through the use of StringBuilder or otherwise, there was a word “ “ input as a node every time there were special characters (such as dashes - -), so with the use of an additional if (.equals) statement, the problem was circumnavigated.  

- In the AvlTree class, I first added an instance variable of linked list that would store the linked list of the indexes as they were read and input from the file. I added the field of index for when creating a Avl Tree node. However, because I was using strings primarily, I removed the generics from this class.

- In the AvlTree class, I also used compareTo on strings which was the basis of comparison when running the code, ultimately producing an alphabetic ordered list upon print. 

- In the UnderflowException class, I was unsure admittedly, of what to do, I did follow prompts given by Eclipse in order for the class to compile - including a Serial Version Addition (?).   