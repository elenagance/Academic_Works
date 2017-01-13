//eg2850
//Programming Project 4
//Spring 2016
//readMe

As mentioned in class, we were to have the card class and deck class completed over the weekend, and to test we needed to comment out the compare to method. The card class was pretty straight forward to create. After completing that, I moved on to the deck class and created the deck of cards. Now I was tasked with shuffling the deck. As mentioned in class, we could use either math.random, or a shuffle method as java already has shuffle classes. I opted for the latter. 

After doing a google search I came across the Fisher-Yates shuffle which did not seem appealing as it was referenced to be prone to errors. I did however find another interesting approach - to generate an array of random numbers (same length as the deck of cards) and then sort the arrays together.  

Initially, I worked the logic out by hand to better conceptualize this process. For example, obviously I have to make sure the list of random numbers do not repeat numbers was they might with just a Math.Random() function. So when a number gets generated, I have to check if there are no duplicates already in the array. This is reminiscent of the last problem set we did, so I could combine my knowledge of checking for any duplicates like that. To make sure there were no duplicates, I added a boolean method that checks an array for the same value. 

After messing around with this lengthy code, I decided to go simpler - I loop through the array of cards 52 times and just use a simple swapping code to replace cards at random. 

After implementing a simple Tester I wrote, the program successfully dealt random cards. 

It took me a long time to debug the process of dealing a hand out to the player and having the player choose which cards to remove. 

After this, I looked at the Array Methods file from our last problem set for guidance as to how to test the hand for matches. 

Using the hints from class: that we should write the methods from lowest rank checks to highest and then have java check hand from the highest ranking method to lowest, I programmed the methods. When I ran the test hands, all of the matches were successful except for four of a kind, full house, and three of a kind. I also realized I needed to go back into straight because an ace can technically be a 14 or a 1…

After this, I ran my program on cunix and tested every single hand several times. I stopped editing the code once satisfied with the successful outcomes. 


