import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//*************************************
//
//Tests WordLists.java
//
//Class to test the aid with Scrabble
//Programming Project 5, COMS W1004
//
//
//Your Name: Elena Gladoun
//Your Uni: eg2850
//**************************************
public class ScrabbleTest {
	
private static int answer; 

	public static void main(String[] args){
		
		//asks which method user would like to run:
		int x=1; 
		do{		
			try{
				Scanner question = new Scanner(System.in);
				System.out.println("What would you like to do?");
				System.out.println("enter 1 to find words of a certain length");
				System.out.println("2 to find words of a certain length beginning "
									+ "with a specific letter");
				System.out.println("3 to find words of a certain length containing "
									+ "a speciffic letter");
				System.out.println("4 to find words of a certain length containing"
									+ "a certain number of vowels");
				System.out.println("5 to find words with a certain number of occurences "
									+ "of a specific letter");
				answer = question.nextInt(); 
				x=2; 
			}
			
			catch (Exception e){
				System.out.println("That was an incorrect input. "
									+ "Please try again"); 
			}
			
		}
		while(x==1);

		//asks for file name -- if there is an error WordLists will catch it 
		Scanner input = new Scanner(System.in); 
		System.out.println("Please enter the file name for the dictionary:");
		String inputFilename = input.nextLine();
		WordLists wl = new WordLists(inputFilename); 
		
		
		//returns array of words of length n		
		if(answer==1){
			int a = 1; 
			do{
				try{
					Scanner wordLength = new Scanner(System.in);
					System.out.println("Please enter the desired word length");
					int n = wordLength.nextInt(); 
					String[] answerWords = wl.lengthN(n); 
					saveFile(answerWords);
					a=2; 
				}
				catch(Exception e){
					System.out.println("Something went wrong, try again");
				}
			}
			while(a==1);
		}
				
		//returns array of words of length n that starts with ch
		if(answer==2){
			int a=1; 
			do{
				try{
					Scanner wordLength = new Scanner(System.in);
					System.out.println("Please enter the desired word length");
					int n = wordLength.nextInt(); 
					Scanner chara= new Scanner(System.in);
					System.out.println("Please enter the desired first letter:");
					char ch = chara.next().charAt(0); 
					String[] answerWords = wl.startsWith(n, ch); 
					saveFile(answerWords);
					a=2; 
				}
				catch(Exception e){
					System.out.println("Something went wrong, try again");
				}
			}
			while(a==1);
		}
		
		
		//returns array of words of length n that has ch	
		if(answer==3){
			int a=1; 
			do{
				try{
					Scanner wordLength = new Scanner(System.in);
					System.out.println("Please enter the desired word length");
					int n = wordLength.nextInt(); 
					Scanner chara= new Scanner(System.in);
					System.out.println("Please enter the letter it should contain:");
					char ch = chara.next().charAt(0); 
					String[] answerWords = wl.containsLetter(n, ch); 
					saveFile(answerWords);
					a=2;
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try again");
				}
			}
			while(a==1);
		}
				
		
		//returns array of words of length n that has m vowels		
		if(answer==4){
			int a = 1; 
			do{
				try{	
					Scanner wordLength = new Scanner(System.in);
					System.out.println("Please enter the desired word length");
					int n = wordLength.nextInt(); 
					Scanner vowel= new Scanner(System.in);
					System.out.println("Please enter the number of vowels "
										+ "it should contain");
					int m = vowel.nextInt(); 
					String[] answerWords = wl.vowelHeavy(n, m); 
					saveFile(answerWords);
					a=2;
				}
				catch(Exception e){
					System.out.println("Something went wrong, Please try again");
				}
			}
			while(a==1);
		}
		
		
		//returns array of words of m occurrences of letter ch		
		if(answer==5){
			int a = 1; 
			do{
				try{
					Scanner numLetters = new Scanner(System.in);
					System.out.println("Please enter the number of times "
										+ "the letter should occur");
					int n = numLetters.nextInt(); 
					Scanner chara= new Scanner(System.in);
					System.out.println("Please enter the letter itself: ");
					char ch = chara.next().charAt(0); 
					String[] answerWords = wl.multiLetter(n, ch); 
					saveFile(answerWords);
					a=2;
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try again");
				}
			}
			while(a==1);
		} 
	}
	
	
	//method to save file
	public static void saveFile(String[] answerWords){
		
		Scanner in = new Scanner(System.in); 
		System.out.println("please enter the output file name "
							+ "to save your results to");
		String outFileName = in.nextLine(); 
		PrintWriter output;
		int a = 1; 
		do{
			try {
				output = new PrintWriter(outFileName);
				for(int i = 0; i<answerWords.length; i++){
					String entry = answerWords[i]; 
					output.println(entry);	
				}
				output.close(); 
				System.out.println("Your file has been saved");	
				a=2; 
			} 
			catch (FileNotFoundException e) {
				System.out.println("Something went wrong, please try again");
			}
		}
		while(a==1);
	}
		
}


