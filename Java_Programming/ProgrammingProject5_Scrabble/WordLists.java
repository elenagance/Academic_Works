import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//*************************************
//
//WordLists.java
//
//Class to aid with Scrabble
//Programming Project 5, COMS W1004
//
//
//Your Name: Elena Gladoun
//Your Uni: eg2850
//**************************************


public class WordLists{

	ArrayList<String> words; 
	
    public WordLists(String fileName){
    	int x = 1; 
    	do{
			try{
				//create array list of words from dictionary file
				File inFile = new File(fileName); 
				Scanner input = new Scanner(inFile); 
				String word;
			    words = new ArrayList<String>(); 
			    x=2; 
				while(input.hasNext()){
					word = input.nextLine(); 
					words.add(word);
				}
			}	
			catch(IOException e){
				System.out.println("Please try again with a correct file name");
				System.out.println("Please enter a file name:");
				Scanner tryAgain= new Scanner(System.in); 
				fileName = tryAgain.nextLine(); 
			}
			catch(Exception e){
				System.out.println("Something went wrong, please try again"); 
			}
    	}
    	while(x==1);

    }


    public String[] lengthN(int n){
    	
		ArrayList<String> answer = new ArrayList<String>(); 

		for(int i=0; i<words.size(); i++){
			String currentWord = words.get(i); 
			int length = currentWord.length(); 
			if(length==n){
				answer.add(currentWord); 
			}
		}
		String [] answerWords = answer.toArray(new String[answer.size()]);
		return answerWords;    
    }


    public String[] startsWith(int n, char firstLetter){
		ArrayList<String> answer = new ArrayList<String>(); 
		firstLetter = Character.toLowerCase(firstLetter); 
		for(int i=0; i<words.size(); i++){
			String currentWord = words.get(i); 
			int length = currentWord.length(); 
			char currChar = currentWord.charAt(0); 
			if(length==n && firstLetter==currChar){
				answer.add(currentWord); 
			}
		}
		String [] answerWords = answer.toArray(new String[answer.size()]);
		return answerWords;    
    }


    public String[] containsLetter(int n, char included){
    	
		ArrayList<String> answer = new ArrayList<String>(); 
		included = Character.toLowerCase(included); 
		
		for(int i=0; i<words.size(); i++){
			String currentWord = words.get(i); 
			int length = currentWord.length(); 
			if(length==n){
				for(int k=1; k<length; k++){
					char currChar = currentWord.charAt(k);
					if(currChar==included){
						answer.add(currentWord); 
						k=length; 
					}
				}
			}
		}
		String [] answerWords = answer.toArray(new String[answer.size()]);
		return answerWords;    

    }
    
    public boolean isVowel(Character ch){
    	//create string of vowels
    	String vowel = "aeiou"; 
    	//return true if ch is a vowel
    	if(vowel.indexOf(ch)!=-1){
    		return true;
    	}
    	//otherwise return false
    	else{
    		return false; 
    	}
    }

    public String[] vowelHeavy(int n, int m){

		ArrayList<String> answer = new ArrayList<String>(); 
		
		for(int i=0; i<words.size(); i++){
			String currentWord = words.get(i); 
			int length = currentWord.length(); 
			if(length==n){
				int vowelCount=0;
				for(int k=0; k<currentWord.length(); k++){
					char currChar = currentWord.charAt(k); 
					if(isVowel(currChar)==true){
						vowelCount++; 
					}				
					if(k==currentWord.length()-1 && vowelCount==m){
						answer.add(currentWord); 
						vowelCount=0;
					}
				}
			}
		}
		String [] answerWords = answer.toArray(new String[answer.size()]);
		return answerWords;      
    }


    public String[] multiLetter(int m, char included){
    	
    	ArrayList<String> answer = new ArrayList<String>(); 
		included = Character.toLowerCase(included); 
		for(int i=0; i<words.size(); i++){
			String currentWord = words.get(i); 
			int count = 0; 
			for(int k= 0; k<currentWord.length(); k++){
				char currChar = currentWord.charAt(k); 
				if(currChar==included){
					count ++; 
				}
				if(k==currentWord.length()-1 && count==m){
					answer.add(currentWord); 
				}
			}

		}
		String [] answerWords = answer.toArray(new String[answer.size()]);
		return answerWords;    
    }
    


} // end of class





