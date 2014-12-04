/*  Neil Carey
   CS 110
   Final HW
   
   WarCardGame
   
   WarCardGame(String S)   Sets up window, names the window
   
   requires Deck class to be saved to computer
   
   nextHand()  changes the window and deals from the deck
   flip()  determines winner of round
   war()  called if there is a tie, adds cards to loot pile that will be given to next winner
   humanWonWar () 
   compWonWar ()  both of these will give the appropriate player the won cards
   
   */
   

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class WarCardGame extends JFrame
{
   private JButton button;
   private JLabel compPic,humanPic,hScore,cScore,yourBack,compBack;
   public ImageIcon front,back,humanIcon,compIcon;
   public Card humanCard;
   public Card compCard;
   public Deck deck = new Deck();
   public int humanScore = 0;
   public int compScore = 0;
   public String whoWin = "NO ONE WON YET";
   ArrayList<Card> humanHand = new ArrayList<Card>();
   ArrayList<Card> compHand = new ArrayList<Card>();
   ArrayList<Card> warLoot = new ArrayList<Card>();
   
   public WarCardGame(String s){
      super(s);   //extends JFrame
      deck.shuffle();   //shuffles deck calling method from deck
      
      setLayout(new FlowLayout());
      button = new JButton("flip");
      button.addActionListener(new ButtonListener());
      
      for(int i = 0;i<52;i++){ //tries to load cards from deck
        try{
           humanHand.add(deck.deal());
           compHand.add(deck.deal());
           }
        catch(NullPointerException n){}
        catch(IndexOutOfBoundsException e){}           } 
      cScore = new JLabel("<html>PRESS FLIP TO DEAL NEXT CARD<br>Cards In Computer Hand :<html>" + Integer.toString(compHand.size())+"<html><br>Computer Score is : <html>"+Integer.toString(compScore)+"<html><br><html>"+whoWin);
      hScore = new JLabel("<html>PRESS FLIP TO DEAL NEXT CARD<br>Cards In Your Hand :<html>" + Integer.toString(humanHand.size())+"<html><br>Your Score is : <html>"+Integer.toString(humanScore)+"<html><br><html>"+whoWin);
      humanCard = humanHand.get(0);
      compCard =compHand.get(0);
      back = humanCard.getBack();
      humanIcon = humanCard.getFront();
      compIcon = compCard.getFront();
      compPic = new JLabel(compIcon);
      humanPic = new JLabel(humanIcon); 
      yourBack = new JLabel(back);
      compBack = new JLabel(back);     //sets up view
               
      winner();         //determines winner
      
           
      add(yourBack);
      add(hScore);                     
      add(humanPic);
      add(button);
      add(compPic);
      add(cScore);
      add(compBack);//creates window

   }
   //class to handle button press
   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      flip();
      }
   }  //listens for clicking on the flip button
   
   public void nextHand(){ //deals next hand to player, tells info about last hand
      humanCard = humanHand.get(0);
      compCard =compHand.get(0);
      humanIcon = humanCard.getFront();
      compIcon = compCard.getFront();
      humanPic.setIcon(humanIcon);
      compPic.setIcon(compIcon);
      hScore.setText("<html>PRESS FLIP TO DEAL NEXT CARD<br>Cards In Your Hand :<html>" + Integer.toString(humanHand.size())+"<html><br>Your Score is : <html>"+Integer.toString(humanScore)+"<html><br><html>"+whoWin);
      cScore.setText("<html>PRESS FLIP TO DEAL NEXT CARD<br>Cards In Computer Hand :<html>" + Integer.toString(compHand.size())+"<html><br>Computer Score is : <html>"+Integer.toString(compScore)+"<html><br><html>"+whoWin);
   }
   
   public void war(){
   
   warLoot.add(compCard);
   warLoot.add(humanCard);
   flip();   //if the players tie it adds their cards to a new arraylist, then next winner gets them
   }
   
   public void flip(){
      humanHand.remove(0);
      compHand.remove(0);
      long seed = System.nanoTime();
      nextHand();
      System.out.println(humanHand.size());
      System.out.println(compHand.size());
      winner();
      }  //determines next cards and updates window
      
   public void winner(){   //will determine if human or computer has won
        if (humanCard.getRank() > compCard.getRank()){
        System.out.println("human wins");
        whoWin = "YOU WON THIS ROUND!";
        humanScore++;
        humanHand.add(humanCard);
        humanHand.add(compCard);
        humanWonWar();
        }   
        
     else if (humanCard.getRank()==compCard.getRank()){
        System.out.println("tie");
        whoWin = "!     WAR    !";
        war();
        }
          
     else {
        System.out.println("Computer wins");
        whoWin = "COMPUTER WON THIS ROUND";
        compHand.add(humanCard);
        compHand.add(compCard);
        compScore++;
        compWonWar();
        }
        if (humanHand.size() == 0){
         JOptionPane.showMessageDialog(null,"GAME OVER COMPUTER WINS");
         }
        else if (compHand.size()==0) JOptionPane.showMessageDialog(null,"GAME OVER YOU WIN");
   }

   public void humanWonWar(){ // if human wins adds card to human pile
   for (int i = 0;i<warLoot.size();i++){
         humanHand.add(warLoot.get(i));
         warLoot.remove(i);
        }
   }
   
   public void compWonWar(){  //if computer wins adds card to computer pile
   for (int i = 0;i<warLoot.size();i++){
         compHand.add(warLoot.get(i));
         warLoot.remove(i);
        }
   }
   
   public static void main(String [] args)
   {
  
      JFrame frame = new WarCardGame("War Card Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);    //runs WarCardGame as a object in the main method
   }


}