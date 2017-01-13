//**************************************************
//
// Big Java Early Objects, 5th Edition 
// Programming Exercisde 4.2
// By Elena Gladoun
//
//************************************************** 
//Easter Sunday is the first Sunday after the first full moon of spring. 
//To compute the date, you can use this algorithm, invented by the 
//mathematician Carl Friedrich Gauss in 1800 

//Write a program that prompts the user for a year and prints out the 
// month and day of Easter Sunday

import java.util.Scanner;

public class EasterSunday
{
    public static void main(String[] args)
    {

    // Let y be the year (such as 1800 or 2001)- get the info from user
        Scanner userYear = new Scanner(System.in);
	System.out.println("Please enter the year in XXXX format"); 
	int y = userYear.nextInt();

	// Divide y by 19 and call the remainder a. Ignore the quotient.
	int a = y%19;

	// Divide y by 100 to get a quotient b and a remainder c
	int b = y/100;
	int c = y%100;

	// Divide b by 4 to get a quotient d and a remainder e
	int d = b/4;
	int e = b%4;

	// Divide 8 * b + 13 by 25 to get a quotient g. Ignore the remainder. 
	int g = (8*b+13)/25;
	
	// Divide 19 * a + b - d - g + 15 by 30 to get a remainder h.Ignore the quotient
	int h = (19*a+b-d-g+15)%30;

	// Divide c by 4 to get a quotient j and a remainder k
	int j = c/4;
	int k = c%4;

	// Divide a + 11 * h by 319 to get a quotient m. Ignore the remainder. 
	int m = (a+11*h)/319;	

	// Divide 2 * e + 2 * j - k - h + m + 32 by 7 to get a remainder r. Ignore the quotient
	int r = (2*e+2*j-k-h+m+32)%7;

	// Divide h - m + r + 90 by 25 to get a quotient n. Ignore the remainder. 
	int n = (h-m+r+90)/25;

	// Divide h - m + r + n+19 by 32 to get a remainder p. Ignore the quotient. 
	int p = (h-m+r+n+19)%32;

	//then Easter falls on day p of month n. 

	//Print results 
	
	if(n==1)
	System.out.println("In " + y + ",Easter Sunday fell on January " + 
			    p);
	if(n==2)
        System.out.println("In " + y + ",Easter Sunday fell on February " 
                           + p);
	if(n==3)
        System.out.println("In " + y + ",Easter Sunday fell on March " +
                            p);  
	if(n==4)
        System.out.println("In " + y + ",Easter Sunday fell on April " +
                            p);
	if(n==5)
        System.out.println("In " + y + ",Easter Sunday fell on May " +
                            p);
	if(n==6)
        System.out.println("In " + y + ",Easter Sunday fell on June " +
                            p);
	if(n==7)
        System.out.println("In " + y + ",Easter Sunday fell on July  " +
                            p);
	if(n==8)
        System.out.println("In " + y + ",Easter Sunday fell on August " +
                            p);
	if(n==9)
        System.out.println("In " + y + ",Easter Sunday fell on September " 
			   + p);
	if(n==10)
        System.out.println("In " + y + ",Easter Sunday fell on October " +
                            p);
	if(n==11)
        System.out.println("In " + y + ",Easter Sunday fell on November " 
		            + p);
	if(n==12)
        System.out.println("In " + y + ",Easter Sunday fell on December " 
			    + p);

	}//close main method

}//close class
