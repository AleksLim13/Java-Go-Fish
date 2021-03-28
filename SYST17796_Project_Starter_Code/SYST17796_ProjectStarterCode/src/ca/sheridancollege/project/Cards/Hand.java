/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Cards;

import java.util.List;
import ca.sheridancollege.project.Turns.Deck;

/**
 *
 * @author AllyCat13: 
 */
public class Hand {
    
    private Deck deck;

    public Hand(Deck deck) 
    {
        this.deck = deck;
        deckSetup();
    }//End C:*

    public Hand() 
    {
        this.deck = new Deck();
        deckSetup();

    }//End C:*
    

    public Deck getDeck() 
    {
        return this.deck;
    }

    public void setDeck(Deck deck) 
    {
        this.deck = deck;
    }
    
    //Define: yes. the opponent has the card. add to inplay and subtract not in play.
    private void addCardToHand(
                                     List<Card> inPlayHand, //inplay
                                     Card inPlaysDesireC, //in plays desire
                                     List<Card> notInPlayHand //remmove from
                                    ) 
    {
       
        int posit = findPositPartialCard(notInPlayHand, inPlaysDesireC);
        Card cTemp = notInPlayHand.get(posit);
        inPlayHand.add(cTemp);
    }//End M:*

    //Define: opponent has card. Remove it after giving it to player in play. 
    private void deleteCardFromHand(
                                       List<Card> notInPlayHand, 
                                       int posit
                                       ) 
    {

        notInPlayHand.remove(posit);
    }//End M:*

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public List<Card> getCardFromDeck(List<Card> cardHand) 
    {
        cardHand.add(createRandoCard());
        return cardHand;
    }//End M:*
    
    
    //Define: Not in play has the card. Remove it from not in play. 
    public void updateHandDelete(
            List<Card> notInPlayHand,//Incl: list for C's.
            Card inPlaysDesireC//Incl: list for copies. 
    )
                        
     {
        deleteCardFromHand(notInPlayHand, findPositFullCard(notInPlayHand, inPlaysDesireC));

    }//End M:*
    
    //Define: ablility to remove target from other players hand. Calls delete method. 
    public void updateHandAdd(
            List<Card> inPlayHand,//Incl: list for C's.
            Card inPlaysDesireC,//Incl: list for copies. 
            List<Card> notInPlayHand
    )
                        
     {
        addCardToHand(inPlayHand, inPlaysDesireC, notInPlayHand);
    }//End M:*
 
    //Need to know what the index of the card need to remove 
    //from hand
    private int findPositFullCard(List<Card> hand, Card tCard) 
    {
        int posit = 0;
        for (int i = 0; i < hand.size(); i++) 
        {
            if (hand.get(i).equals(tCard)) 
            {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*
    
    private int findPositPartialCard(List<Card> hand, Card tCard) 
    {
        int posit = 0;
        for (int i = 0; i < hand.size(); i++) 
        {
            if (hand.get(i).getValue().equals(tCard.getValue())) 
            {
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
        
        //B: Create: the random numbers modelling suit and values. 
        int valPossible = (int) (Math.random() * Card.valuesRange.length) + 1;

        //C: asssign: the values determined by a random number
        Card resCard = this.deck.getDeck().get(valPossible);

        //D: create: the card object and copy it. 
        this.deck.removeCard(resCard);
        
        return resCard;
    }//End M:*
    
   

    //Methods:_________________________
    
    //Define: this fills deck and shuffles it. Uses 2 known methods.
    private void deckSetup() 
    {
        this.deck.initDeck();
        this.deck.shuffle();
    }//End M:*

    //Define: Deal first card and simultaneously remove it from deck.
    private Card startDeal() 
    {//Notice: end of line style looks better.
        Card card;
        card = this.deck.getDeck().get(0);
        //B: 
        this.deck.getDeck().remove(0);
        //C: 
        return card;
    }//End M:*

    //Define: provide number of cards. Repetition solution. Call's start deal.
    public List<Card> createHand(int size, List<Card> tHand) 
    {
        for (int i = 0; i < size; i++) 
        {
            tHand.add(this.startDeal());
        }//End F:*          
        return tHand;
    }//End M:*

    

}//End CL:*
