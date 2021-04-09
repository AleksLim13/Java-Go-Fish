package ca.sheridancollege.javagofish.Start;

//Imports:__________________________


import ca.sheridancollege.javagofish.Turns.ATurnManager;


/**
 * Specific example of a Game. This is a Go Fish version of a Card game.
 * @author AllyCat13 : Sheridan High 2021
 */

public class CGoFish extends AGame {

   /**
    * Each instance of Go Fish needs a reference to TurnManager. 
    * only one is needed and it's state never changes. 
    * TurnManager contains the functionality for asking for Cards and switching who's
    * being asked and who's asking. 
    */
    private final ATurnManager turnController;
   
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
 
        this.turnController = tN;
       
        
    }//End C:*
    
    /**
     * Constructs a instance of Go Fish and initializes TurnManager.
     * @param turnController TurnManager type.
     */
    public CGoFish(
                  ATurnManager turnController
                  ) 
    {
        this.turnController = turnController; 

    }//End C:*

  
    public ATurnManager getTurnController() {
        return turnController;
    }

}//End Class:________________+

