import java.util.Scanner; 
import java.util.ArrayList;


public class Game {
	
	private Player p;
	private Deck cards;
	private String[] tester; 
	// you'll probably need some more here

	
	public Game(String[] testHand){
		// This constructor is to help test your code
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
		//take in the string array
		tester = testHand; 
		this.p = new Player(); 

		int suit = 0; 
		int value = 0;
		//loop through the string array 
		for(int i=0; i<tester.length; i++){
			String cardWIP = tester[i]; 
			char st = cardWIP.charAt(0);
			String cardNum= cardWIP.substring(1, cardWIP.length()); 
			//assign suit
			//if clubs
			if(st=='c'){
				suit = 1; 
			}
			//if diamonds
			if(st=='d'){
				suit = 2; 
			}
			//if hearts
			if(st=='h'){
				suit = 3; 
			}
			//if spades
			if(st=='s'){
				suit = 4; 
			}
			//assign value
			value = Integer.parseInt(cardNum); 
			//add card to player's hand
			Card toAdd = new Card(suit, value); 
			p.addCard(toAdd); 	
		}
		
			p.sortHand(); 
			p.printHand();
		
	}
	
	public Game(){
		// This constructor is to actually play a normal game
		this.p = new Player(); 
		this.cards = new Deck(); 
		
		System.out.println("Welcome to Poker"); 
		
		//shuffle deck
		shuffle(); 
		
		//deal hand
		dealHand();
		
		//sort hand
		p.sortHand(); 
		
		//player views hand
		System.out.println("your hand is:");	
		p.printHand();
		
		//ask player if they want to change their hand		
		handConstruct(); 
	}
	
	public void play(){
		// this method should play the game	
		//checks hand for matches
		
		ArrayList<Card> hand = p.getHand(); 
		
		String resolution = checkHand(hand); 
		
		//prints result
		System.out.println(resolution); 
		
		//asks the player if they want to play again
		System.out.println("Play again? 1 = yes, 2 = no");
			Scanner pa = new Scanner(System.in);
			int again = pa.nextInt(); 
			if(again==1){
				Game another = new Game(); 
				another.play(); 
			}
			if(again!=1){
				System.out.println("Thanks for playing");
		}
		

	}	
	
	public void shuffle(){
		//shuffles the deck a couple of times
		cards.shuffle(); 
		cards.shuffle(); 
		cards.shuffle(); 
		cards.shuffle(); 
		cards.shuffle();
		cards.shuffle(); 
		cards.shuffle(); 
		cards.shuffle(); 
		cards.shuffle(); 
		cards.shuffle(); 
		System.out.println("Deck is shuffled");
	}
		
	public void dealHand(){
		//deal five cards into players hand
		p.addCard(cards.deal());
		p.addCard(cards.deal());
		p.addCard(cards.deal());
		p.addCard(cards.deal());
		p.addCard(cards.deal());
		System.out.println("Hand is dealt");
	}
	
	public void handConstruct(){
		 
		System.out.println("Would you like to change your hand? (1-yes 2-no)"); 
		Scanner ans = new Scanner(System.in); 
		int change = ans.nextInt(); 
		
		if(change == 1){
			System.out.println("some=1, or all=2 of your cards?");
			Scanner in = new Scanner(System.in);	
			int answer =  in.nextInt();
			
			//if some of the cards:
			if(answer==1){
				System.out.println("how many cards do you wish to replace?");
				Scanner input = new Scanner(System.in); 
				int num = input.nextInt(); 		
				for(int i = 0; i<num; i++){
					
					System.out.println("Which card do you wish to replace?");
					System.out.println("enter the suit:");
					System.out.println("1-clubs, 2-diamonds");
					System.out.println("3-hearts, 4-spades"); 
					
					Scanner st = new Scanner(System.in);
					int suite = st.nextInt(); 
					
					System.out.println("enter value");
					Scanner numb= new Scanner(System.in); 
					int value = numb.nextInt(); 	
					
					Card tbd = new Card(suite, value); 
 
					p.removeCard(tbd); 
				}
				
				for(int k = num; k>0; k--){
					p.addCard(cards.deal()); 
				}
				
			}
			//rejects all cards 
			if(answer==2){
				//clears the hand
				p.clearHand(); 
				//deals five new cards into the array 
				dealHand(); 
			}
		
			//view new hand
			System.out.println("Your new hand is: ");
			//sort hand
			p.sortHand(); 
			p.printHand();
		}
		else{
			System.out.println("Thank You");
		}
		
	}

	

	 
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		String result=""; 
		hand = p.getHand(); 
		
		//royal flush
		boolean rFlush = royalFlush(hand);
		if(rFlush == true){
			result = "Royal Flush! Congratulations"; 
			return result; 
		}
		
		//straight flush 
		boolean sFlush = straightFlush(hand);
		if(sFlush == true){
			result = "Straight Flush! Congratulations"; 
			return result; 
		}
		
		//four of a kind
		boolean fK = fourOfAKind(hand); 
		if(fK==true){
			result = "Four of a Kind!";
			return result; 
		}
		
		//full house
		boolean fh = fullHouse(hand); 
		if(fh==true){
			result = "Full house!"; 
			return result; 
		}
		
		//flush 
		boolean fl = flush(hand); 
		if(fl==true){
			result = "Flush!"; 
			return result; 
		}
		
		//straight
		boolean st = straight(hand); 
		if(st==true){
			result = "Straight!"; 
			return result; 
		}
		
		//three of a kind
		boolean tok = threeOfAKind(hand); 
		if(tok==true){
			result = "Three of a kind!"; 
			return result; 
		}
		//two pair
		boolean tp = twoPair(hand); 
		if(tp==true){
			result = "Two Pair!"; 
			return result; 
		}
		//pair
		boolean p = pair(hand); 
		if(p==true){
			result = "pair!"; 
			return result; 
		}
		else{
			result ="No pair. Sorry, better luck next time"; 
			return result; 
		}
	
	}
	
	
	// you will likely want many more methods here
	// see discussion in class
	
	//smaller methods for checking hand by descending rank
	public boolean royalFlush(ArrayList<Card> hand){
		boolean check = false; 
		if(flush(hand)==true){
			//values have to be 10, 11, 12, 13, 1(ace)
			int count = 0; 
			for(int i=0; i<hand.size(); i++){
				Card curr = hand.get(i); 
				int val = curr.getValue(); 
				if(val==1||val==10||val==11||val==12||val==13){
					count++; 
				}
			}
			if(count==5){
				check = true; 
			}
		}
		return check; 
	}
	
	public boolean straightFlush(ArrayList<Card> hand){
		boolean check = false; 
		
		if(straight(hand)==true && flush(hand)==true){
			check = true; 
		}
		
		return check; 
	}
	
	public boolean fourOfAKind(ArrayList<Card> hand){
		boolean check = false; 
		int count = 0;
		for(int i = 0; i<hand.size(); i++){
			Card currCard = hand.get(i); 
			int value = currCard.getValue(); 
			
			for(int k = i+1; k<hand.size(); k++){
				Card otherCard = hand.get(k); 
				int otherValue = otherCard.getValue(); 
				if(value==otherValue){
					count++; 
					
				}
			}	
		}
		if(count==6){
			check = true; 
		}
		return check; 	
	}
	
	public boolean fullHouse(ArrayList<Card> hand){
		boolean check = false; 
		int count = 0;
		for(int i = 0; i<hand.size(); i++){
			Card currCard = hand.get(i); 
			int value = currCard.getValue(); 
			
			for(int k = i+1; k<hand.size(); k++){
				Card otherCard = hand.get(k); 
				int otherValue = otherCard.getValue(); 
				if(value==otherValue){
					count++; 
				}
			}	
		}
		
		if(count==4){
			check = true; 
		}
		return check;
	}
	
	public boolean flush(ArrayList<Card> hand){
		boolean check = false; 
		
		Card first = hand.get(0); 
		int st = first.getSuit(); 
		int count = 0; 
		
		for(int i=1; i<hand.size(); i++){
			Card other = hand.get(i); 
			int otherSt = other.getSuit(); 
			if(st == otherSt){
				count++; 
			}
		}
		if(count==4){
			check = true; 
		}
		return check; 
	}
	
	public boolean straight(ArrayList<Card> hand){
		//five cards in a sequence but not of the same suit
		boolean check = false;
		boolean ace = false; 

		Card first = hand.get(0); 
		int val = first.getValue();
		
		if (val==1){
			ace = true; 
		}
		
		int count = 0; 
		
		for(int i = 1; i<hand.size(); i++){
			Card other = hand.get(i);
			int otherVal = other.getValue(); 
			if(otherVal-1 == val){
				count++; 
				val = otherVal; 
			}
		}
		if (count == 4){
			check = true; 
		}
		
		//but ace could be considered value 14.
		//check when ace =14
		if(ace==true && check==false){
			val = 9; 
			count = 0; 
			
			for(int i = 1; i<hand.size(); i++){
				Card other = hand.get(i);
				int otherVal = other.getValue(); 
				if(otherVal-1 == val){
					count++; 
					val = otherVal; 
				}
			}
			if (count == 4){
				check = true; 
			}
			
		}

		return check; 
	}
	
	public boolean threeOfAKind(ArrayList<Card> hand){
		boolean check = false; 
		int count = 0; 
		for(int i = 0; i<hand.size(); i++){
			Card currCard = hand.get(i); 
			int value = currCard.getValue(); 
			
			for(int k = i+1; k<hand.size(); k++){
				Card otherCard = hand.get(k); 
				int otherValue = otherCard.getValue(); 
				if(value==otherValue){
					count++; 
				}
			}	
		}
		
		if(count==3){
			check = true; 			
		}

		return check; 	
	}
	
	public boolean twoPair(ArrayList<Card> hand){
		boolean check = false; 
		int count = 0; 
		for(int i = 0; i<hand.size(); i++){
			Card currCard = hand.get(i); 
			int value = currCard.getValue(); 
			
			for(int k = i+1; k<hand.size(); k++){
				Card otherCard = hand.get(k); 
				int otherValue = otherCard.getValue(); 
				if(value==otherValue){
					count++; 
				}
			}	
		}
		if(count==2){
			check = true; 
		}
		return check; 
	}
	
	public boolean pair(ArrayList<Card> hand){
		boolean check = false; 
		int count = 0; 
		
		for(int i = 0; i<hand.size(); i++){
			Card currCard = hand.get(i); 
			int value = currCard.getValue(); 
			
			for(int k = i+1; k<hand.size(); k++){
				Card otherCard = hand.get(k);
				if(count>1){
					return check; 
				} 
				int otherValue = otherCard.getValue(); 
				if(value==otherValue){
					count++; 	
				}
			}	
		}
		
		if(count==1){
			check=true; 
		}
		return check; 
	}
	
	
}


