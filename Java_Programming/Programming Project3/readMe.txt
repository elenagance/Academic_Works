//*************************************
//Elena Gladoun
//eg2850
//Programming Project #3
//*************************************

//8.1//

First thing that I did was to review the problem assignment, the wording in the textbook, and then the test class provided. After this I wrote out the code provided by the textbook, then I outlined my comments as a snapshot of what I wanted to accomplish.

I followed piazza’s questions and answers as I did not understand initially why turning right would go backwards in the dial, after looking at a combo lock, I was more familiarized with the object and coded it. 

After this, I needed to put in a print statement to handle numbers that are over 40. After testing the program a couple of times, and attempting to break it, it seems to be producing the correct output and not crashing. 

//8.3//

After reading the problem a couple of times, writing it out, exploring the template for the zip code class as well as the zip code tester, I studied the chart provided in the txt book to familiarize with the process of translating a zip code to a bar code and vise versa. 

I tested as I went along, first I wrote the method for a function that adds the checker at the end of the zip code and then the method that converts said zip code base don the coding chart into ones and zeros. 

In the process, I cast a char as an int and though I got the correct checker, when I printed the values it was the wrong integer. I googles and found the method “Character.getNumericValue(c)” which I then tried. 

After this I worked backwards to covert from barcode to zip code and tested out. 

I then got stuck because I realized the test class did not call the methods it needed to in order to perform conversions. 

I decided after some research to put in the methods into the constructor, the methods that get called now depend on what input the user gives… 

Finally, I created soft stops if user entered wrong information. 
