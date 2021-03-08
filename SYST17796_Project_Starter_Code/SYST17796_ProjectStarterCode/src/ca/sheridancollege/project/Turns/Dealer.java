
package ca.sheridancollege.project.Turns;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Imports:__________________________________

import ca.sheridancollege.project.Cards.Card;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Dealer {

    //Field Variables:_____________________
    
    private Deck deck;
    private ArrayList<Card> hand;
  
    //Constructors:_____________________
    
    
    public Dealer() {
     this.deck = new Deck();
     this.hand = new ArrayList<>();
    }//End C:*
    
    //I hate null pointer exception!
    public Dealer(Deck deck, ArrayList<Card> hand) {
        this.deck = deck;
        this.hand = hand; 
    }//End C:*
    
    //Getters & Setters:__________________________
    
    
    public Deck getDeck() {
        return deck;
    }//End G:*

    public void setDeck(Deck deck) {
        this.deck = deck;
    }//End S:*

    public ArrayList<Card> getHand() {
        return hand;
    }//End G:*

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }//End S:*

    //Methods:_________________________
    
    public void deckSetup() {
        deck.initDeck();
        deck.shuffle();
    }//End M:*

    //Deal first card and simultaneously remove it from deck
    //Like in real life...
    public Card startDeal() {
        Card card;
        card = deck.getDeck().get(0);
        //B: 
        deck.getDeck().remove(0);
        //C: 
        return card;
    }//End M:*
    
    public void createHand(int size) {
        for (int i = 0; i < size; i++) {
           hand.add(this.startDeal());
        }//End F:*
    }//End M:*


}//End class
