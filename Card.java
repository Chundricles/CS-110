/*Neil Carey
  CS 110
  Assignment 5 Q3
  Accepts rank and suit as constructors
  
  Card(int rank,int suit)
  
  rank 2-10, Jack = 11, Queen = 12, King = 13, Ace = 14
  suit 0=Hearts, 1 = Clubs, 2 = Spades, 3 = Diamonds */

import javax.swing.*;

public class Card {

public String ranking[] = new String[]{"TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING","ACE"};
public int rank;   //initialize variables, set string arrays with names of all suits
public ImageIcon front,back;

public Card(int num,String faceFilename, String backFilename){     //initialize variables , so that strings can be accessed easily
rank = num;
front = new ImageIcon(faceFilename);
back = new ImageIcon(backFilename);
}

public int getRank(){      //returns proper rank,re-adjusted 
return rank+1;}

public String getString(){ //returns a string of the rank and suit
String rAndS = ranking[rank-1];
return rAndS;
} 

public boolean equals(Card c){   //checks to see if the card is equal to another
   if (c.getRank() == this.getRank()) return true; 
   else return false;
}

public ImageIcon getFront(){
return front;
}

public ImageIcon getBack(){
return back;
}

}