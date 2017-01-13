//eg2850
//Programming Project 5
//Scrabble 
//Spring 2016
//readMe

To start, I wrote the templates of how the class WordLists and the tester would work. After writing out on paper all of the components I need, I went ahead and began to comment out to form the skeleton for the assignment. 
I know handling errors is something I need to incorporate, but first I wanted to build the program. 

In the tester class, I created a sort of interface that asks the user what they wish to do, allowing them to choose which method they want to run on the dictionary file. 

I followed the examples we went over in lecture to construct the WordLists object class. 

I then noticed that we had a template to work with so I had to rewrite some methods - for example I was outputting array lists but saw that we needed to return arrays. I had to look up to refresh how to cast an array list into an array and did so. 

For the vowel method - I did something similar with a programming project at Duke University - so I relied on another boolean method that would check if the character the program is looking at is a vowel or not.. 

After writing in all the methods, I went into my tester class and wrote a separate static method to save an output file that could be used with each option. Once done, I began to test all of the methods. Once satisfied that they were printing the correct answers to the file. I began the process of exception handling and cleaning up the code. 

For one, I added a conversion for all methods that accepted a character to turn it to lower case. 

For another, I needed to sharpen my understanding of the try-catch and throw exception handling. In order to do so, I did do some tutorials online as well as re-read notes from lecture. 

Finally, I just cleaned up the code and followed the instructions from piazza and the lectures to finalize the project. 
