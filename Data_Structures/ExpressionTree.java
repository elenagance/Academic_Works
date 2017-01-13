/*
 * Homework3
 * Problem1: Expression Tree Class
 * Elena V. Gladoun
 * eg2850
 */

public class ExpressionTree {

	//instance variable 
	ExprNode root; 
	
	//constructor takes in a String that contains a postfix expression 
	public ExpressionTree(String postfix){
		
		//take in the string and separate into tokens 
		String[] tokens = postfix.split(" "); 
		MyStack<ExprNode> stack = new MyStack<ExprNode>(); 
		
		//iterate over the array
		for(int i=0; i<tokens.length; i++){
			//see if token is an operator 
			boolean isNum= isNumber(tokens[i]); 
			
			//if operand, push onto the stack
			if(isNum==true){
				int digit=0; 
				try{
					digit= Integer.parseInt(tokens[i]); 
				}catch(Exception e){
					System.out.println("That was an incorrect input");
					System.exit(digit); 
				}
			
				ExprNode temp = new ExprNode(digit); 
				stack.push(temp);
			}
			
			//if operator, pop the last two off the stack 
			else{
				char function = tokens[i].charAt(0); 
				ExprNode temp = new ExprNode(function);
				
				//pop stack, this is the right child
				temp.right=stack.pop(); 
				
				//pop stack again, this is the left child
				temp.left=stack.pop();
				
				//push result back onto stack 
				stack.push(temp); 
				root = temp; 
			}
			
			
		}
		
	}
	
	
	
	/*
	 *------------------------------------------------------------------------------------
	 *Public Methods:
	 *----------------
	 *eval() : returns an integer value associated with evaluating the expression tree.  
	 *postfix(): returns the postfix expression
	 *prefix(): returns the prefix expression
	 *infix(): returns the correct infix expression
	 *------------------------------------------------------------------------------------
	 */
	
	
	public int eval(){
		int result = eval(root); 
		return result; 
	}
	
	
	public String postfix(){
		String postfixExpr=postfix(root); 
		return postfixExpr; 
	}
	
	public String prefix(){
		String preExpr=prefix(root);  
		return preExpr; 
	}
	
	public String infix(){
		String infixExpr=infix(root);  
		return infixExpr;  
	}
	
	
	
	/*
	 *------------------------------------------------------------------------------------
	 *Private Classes/Methods:
	 *----------------
	 *ExprNode class: Expression node 
	 *isNumber: returns if the string has a number or operator
	 *eval(root) : returns an int value associated with evaluating the expression tree.  
	 *postfix(root): returns the postfix expression
	 *prefix(root): returns the prefix expression
	 *infix(root): returns the correct infix expression
	 *------------------------------------------------------------------------------------
	 */
	
	//evaluates if token is a number or operator 
	private boolean isNumber(String x){
		boolean result = true; 
		char temp = x.charAt(0); 
		if(temp=='+' || temp=='-' || temp =='*' || temp=='/'){
			result=false; 
		}
		return result; 
	}
	
	//recursive method to evaluate expression
	private int eval(ExprNode r){ 
		//evaluate current node 
		if(!r.isOperator){
			return r.operand; 
		}
		//evaluate left side 
		int left=eval(r.left); 
		//evaluate right child
		int right=eval(r.right);
		
		if(r.operator=='-'){
			return left-right; 	
		}
		
		if(r.operator=='+'){
			return left+right; 	
		}
		
		if(r.operator=='*'){
			return left*right; 	
		}
		
		if(r.operator=='/'){
			return left/right; 	
		}
		//if there it is an empty expression tree. 
		return 0; 
	}
	
	//recursive method to print postfix
	private String postfix(ExprNode r){
		
		if(r.isOperator){
			StringBuilder sb = new StringBuilder();
			sb.append(postfix(r.left));
			sb.append(postfix(r.right));
			sb.append(r.operator);
			sb.append(' ');
			return sb.toString();
		}
		if(!r.isOperator){
			StringBuilder sb = new StringBuilder();
			sb.append(r.operand);
			sb.append(' '); 
			return sb.toString(); 
		}
		
		//in case there was an error in the expression tree
		String invalid = "oops, something went wrong";
		return invalid;
	}
	
	//recursive method to print prefix
	private String prefix(ExprNode r){
		if(r.isOperator){
			StringBuilder sb = new StringBuilder();
			sb.append(r.operator);
			sb.append(' ');
			sb.append(prefix(r.left));
			sb.append(prefix(r.right));

			return sb.toString();
		}
		if(!r.isOperator){
			StringBuilder sb = new StringBuilder();
			sb.append(r.operand);
			sb.append(' '); 
			return sb.toString(); 
		}
		
		//in case there was an error in the expression tree
		String invalid = "oops, something went wrong";
		return invalid;
	}
	
	
	
	//recursive method to print infix
	private String infix(ExprNode r){
		//string= left, node, right
		if(r.isOperator){
			StringBuilder sb = new StringBuilder();
			sb.append('(');
			sb.append(infix(r.left));
			sb.append(r.operator);
			sb.append(' ');
			sb.append(infix(r.right));
			sb.append(')');

			return sb.toString();
		}
		if(!r.isOperator){
			StringBuilder sb = new StringBuilder();
			sb.append(r.operand);
			sb.append(' '); 
			return sb.toString(); 
		}
		
		//in case there was an error in the expression tree
		String invalid = "oops, something went wrong";
		return invalid;
	}
	
	
	
	//private expression tree node class
	
	private static class ExprNode{
		
		int operand; 
		char operator; 
		boolean isOperator; 
		
		ExprNode left; 
		ExprNode right; 
		
		public ExprNode(char c){
			this(c, null, null); 
		}

		public ExprNode(int i){
			this(i, null, null); 
		}
		
		private ExprNode(int number, ExprNode lt, ExprNode rt) {
			operand=number; 
			isOperator=false; 
			left = lt; 
			right = rt; 
		}
		
		private ExprNode(char op, ExprNode lt, ExprNode rt) {
			operator = op; 
			isOperator=true; 
			left=lt;
			right=rt;
		}
	}
}
