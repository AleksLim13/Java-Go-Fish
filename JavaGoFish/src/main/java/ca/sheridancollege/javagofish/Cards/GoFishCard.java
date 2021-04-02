package ca.sheridancollege.javagofish.Cards;


/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class GoFishCard extends Card {
    
 
    public GoFishCard() 
    {
        super();
    }//End C:*

    public GoFishCard(String suit, String value) 
    {
        super(suit, value);
    }//End C:*
    
    public GoFishCard(String value) 
    {
        super(value);
    }//End C:*

    @Override
    public String toString() {   
     return value + " of " + suit; 
    }//End M:*

}//End Class:__________________+
