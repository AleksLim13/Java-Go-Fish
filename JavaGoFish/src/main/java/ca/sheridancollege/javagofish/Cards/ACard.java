package ca.sheridancollege.javagofish.Cards;

import java.util.Objects;

/**
 * CARD ABSTRACT CLASS:
 * --------------------
 * 
 * 
 * 
 * This class models Card objects used in a Card game. 
 * Each card has a value and a suit. Both fields are string 
 * values. the range of values for each are stored in a 
 * static final array that's of public access allowance. 
 *  This is the most general category of what a
 * card can be and has. It's abstract and will be extended by classes
 * like Go Fish card or Black Jack Card. 
 * 
 * 
 * @author AllyCat13.
 */
public abstract class ACard 
{
    //default modifier for child classes
    
    /**
     * A field variable for range of suits a Card can have.
     * It's a String array because the suit values don't change.
     * There's only ever four of them. Strings are easy to work with
     * as much Java API classes can sort, split, or add them. Regular
     * arrays are easy to perform operations on directly. 
     */
    
        public final static String[] suitsRange = 
        {
                                    "HEARTS", 
                                    "CLUBS", 
                                    "SPADES", 
                                    "DIAMONDS"
        };
        
     /**
     * A field variable for range of values a Card can have.
     * There's thirteen constant values for Card values in a 
     * standard deck. It's final because these values don't change.
     * It's static because only one copy is ever needed for reference.
     * This range comes in hand for initializing the deck. All values
     * are encapsulated in one String array variable. 
     */
        public final static String[] valuesRange = 
        {
                                     "ACE", 
                                     "TWO", 
                                     "THREE", 
                                     "FOUR", 
                                     "FIVE", 
                                     "SIX", 
                                     "SEVEN", 
                                     "EIGHT", 
                                     "NINE", 
                                     "TEN", 
                                     "JACK", 
                                     "QUEEN", 
                                     "KING"
        };
        
        /**
         * Field variable for a Cards suit.
         * Each cards suit will be stored here. 
         * It's protected so extending classes can use
         * it directly. It's of String type.
         */
        protected String suit;
        
        /**
         * A Card needs to store is value
         * characteristic. A String indicating it's
         * value is stored here. 
         */
        protected String value;
    
        
        /**
         * Default constructor for creating a Card.
         * No parameters passed in. Sets Cards suit and 
         * value to default values. Ace of Hearts. 
         */
        public ACard()
        {
            suit = suitsRange[0];
            value = valuesRange[0];
        }//End C:*
        
        /**
         * Constructs A Card object with value only. 
         * At times during go fish only a value is asked for.
         * If player has two two's, they ask for any more twos. 
         * They don't care about the suit they just want four of a
         * kind. 
         * @param value of String type. 
         */
        public ACard(String value)
        {
          this.value = value;
        }//End C:*
        
        /**
         * Constructs a Card object when 
         * value and suit are known ahead of time. 
         * @param suit of String type.
         * @param value of String type. 
         */
        public ACard(String suit, String value)
        {
           this.suit = suit;
           this.value= value;
        }//End C:*
        
        /**
         * Value getter for the Card instance. 
         * @return String value of the Card object.
         */
	public String getValue() 
        {
            return this.value;
	}//End G:*
        
        /**
         * Getter for the suit of the Card instance. 
         * @return String suit value of Card object. 
         */
	public String getSuit() 
        {
            return this.suit;
        }//End G:*
        

        /**
         * Override objects toString for easy 
         * printing of Card's attributes. 
         * @return String value of Card instance suit and value.
         */
    @Override
    public abstract String toString();
    
    /**
     * Override the equals method inherited from 
     * Object so Cards can be compared and determined
     * if their states are equal per a Cards attributes
     * suit and value. 
     * @param o is the object to be compared. 
     * @return true or false value depending if suits and values match. 
     */
      @Override
        public abstract boolean equals(Object o); 

    @Override
    public abstract int hashCode();
    
}//End CL:*
