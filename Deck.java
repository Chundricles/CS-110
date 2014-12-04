/*  Neil Carey
CS  final hw
Deck class

Deck will load cards from given files
assuming files are saved to same place as deck

shuffle()  randomizes the cards
deal()  returns the first card object in the deck

requires Card class be loaded to computer

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deck {

ArrayList<Card> cards = new ArrayList<Card>();

public Deck(){

for(int i=2;i<=10;i++){
   Card card = new Card(i,Integer.toString(i)+"s.jpg","back.jpg");
   cards.add(card);   
   
   }
   
for(int i=2;i<=10;i++){
   Card card = new Card(i,Integer.toString(i)+"d.jpg","back.jpg");
   cards.add(card);   
   
   }
   
for(int i=2;i<=10;i++){
   Card card = new Card(i,Integer.toString(i)+"h.jpg","back.jpg");
   cards.add(card);   
   
   }

for(int i=2;i<=10;i++){
   Card card = new Card(i,Integer.toString(i)+"c.jpg","back.jpg");
   cards.add(card);   
   
   }   


Card card = new Card(11,"jacks.jpg","back.jpg");
cards.add(card);
card = new Card(11,"jackd.jpg","back.jpg");
cards.add(card);
card = new Card(11,"jackh.jpg","back.jpg");
cards.add(card);
card = new Card(11,"jackc.jpg","back.jpg");
cards.add(card);
   
card = new Card(12,"queens.jpg","back.jpg");
cards.add(card);
card = new Card(12,"queend.jpg","back.jpg");
cards.add(card);
card = new Card(12,"queenh.jpg","back.jpg");
cards.add(card);
card = new Card(12,"queenc.jpg","back.jpg");
cards.add(card);

card = new Card(13,"kings.jpg","back.jpg");
cards.add(card);
card = new Card(13,"kingd.jpg","back.jpg");
cards.add(card);
card = new Card(13,"kingh.jpg","back.jpg");
cards.add(card);
card = new Card(13,"kingc.jpg","back.jpg");
cards.add(card);

card = new Card(14,"aces.jpg","back.jpg");
cards.add(card);
card = new Card(14,"aced.jpg","back.jpg");
cards.add(card);
card = new Card(14,"aceh.jpg","back.jpg");
cards.add(card);
card = new Card(14,"acec.jpg","back.jpg");
cards.add(card);

}

public void shuffle(){
long seed = System.nanoTime();
Collections.shuffle(cards, new Random(seed));
}

public Card deal(){//deals from top of deck
Card dealt = cards.get(0);
cards.remove(0);
return dealt;
}

}

