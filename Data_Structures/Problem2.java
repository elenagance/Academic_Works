import java.io.File;
import java.io.FileNotFoundException;
/*
 * Homework3
 * Problem2
 * Elena V. Gladoun
 * eg2850
 */
import java.util.Scanner;

public class Problem2 {
static int idx; 
	
	public static void main(String[] args){
		
		//instantiate an AvlTree
		AvlTree<String> indexWord = new AvlTree<String>(); 
		
		File inFile = new File(args[0]); 
		idx=1; 
		try {
			Scanner input = new Scanner(inFile);
			
			while(input.hasNextLine()){		
				String line = input.nextLine();
				StringBuilder sb = new StringBuilder(); 
			
				//iterate over the line to get a word
				for(int i=0; i<line.length(); i++){
					char temp = line.charAt(i); 
					if(Character.isLetter(temp)){
						char n = Character.toLowerCase(temp); 
						sb.append(n); 				
					}
					
					//if reached the end of a word, char is going to be equal a space 
					//or it will be the end of the line
					if(temp==' '||i==line.length()-1){
						String word = sb.toString();
						
						//add word as a node on AVL tree - if it's not blank
						if(!(word.equals(""))){
							indexWord.insert(word, idx);
							indexWord.checkBalance();
							StringBuilder n = new StringBuilder(); 
							sb=n;	
						}
					}
				}
				idx++; 
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} 
		
		//print result
		indexWord.printTree(); 
		
  }
}
