//************************************
//
//Programming Project 2
//Elena Gladoun eg2850
//
//************************************


public class CreditCard {

    private String ccNumber;
    private boolean valid; 
    private int errorCode;
 
    //initializes the digits of the credit card number as separate ints 
    //to be accessible by check the methods

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private int sixth;
    private int seventh;
    private int eighth;
    private int ninth;
    private int tenth;
    private int eleventh;
    private int twelfth;   

    public CreditCard(String creditCardNumber){
    
	//accepts a String as input 
	//Note: this class assumes that the string input is formatted correctly. 

        ccNumber = creditCardNumber;    
	valid = true;
	errorCode = 0; 

        //digits of the credit card string are parsed  as ints below. 
	first = Integer.parseInt(ccNumber.substring(0,1)); 
        second = Integer.parseInt(ccNumber.substring(1,2));
        third = Integer.parseInt(ccNumber.substring(2,3));
        fourth = Integer.parseInt(ccNumber.substring(3,4));
        fifth = Integer.parseInt(ccNumber.substring(4,5));
        sixth = Integer.parseInt(ccNumber.substring(5,6));
        seventh = Integer.parseInt(ccNumber.substring(6,7));
 	eighth = Integer.parseInt(ccNumber.substring(7,8));
	ninth = Integer.parseInt(ccNumber.substring(8,9));
	tenth = Integer.parseInt(ccNumber.substring(9,10));
	eleventh = Integer.parseInt(ccNumber.substring(10,11));
	twelfth = Integer.parseInt(ccNumber.substring(11,12)); 
    }

    //The below methods check the card number according to six rules provided.
 
    //first digit must be a 4
    private void check1(){
	if(first!=4){
            valid = false;
            errorCode = 1; 
        }
    }
    
    //fourth digit must be greater than fifth
    private void check2(){
         if(fourth<=fifth){
             valid = false;
             if(errorCode==0){
                errorCode = 2;
	     } 
         }
    }

    //The product of the first, fifth, and ninth = 24
    private void check3(){
         if(first*fifth*ninth!=24){
             valid = false;
             if(errorCode==0){
                errorCode = 3;
             }
         }         
    }

    //sum of all the digits must be divisible by 4
    private void check4(){
         int sum = first+second+third+fourth+fifth+sixth+seventh+eighth+ninth+tenth+eleventh+twelfth;
         if(sum%4!=0){                                       
             valid = false;
             if(errorCode==0){
                errorCode = 4;
             }
         }
    }

    //sum of the first four digits must be 1 less than the sum of last four digits. 
    private void check5(){
	 int sumFirst= first+second+third+fourth;
         int sumLast= ninth+tenth+eleventh+twelfth;
         if(sumLast-sumFirst!=1){                                       
             valid = false;
             if(errorCode==0){
                errorCode = 5;
	     }
         }
    }

    //if first two digits are a 2 digit number and seventh and eighth are also a number, their sum must be 100. 
    private void check6(){
         int firstTwo = Integer.parseInt(ccNumber.substring(0,2));
	 int seventhEighth = Integer.parseInt(ccNumber.substring(6,8));
         if(firstTwo+seventhEighth!=100){                                       
             valid = false;
             if(errorCode==0){
                errorCode = 6;
	     }
         }
    }

    //this method calls the above private methods to check if the number is valid
    public void check(){
         check1();
	 check2();
         check3();
         check4();
         check5();
         check6();
    } 
    
    //returns the IV valid after the checks
    public boolean isValid(){
        return valid;
    }

    //returns the first error code that was triggered while going through the checks. 
    public int getErrorCode(){
	return errorCode;
    }

}
