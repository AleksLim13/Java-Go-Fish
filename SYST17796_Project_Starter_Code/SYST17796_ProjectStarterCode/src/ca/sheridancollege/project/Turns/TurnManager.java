/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;
import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import ca.sheridancollege.project.Cards.Hand;
import ca.sheridancollege.project.Cards.PseudoCard;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Utility.UInput;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class TurnManager {

    //Declare: fields: for keeping track. 
    //A: Declare: it's only a two player game. 
    private Player human;
    private Player computer;
    //B: Declare: designate storage for each.
    private Player inPlay;
    private Player notInPlay;
    //C: Declare: a list to kee track. 
    private ArrayList<Player> inPlayList;
    //D: declare: storage for the coin toss.
    private String guess;
    private String coinToss;
    //E: Declare: another list to update back and forth. 
    private ArrayList<Player> updPlayerList;
    //F: Declare: 
    private Hand hand;

    //Constructor 
    public TurnManager(
                        Player human,
                        Player computer,
                        Player inPlay,
                        Player notInPlay,
                        ArrayList<Player> inPlayList,
                        ArrayList<Player> udpPlayerList
                         ) 
    {
        this.human = human;
        this.computer = computer;
        this.inPlay = inPlay;
        this.notInPlay = notInPlay;
        this.inPlayList = inPlayList;
        this.updPlayerList = udpPlayerList;     
    }//End C:*

    //Getter 
    public Player getInPlay() {
        return inPlay;
    }//End G:*

    //Setter 
    public void setInPlay(Player newInPlay) {
        this.inPlay = newInPlay;
    }//End S:*

    //Getter 
    public Player getNotInPlay() {
        return notInPlay;
    }//End G:*

    //Setter 
    public void setNotInPlay(Player newNotInPlay) {
        this.notInPlay = newNotInPlay;
    }//End S:*

    public Player getHuman() {
        return human;
    }//End G:*

    public void setHuman(Player human) {
        this.human = human;
    }//End S:*

    public Player getComputer() {
        return computer;
    }//End G:*

    public void setComputer(Player computer) {
        this.computer = computer;
    }//End S:*
    
    public ArrayList<Player> getInPlayList() {
        return inPlayList;
    }//End G:*

    public void setInPlayList(ArrayList<Player> inPlayList) {
        this.inPlayList = inPlayList;
    }//End S:*

    public String getGuess() {
        return guess;
    }//End G:*

    public void setGuess(String guess) {
        this.guess = guess;
    }//End S:*

    public String getCoinToss() {
        return coinToss;
    }//End G:*

    public void setCoinToss(String coinToss) {
        this.coinToss = coinToss;
    }//End S:*

    public ArrayList<Player> getUpdPlayerList() {
        return updPlayerList;
    }//End G:*

    public void setUpdPlayerList(ArrayList<Player> updPlayerList) {
        this.updPlayerList = updPlayerList;
    }

    public Hand getHand() {
        return hand;
    }//End G:*

    public void setHand(Hand hand) {
        this.hand = hand;
    }//End S:*
   
    //Start Normal Methods 
    public Player turnSwitcher(Player inPlay, Player notInPlay) {
        
        //A: Hold: Pin it to a baord.
        Player temp = inPlay;
        
        //B: Switch: swap the two. 
        inPlay = notInPlay;
        notInPlay = temp;
        
        //C: Copy: remember it. 
        return inPlay;
    }//End M:*
    
    
    //This works as a check if card is in opponents hand 
    //so there turn keeps going. Returns a yes or no. 
    public boolean goFish(ArrayList<Card> hand, Card card) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                return false;
            }//End I:*
        }//End F:*
        return true;
    }//End M:*
    
    public boolean shouldKeepGoing(){
        
        boolean flag = true;
        while(flag){
            
            Card cTemp = askForACard();
            boolean check = goFish(inPlay.getHand(), cTemp);
            
            if(!check){
                hand.updateHandAdd(inPlay.getHand(), cTemp);
                hand.updateHandDelete(notInPlay.getHand(), cTemp);
            }//End I:*
            
            if(check){
                hand.getCardFromDeck(inPlay.getHand());
                turnSwitcher(inPlay, notInPlay);
                flag = false; 
            }//end I:*
        }//End W:*
        //Set: limits.
        
        return false;      
    }//End M:*
    
     //Define: gets value and suit as string and then maps it. 
    //while loop overall strcuture with inner for loop and if.
    public Card askForACard() {
        boolean flag = true;
        //A: Iterate: 
        while (flag) {
            //A.1: Get: 
            System.out.println("Which card value do you want?");
            String cvDesire = UInput.promptStringUser();
            //A.2: Get: 
            System.out.println("Which card suit do you want?");
            String csDesire = UInput.promptStringUser();
            //A.3: Create: 
            PseudoCard cDesire = new PseudoCard(
                                                cvDesire.toUpperCase(), 
                                                csDesire.toUpperCase()
                                            );
            //A.4: Initialize: 
            cDesire.createDeck();
            //A.5: Repeat: 
            for (int i = 0; i < cDesire.getPseudoDeck().size(); i++) {
                //A.6: Check: 
                if (cDesire.equals(cDesire.getPseudoDeck().get(i))) {
                    //A.7: Create: 
                    Card resCard = new GoFishCard(
                                                            Card.Suit.valueOf(
                                                                        cDesire.getSuit()
                                                                             ), //End M:*
                                                            Card.Value.valueOf(
                                                                        cDesire.getValue()
                                                                              )//End M:*
                                                       );//End C:*
                    //A.9: Copy: 
                    return resCard;
                }//End I:*
            }//End F:*
        }//End W:*
        //A.10: Anticipate: 
        return null;
    }//End M:*

    //Deciding which player goes first 
    public String coinToss(String guess) {
        
        //A: Create: the coin as string array.
        String[] coin = {"heads", "tails"};
        
        ///B: simulate: the coin landing with value face up.
        int decision = (int) (Math.random() * 2);
        
        //C: Get: store the result; either heads or tails.
        String flipped = coin[decision];
        
        //C: Evaluate: 
        String result;
        if (guess.equals(flipped)) {
            System.out.println("You're right. It was: " + flipped + " . It's your play");
            result = "correct";
            inPlay = human;
        } //End I:*
        
        else {
            result = "incorrect";
            inPlay = computer;
        }//End E:*
        
        //D: Copy It
        return result;
        
    }//End M:*
    
}//End class 
