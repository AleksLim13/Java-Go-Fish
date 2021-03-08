/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Cards;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class CardHand {
    
        private final int handSize = 52;
	public final Card[] cards = new Card[handSize];

	
        /**
         * Add comments during class to explain what this method does.
         */
        /*
        This is an enhance for loop. called a for each loop. 
        The outer loop is bound by range of suits.
        The inner loop is bound by the range of values of cards.
        Like Ace-King. This method starts by adding Ace-King as heart,
        then Ace-King as clubs, then Ace-King as spades, then Ace-King as diamonds.
        The end result will be a deck Ace-King in order ascending from
        hearts - spades times 4.  
        Suit {HEARTS, CLUBS, SPADES, DIAMONDS, DEFAULT};
        Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, DEFAULT};
        
        */
        public void generateHand()
        {
                int countCards = 0;
		for(Card.Suit s: Card.Suit.values())
                {
                    for(Card.Value v: Card.Value.values())
                    {
                        cards[countCards] = (new GoFishCard(s,v));
                        countCards++;
                    }
                }//end outter for
        }//end method
}//End Class:________________+
