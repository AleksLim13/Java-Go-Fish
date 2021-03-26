/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Cards;

import java.util.ArrayList;

/**
 *
 * @author AllyCat13: 
 */
public class Hand {
    
    //Define: adds a Card to a provided hand and copies the updated hand.
    private ArrayList<Card> addCardToHand(ArrayList<Card> cardHand, Card card) {
        cardHand.add(card);
        return cardHand;
    }//End M:*

    //Define: 
    private ArrayList<Card> deleteCardFromHand(
                                       ArrayList<Card> cardHand, 
                                       int posit
                                       ) 
    {
        ArrayList<Card> resultHand = cardHand;
        resultHand.remove(posit);
        return resultHand;
    }//End M:*

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public ArrayList<Card> getCardFromDeck(ArrayList<Card> cardHand) 
    {
        cardHand.add(createRandoCard());
        return cardHand;
    }//End M:*
    
    
    //Define: ablility to remove target from other players hand. Calls delete method. 
    public ArrayList<Card> updateHandDelete(
            ArrayList<Card> cHand,//Incl: list for C's.
            Card tCard//Incl: list for copies. 
    )
                        
     {
        deleteCardFromHand(cHand, findPosit(cHand, tCard));
        return cHand;
    }//End M:*
    
    //Define: ablility to remove target from other players hand. Calls delete method. 
    public ArrayList<Card> updateHandAdd(
            ArrayList<Card> cHand,//Incl: list for C's.
            Card tCard//Incl: list for copies. 
    )
                        
     {
        addCardToHand(cHand, tCard);
        return cHand;
    }//End M:*
 
    //Need to know what the index of the card need to remove 
    //from hand
    private int findPosit(ArrayList<Card> hand, Card tCard) {
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
    private GoFishCard createRandoCard() 
    {
        //A: create: ranges for random number to map against. 
        Card.Value[] values = Card.Value.values();
        Card.Suit[] suits = Card.Suit.values();

        //B: Create: the random numbers modelling suit and values. 
        int valPossible = (int) (Math.random() * values.length) + 1;
        int suitPossible = (int) (Math.random() * suits.length) + 1;

        //C: asssign: the values determined by a random number
        Card.Value randVal = values[valPossible];
        Card.Suit randSuit = suits[suitPossible];

        //D: create: the card object and copy it. 
        return new GoFishCard(randSuit, randVal);
    }//End M:*

}//End CL:*
