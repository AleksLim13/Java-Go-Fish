package ca.sheridancollege.project.Turns;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Imports:__________________________________
import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import ca.sheridancollege.project.Cards.PseudoCard;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Utility.UInput;
import java.util.ArrayList;
import java.util.List;

/**************************************************
 *
 * @author AllyCat13 @ Sheridan High 2021
 ***************************************************/
public class Dealer {

    //Field Variables:_____________________
    private Deck deck;
    private ArrayList<Card> hand;

    public Dealer() 
    {
        
    }//End C:*

    //Constructors:_____________________
    
    //Define: Normal constructor. Sets fields. Calls known method. 
    public Dealer(
                  Deck deck,
                  ArrayList<Card> hand
                  ) 
    {
        this.deck = deck;
        this.hand = hand;
        this.deckSetup();
    }//End C:*

    //Getters & Setters:__________________________
    
    //Define: Normal getter. Accessing the deck. 
    public Deck getDeck() {
        return deck;
    }//End G:*

    //Define: normal setter. Assign new deck.
    public void setDeck(Deck deck) {
        this.deck = deck;
    }//End S:*

    //Define: normal getter for accessing the hand.
    public ArrayList<Card> getHand() {
        return hand;
    }//End G:*

    //Define: normal setter for a new hand.
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }//End S:*

    //Methods:_________________________
    
    //Define: this fills deck and shuffles it. Uses 2 known methods.
    private void deckSetup() {
        deck.initDeck();
        deck.shuffle();
    }//End M:*

    //Define: Deal first card and simultaneously remove it from deck.
    private Card startDeal() {
        Card card;
        card = deck.getDeck().get(0);
        //B: 
        deck.getDeck().remove(0);
        //C: 
        return card;
    }//End M:*

    //Define: provide number of cards. Repetition solution. Call's start deal.
    public void createHand(int size) {

        if (hand.size() > 0) {
            hand.clear();
        }//End I:*

        for (int i = 0; i < size; i++) {
            hand.add(this.startDeal());
        }//End F:*     

    }//End M:*

    
    

    
    


}//End class

