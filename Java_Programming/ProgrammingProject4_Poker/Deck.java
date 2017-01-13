
public class Deck {
	
	private Card[] theDeck;
	private int top; // the index of the top of the deck
	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		//clubs
		//Comparable[] theDeck = new Comparable[52]; 
		theDeck = new Card[52]; 
		//Comparable deck = theDeck; 
		theDeck[0] = new Card(1,1); //Ace of clubs
		theDeck[1] = new Card(1,2); //2 of clubs
		theDeck[2] = new Card(1,3); //3 of clubs
		theDeck[3] = new Card(1,4); //4 of clubs
		theDeck[4] = new Card(1,5); //5 of clubs
		theDeck[5] = new Card(1,6); //6 of clubs
		theDeck[6] = new Card(1,7); //7 of clubs
		theDeck[7] = new Card(1,8); //8 of clubs
		theDeck[8] = new Card(1,9); //9 of clubs
		theDeck[9] = new Card(1,10); //10 of clubs
		theDeck[10] = new Card(1,11); //Jack of clubs
		theDeck[11] = new Card(1,12); //Queen of clubs
		theDeck[12] = new Card(1,13); //King of clubs
		
		//diamonds
		theDeck[13] = new Card(2,1); //Ace of diamonds
		theDeck[14] = new Card(2,2); //2 of diamonds
		theDeck[15] = new Card(2,3); //3 of diamonds
		theDeck[16] = new Card(2,4); //4 of diamonds
		theDeck[17] = new Card(2,5); //5 of diamonds
		theDeck[18] = new Card(2,6); //6 of diamonds
		theDeck[19] = new Card(2,7); //7 of diamonds
		theDeck[20] = new Card(2,8); //8 of diamonds
		theDeck[21] = new Card(2,9); //9 of diamonds
		theDeck[22] = new Card(2,10); //10 of diamonds
		theDeck[23] = new Card(2,11); //Jack of diamonds
		theDeck[24] = new Card(2,12); //Queen of diamonds
		theDeck[25] = new Card(2,13); //King of diamonds
		
		//hearts
		theDeck[26] = new Card(3,1); //Ace of hearts
		theDeck[27] = new Card(3,2); //2 of hearts
		theDeck[28] = new Card(3,3); //3 of hearts
		theDeck[29] = new Card(3,4); //4 of hearts
		theDeck[30] = new Card(3,5); //5 of hearts
		theDeck[31] = new Card(3,6); //6 of hearts
		theDeck[32] = new Card(3,7); //7 of hearts
		theDeck[33] = new Card(3,8); //8 of hearts
		theDeck[34] = new Card(3,9); //9 of hearts
		theDeck[35] = new Card(3,10); //10 of hearts
		theDeck[36] = new Card(3,11); //Jack of hearts
		theDeck[37] = new Card(3,12); //Queen of hearts
		theDeck[38] = new Card(3,13); //King of hearts
		
		//spades
		theDeck[39] = new Card(4,1); //Ace of spades
		theDeck[40] = new Card(4,2); //2 of spades
		theDeck[41] = new Card(4,3); //3 of spades
		theDeck[42] = new Card(4,4); //4 of spades
		theDeck[43] = new Card(4,5); //5 of spades
		theDeck[44] = new Card(4,6); //6 of spades
		theDeck[45] = new Card(4,7); //7 of spades
		theDeck[46] = new Card(4,8); //8 of spades
		theDeck[47] = new Card(4,9); //9 of spades
		theDeck[48] = new Card(4,10); //10 of spades
		theDeck[49] = new Card(4,11); //Jack of spades
		theDeck[50] = new Card(4,12); //Queen of spades
		theDeck[51] = new Card(4,13); //King of spades	
		
		top = 51; 
	}
	
	public void shuffle(){
		// shuffle the deck here
		Card temp; 
		for(int i=0; i<theDeck.length; i++){
			int rand = (int)(Math.random()*51); 
			temp = theDeck[i]; 
			theDeck[i] = theDeck[rand];
			theDeck[rand] = temp;  
		}
	}
	
	public Card deal(){
		// deal the top card in the deck
		Card hand = theDeck[top]; 
		top--;
		return hand;  
	}
	
	// add more methods here if needed

}
