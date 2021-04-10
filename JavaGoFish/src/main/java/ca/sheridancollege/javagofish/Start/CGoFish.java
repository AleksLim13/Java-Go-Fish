package ca.sheridancollege.javagofish.Start;

//Imports:__________________________


import ca.sheridancollege.javagofish.Turns.ATurnManager;


/**
 * CGOFISH CONCRETE CLASS:
 * -----------------------
 *
 * This is a specific example of a Game that test a players logic and recall. This is a Go Fish version 
 * of a Card game. This class will inherit the reference to a Turn Manager field from it's parent class.
 * A game example may need more data and functionality down the road. May a reference to a timer object.
 * Maybe we want to time rounds or display overall time of the game at the end when a winner has been
 * determined. 
 * 
 * 
 * @author AllyCat13 : Sheridan High 2021
 */

public class CGoFish extends AGame 

{

   /**
    * Each instance of Go Fish needs a reference to TurnManager. 
    * only one is needed and it's state never changes. 
    * TurnManager contains the functionality for asking for Cards and switching who's
    * being asked and who's asking. 
    */
    
   
    /**
     * Creates a instance of Go Fish and initializes game name and turn manager. 
     * @param hName String type.
     * @param tN TurnMnager type. 
     */
    
    /**
     * Constructs a Go Fish instance and initializes name and turn manager.
     * @param hName String type.
     * @param tN TurnManager type. 
     */
    public CGoFish(String hName, ATurnManager tN) 
    {
        super(tN);
    }//End C:*
    
    /**
     * Constructs a instance of Go Fish and initializes TurnManager.
     * @param tM
     * 
     */
    public CGoFish(
                  ATurnManager tM
                  ) 
    {
        super(tM);

    }//End C:*

 
}//End CL:*

