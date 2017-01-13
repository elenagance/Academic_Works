import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	// you will likely need more instance variables
		
	public Player(){		
		// create a player here
		this.hand = new ArrayList<Card>(); 
		
	}

	public void addCard(Card c){
		// add the card c to the player's hand
		hand.add(c); 
		System.out.println("Card added" + c); 
	}

	public void removeCard(Card c){
		// remove the card c from the player's hand
		int index=0; 
		for(int i=0; i<hand.size(); i++){			
			Card curr = hand.get(i); 
			int ans = c.compareTo(curr);
			if(ans==0){
				index=i; 
			}
		}
		hand.remove(index); 
		System.out.println("card removed: " + c);
		System.out.println("from index: " + index);
	}
		
	// you will likely need more methods here
	public ArrayList<Card> getHand(){
		return hand; 
	}
	
	public void printHand(){
		//prints cards in hand
		for(int i=0; i<hand.size(); i++){
			System.out.print(hand.get(i) + " "); 
			System.out.println(""); 
		}
	}
	
	public void clearHand(){
		hand.clear(); 
	}
	
	public void sortHand() { 
		Collections.sort(hand); 
	}
	
}
