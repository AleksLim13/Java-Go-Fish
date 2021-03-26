/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Cards;

import java.util.List;
import ca.sheridancollege.project.Turns.Deck;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13: 
 */
public class Hand {
    
    private ArrayList<Card> hand;
    private Deck deck;

    public Hand(Deck deck) {
        this.deck = deck;
    }//End C:*

    public Hand() {
        this.deck = new Deck();
    }//End C:*
    
    

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    //Define: adds a Card to a provided hand and copies the updated hand.
    private List<Card> addCardToHand(List<Card> cardHand, Card card) {
        cardHand.add(card);
        return cardHand;
    }//End M:*

    //Define: 
    private List<Card> deleteCardFromHand(
                                       List<Card> cardHand, 
                                       int posit
                                       ) 
    {
        List<Card> resultHand = cardHand;
        resultHand.remove(posit);
        return resultHand;
    }//End M:*

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public List<Card> getCardFromDeck(List<Card> cardHand) 
    {
        cardHand.add(createRandoCard());
        return cardHand;
    }//End M:*
    
    
    //Define: ablility to remove target from other players hand. Calls delete method. 
    public List<Card> updateHandDelete(
            List<Card> cHand,//Incl: list for C's.
            Card tCard//Incl: list for copies. 
    )
                        
     {
        deleteCardFromHand(cHand, findPosit(cHand, tCard));
        return cHand;
    }//End M:*
    
    //Define: ablility to remove target from other players hand. Calls delete method. 
    public List<Card> updateHandAdd(
            List<Card> cHand,//Incl: list for C's.
            Card tCard//Incl: list for copies. 
    )
                        
     {
        addCardToHand(cHand, tCard);
        return cHand;
    }//End M:*
 
    //Need to know what the index of the card need to remove 
    //from hand
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
    
    //Define: behavior for taking random card from deck after told to go fish. 
    private Card createRandoCard() 
    {
        //A: create: ranges for random number to map against. 
        Card.Value[] values = Card.Value.values();

        //B: Create: the random numbers modelling suit and values. 
        int valPossible = (int) (Math.random() * values.length) + 1;

        //C: asssign: the values determined by a random number
        Card resCard = deck.getDeck().get(valPossible);

        //D: create: the card object and copy it. 
        deck.removeCard(resCard);
        
        return resCard;
    }//End M:*
    
    
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

    

}//End CL:*
