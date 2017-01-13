import java.util.Scanner;

/*
 * Homework3
 * Problem1: Tester Class
 * Elena V. Gladoun
 * eg2850
 */

public class Problem1 {
	
	public static void main(String[] args){
		//ask user for post-fix expression
		Scanner input = new Scanner(System.in); 
		System.out.println("Please enter a post-fix expression");
		System.out.println("(note: separate inputs with spaces)");
		String expression = input.nextLine(); 
		ExpressionTree expTree = new ExpressionTree(expression); 
		
		//demonstrate methods
		
		//evaluate expression
		int result = expTree.eval(); 
		System.out.println("Evaluation of expression:" + result); 
		
		
		//print the postfix expression
		String postfix = expTree.postfix(); 
		System.out.println("The postfix expression is: " + postfix); 
		
		
		//print the prefix expression
		String prefix = expTree.prefix(); 
		System.out.println("The prefix expression is: " + prefix); 
		
		
		//print the infix expression
		String infix = expTree.infix(); 
		System.out.println("The infix expression is: " + infix); 
		
	}

}
