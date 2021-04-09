package ca.sheridancollege.javagofish.Cards;


/**
 * This class is an extension of the Card class. 
 * It is a specific type of Card yet it still takes on values and suits of a standard deck.
 * It is a Go Fish card to be used in the deck during a game. 
 * This class doesn't extend much data or functionality from Card other than being a unique implementation.
 * 
 * @author AllyCat13 @ Sheridan High 2021
 */
public class GoFishCard extends ACard {
    
 /**
  * This constructor call's Cards default no argument constructor.
  */
    public GoFishCard() 
    {
        super();
    }//End C:*

    /**
     * Creates a Card by calling Cards suit and value argument constructor. 
     * @param suit of String type. The suit of this card instance.
     * @param value of String type. The value of this card instance. 
     */
    public GoFishCard(String suit, String value) 
    {
        super(suit, value);
    }//End C:*
    
    /**
     * Calls Cards value only constructor because players typically ask only for values.
     * @param value of String type. The value of this Card instance.
     */
    public GoFishCard(String value) 
    {
        super(value);
    }//End C:*

    /**
     * Overrides Objects toString for custom printing of these Card instances.
     * @return the String value of the Cards suit and value values.
     */
    @Override
    public String toString() {   
     return value + " of " + suit; 
    }//End M:*

}//End Class:__________________+
