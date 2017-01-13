//readMe.txt// 
//Programming Project 2//
//Elena Gladoun eg2850//
//CeditCard class//

//how the program works://

There are a number of instance variables used. Namely, there is the String to store the credit card number, the boolean Valid that will return if the credit card number passed the checks, and the integer Error Code which will return the number of the first check that the credit card did not clear. I also stored the digits as instance variable ints, that way they are accessible by all the methods and the code looks cleaner, is easier to follow, and to read. Also, if there would be an error in one of the substrings, I could fix it by changing it only in one place. 

After initializing the variables, the checks, which all have their own separate method, activate to check the credit card number If any of the checks fail, Valid was changes to False, and the first error code, of the first test that is failed gets returned. The way this is done is by an if statement, if the errorCode is not 0, as it is originally set, then the value will be set to the current check that was failed. That way, if for example the number has failed number 1 but also number 2, 1 get’s returned as the errorCode was already set to 1 and is not zero. 

In the end, all the checks are run by a public method that the test class accesses. The remaining methods return the boolean value of True or False, and the error code value.  




//my process://
Started off tackling the problem by writing out the components and reviewing the phone number example from lecture. 

By following both, I came to the problem that re-writing the parse int for every single check was tedious, and if there was an error I would have to fix that in every place. So I went back to my constructor and added all of the digits there. It made the checks much easier to read which was a bonus. 

After I wrote out the code, I was having a lot of errors pop up because I wrote ‘ccNumber’ in as private instance variable of type ‘int’ so parse int was not working. Once I fixed it to a String, I was able to compile. 

For the errorCode, I decided to just nest an if statement in the checks, if the check’s if statement executed and valid was set to false. Then it checked if the errorCode int was 0, and if it was, it set the error code to the respective check. This way, only the first error would come through. 

After running the program with the numbers provided that are supposes to work, I kept getting error 3. I then caught that instead of taking the product, I was adding the numbers.

I tested the numbers with the valid examples and this time the program returned that the numbers were valid. I began to test with invalid ones of different codes. 