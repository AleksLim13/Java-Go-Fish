/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Imports:_____________________________

package ca.sheridancollege.project.Turns;

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Deck {
    
    //Fields:________________________
    
    private List<Card> deck; 
    
    //Constructors:______________________
    
    //Empty constructor  
    public Deck() {     
        this.deck = new ArrayList<>();
    }//End C:*
    
    //Getters & Setters:___________________
        public List<Card> getDeck() {
        return this.deck;
    }//End G:*

    //Of objects as cards with 2 fields 
    //Takes blank array list as param 
    public void initDeck() {  
        for (String suitsRange : Card.suitsRange) {
            for (String valuesRange : Card.valuesRange) {
                this.deck.add(new GoFishCard(suitsRange, valuesRange));
            } //End Inner F:*
        } //end outter for   
    }//End M:*
   
    //Swap pairs of card objects at random positions / 52.
    //Needs the actually value of this class's field var
    public void shuffle() {
        int rando;
        for (int i = 0; i < this.deck.size(); i++) {
            rando = (int) (Math.random() * this.deck.size());        
            Card temp = this.deck.get(i);
            this.deck.set(i, this.deck.get(rando));
            this.deck.set(rando, temp);         
        }//End Outer F:*
    }//End M:*
    
    private int findPosit(List<Card> hand, Card tCard) {
        int posit = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(tCard)) {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*
    
    private int findPositOfValueOnly(List<Card> deck, Card tCard) {
        int posit = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getValue() == tCard.getValue()) {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*
    
    
    public List<Card> removeCard(Card card){
        this.deck.remove(findPosit(this.deck, card));
        return this.deck;
    }//End M:*
} //End class:_______________________
