//****************************
//Elena Gladoun
//eg2850
//Programming Project 3: 
//Ch.8.1: ComboLock
//Spring2016
//*****************************


public class ComboLock {

	private int combo1;
	private int combo2;
	private int combo3;
	private int dial; 

	//users attempts
	private int counter;
	private int Right;
	private int Left;
	private int Right2;

	public ComboLock(int secret1, int secret2, int secret3){
		this.combo1=secret1; 
		this.combo2=secret2;
		this.combo3=secret3; 
		this.dial=0; 
		
		this.counter=0; 
		this.Right=0;
		this.Left=0;
		this.Right2=0;
	}

	//method resets all values 
	public void reset(){
		dial=0; 
		counter=0; 
		Right=0;
		Left=0;
		Right2=0; 
	}
	
	//turns dial by a given number to the left
	public void turnLeft(int ticks){
		if(ticks>40){
			System.out.println("Sorry, that was an invalid entry");
		}
		else if(counter==1&&ticks<=40){
			Left=dial+ticks;
			dial=Left;
			if(Left>39){
				int diff= Left-39;
				dial = diff;
				Left= diff;
			}
			counter = 2; 
		}
	}

	
	public void turnRight(int ticks){
		//at first user turns the dial to the right
		if(ticks>=40){
			System.out.println("Sorry, that was an invalid entry");
		}
		else if(counter==0 && ticks<=40){
			//store first number
			Right=40-ticks;
			//set dial position to the number
			dial=Right; 
			//increment move
			counter=1; 
		}	
		//third turn to the right
		else if(counter==2 && ticks<=40){
			if(ticks>dial){
				int diff = ticks-dial; 
				dial = diff; 
				Right2 = dial; 
			}
			else{
				Right2=dial-ticks;
			}	
		}	
	}
	
	//attempts to open the lock
	public boolean open(){
		if(Right==combo1 && Left==combo2 && Right2==combo3){
			System.out.println("right: "+Right+" Left: " + 
				            Left+" right again: " + Right2);	
			return true;
		}
		else{
			System.out.println("Wrong Combination");
			return false; 
		}
	}
	
}
