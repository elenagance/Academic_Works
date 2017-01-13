//**************************
//Homework 2
//Problem 1 - MyStack class
//Elena V. Gladoun 
//eg2850
//**************************
import java.util.LinkedList; 

public class MyStack <AnyType> {

	private LinkedList<AnyType> any; 
	
	public MyStack(){
		any = new LinkedList<AnyType>(); 
	}
	//see size of stack
	public int size(){
		int sz = any.size();
		return sz; 
	}
	
	//check if stack is empty
	public boolean isEmpty(){
		return any.isEmpty(); 
	}
	
	//add things on top of the stack
	public void push(AnyType e){
		any.addFirst(e);
	}
	
	//remove from the top of a stack
	public AnyType pop(){
		AnyType a = any.removeFirst();
		return a; 
	}
	
	//look at the top of the stack 
	public AnyType peek(){
		//similar to the getFirst method in the linkedlist 
		AnyType a = any.getFirst();	
		return a;
	}
}
