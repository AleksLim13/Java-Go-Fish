package ca.sheridancollege.javagofish.Utility;

//Imports:______________________
import ca.sheridancollege.javagofish.Cards.ACard;
import java.util.List;

/**
 * Class for printing Player lists to the console so the human player knows
 * what's happening and why.
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
   public final class Printer 

{

    /**
     * We don't need to create a instance of Printer because we have simple
     * static display methods. We have no data to track for. No data related to
     * instances of these objects that change dynamically based on input and state
     * changes.
     */
    public Printer() 
    {

    }//End C:*

    /**
     * Static method for looping through a list and printing each item.
     *
     * @param tHand Card list type.
     */
    public static void printHand(List<ACard> tHand) 
    {
        try 
        {
            for (ACard c : tHand) 
            {
                System.out.println(c.toString());
            }//End F:*
        } 
        catch (NullPointerException | IndexOutOfBoundsException e) 
        {
            System.out.println(e);
            System.out.println("Has the hand as method argument being initialized?");
            System.out.println("Is the loop traversing the array slots properly?");
        }//End CAT:*

    }//End method 

} //End class
