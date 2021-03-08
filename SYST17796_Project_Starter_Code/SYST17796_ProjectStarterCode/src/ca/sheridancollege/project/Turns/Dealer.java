/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;

//Imports:__________________________________

import ca.sheridancollege.project.Cards.Card;

import ca.sheridancollege.project.Cards.GoFishCard;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Dealer {

    private Deck deck;
    private ArrayList<Card> hand;
  
    public Dealer() {

    }//End C:*
    
    //I hate null pointer exception!
    public Dealer(Deck deck, ArrayList<Card> hand) {
        this.deck = deck;
        this.hand = hand; 
    }//End C:*

    public void deckSetup(Card card, ArrayList<Card> blank) {
      //deck.initDI(new ArrayList<>(), new Suit[4], new Value[15]);
      //deck.setMyLists();
      //deck.assignMyLists();
      //deck.setDeck(deck.initDeck(blank));
      //deck.setDeck(deck.shuffle(deck.getDeck()));
    }//End M:*

    //Deal first card and simultaneously remove it from deck
    //Like in real life...
    public Card startDeal() {
        Card card;
        //A: 
        //card = deck.getDeck().get(0);
        //B: 
        //deck.getDeck().remove(0);
        //C: 
        return new GoFishCard();
    }//End M:*
    
    public void createHand(int size) {
        for (int i = 0; i < size; i++) {
           hand.add(this.startDeal());
        }//End F:*
    }//End M:*
    
    public ArrayList<Card> getHand(){
    return hand; 
    }//End G:*

}//End class
