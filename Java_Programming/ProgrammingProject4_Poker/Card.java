
public class Card implements Comparable<Card>
{
	
	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1-13 to encode the value
	
	public Card(int s, int v){
		//make a card with suit s and value v
		suit = s;
		value = v; 
		
	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted
		
		//sort by value first
		int answer = 0;
		if (this.value<c.value){
			answer=-1;
		}
		if (this.value>c.value){
			answer=1; 
		}
		
		//if tie, resolve by suit
		if (this.value==c.value){
			if(this.suit<c.suit){
				answer =-1; 				
			}
			if(this.suit>c.suit){
				answer = 1; 
			}
		}
		return answer; 

	}
	
	public String toString(){
		// use this method to easily print a Card object
        String card = null; 
        //clubs
        if(suit==1){
        	card = "c" + Integer.toString(value);
        }
        //diamonds
        if(suit==2){
        	card = "d" + Integer.toString(value);
        }
        //hearts
        if(suit==3){
        	card = "h" + Integer.toString(value);
        }
        //spades
        if(suit==4){
        	card = "s" + Integer.toString(value);
        }
        return card; 
	}
	// add some more methods here if needed
	
	public int getSuit(){
		return suit; 
	}
	
	public int getValue(){
		return value; 
	}

}
