//***********************************************
//
// Big Java, Early Objects, 5th Edition 
// Exercise 4.8 Giving Change
// By Elena Gladoun
// February 2016
//
//***********************************************

//Implement a program that direcrs a cashier how to give change. 
//The program has two inputs: the amount due and the amount recieved from the customer
//Display the dollars, quarters, dimes, nickels, and pennies that the customer should recieve in return
//In order to avoid roundoff errors, the program user should supply both amounts in pennies. For example 246 instead of 2.74. 

import java.util.Scanner;

public class GivingChange{

    public static void main(String[] args){
        //first prompt the user for the amount due
	Scanner amountDue = new Scanner(System.in);
	System.out.println("Please enter the amount due (as xx.xx): ");
	double doubleDue = amountDue.nextDouble();
	doubleDue = doubleDue*100;
	int due = (int)doubleDue;
	

	//now prompt the user for the amount recieved by customer
	Scanner amountRec = new Scanner(System.in);
	System.out.println("Please enter the amount recieved:(as xx.xx) ");
	double doubleRec = amountRec.nextDouble();
	doubleRec = doubleRec*100;
	int rec = (int)doubleRec;
		

	//Now do calculations
	//get the difference 
	int diff = rec-due;
	

	int dollars = diff/100;
	int rem = diff%100;
	int quarters = rem/25;
	rem = rem%25;
	int dimes = rem/10;
	rem = rem%10;
	int nickels = rem/5;
	rem = rem%5;
	int pennies = rem;

	//Now print the result
	System.out.println("Your change is : ");
	System.out.println("Dollars: " + dollars +" "+ "Quarters: " + quarters +" "+ "Dimes: " + dimes 
			   + " "+ "Nickels: " + nickels +" " + "Pennies: "+ pennies);
	System.out.println("Thank you");


    }//end class


}//end method
