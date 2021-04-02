package ca.sheridancollege.javagofish.Utility;



//Imports:______________________
import ca.sheridancollege.javagofish.Cards.Card;
import java.util.List;

/**
 * Class for printing Player lists to the console so the human player knows what's happening and why.
 * @author AllyCat13 @ Sheridan High 2021
 */


public final class Printer {

    /**
     * We don't need to create a instance of Printer because we have simple static display methods.
     */
    public Printer() 
    {

    }//End C:*

    /**
     * Static method for looping through a list and printing each item.
     * @param tHand Card list type.
     */
    public static void printHand(List<Card> tHand) 
    {
        for (Card c: tHand) 
        {
            System.out.println(c.toString());
        }//End F:*
    }//End method 

} //End class
