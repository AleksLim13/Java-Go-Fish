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
    public ArrayList<Card> addCard(ArrayList<Card> cardHand, Card card) {
        cardHand.add(card);
        return cardHand;
    }//End M:*

    //Define: 
    private ArrayList<Card> deleteCard(
                                       ArrayList<Card> cardHand, 
                                       int posit
                                       ) 
    {
        ArrayList<Card> resultHand = cardHand;
        resultHand.remove(posit);
        return resultHand;
    }//End M:*

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public ArrayList<Card> drawCard(ArrayList<Card> cardHand) 
    {
        cardHand.add(randoCard());
        return cardHand;
    }//End M:*

    //Define: ablility to remove target from other players hand. Calls delete method. 
    public ArrayList<Card> checkHandAndRemove(
            ArrayList<Card> cardHand,//Incl: list for C's.
            ArrayList<Integer> dupesHolder//Incl: list for copies. 
                                             ) 
     {
        if (dupesHolder != null) {//Eval: is it empty?
            cardHand = deleteCard(
                                  cardHand, 
                                  dupesHolder.get(0)
                                  );//Assi: 
        }//End I:*
        return cardHand;
    }//End M:*
 
    //Need to know what the index of the card need to remove 
    //from hand
    public int findPosit(ArrayList<Card> hand, Card tCard) {
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
    private GoFishCard randoCard() 
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
