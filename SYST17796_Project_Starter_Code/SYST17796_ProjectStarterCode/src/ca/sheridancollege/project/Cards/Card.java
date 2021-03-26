/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project.Cards;

import java.util.Objects;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author AllyCat13, 2021. 
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * return values: a String representation of a card. 
     * Could be an UNO card, a regular playing card etc.
     */
    
        public enum Suit {HEARTS, CLUBS, SPADES, DIAMONDS};
        public enum Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
        protected Suit suit;
        protected Value value;
    
        
        //Default Constructor:
        public Card(){
            suit = Suit.HEARTS;
            value = Value.ACE;
        }//End C:*
        
        public Card(Suit s, Value gVal)
        {
           suit =s;
           value= gVal;
        }//End C:*
        
	public Value getValue() {
		return this.value;
	}//End G:*

	
	public Suit getSuit() {
		return this.suit;
        }//End G:*
        
      
    @Override
    public abstract String toString();
    
      @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Card theCard = (Card) o;
            return value == theCard.value &&
                   suit == theCard.suit;
        }//End M:*

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.suit);
        hash = 67 * hash + Objects.hashCode(this.value);
        return hash;
    }
    
}//End Class:_______________________+
