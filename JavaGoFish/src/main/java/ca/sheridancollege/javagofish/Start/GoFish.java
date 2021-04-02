package ca.sheridancollege.javagofish.Start;

//Imports:__________________________


import ca.sheridancollege.javagofish.Turns.TurnManager;


/************************************************************
 * @author AllyCat13 @ Sheridan High 2021
 */
/**CLASS OVERVIEW:
 * --------------
 *
 * 
 ***************************************************************/
public class GoFish extends Game {

   
    private final TurnManager turnController;
   
            
    public GoFish(String hName, TurnManager tN) {
 
        this.turnController = tN;
       
        
    }//End C:*
    public GoFish(
                  TurnManager turnController
                  ) 
    {
        this.turnController = turnController; 

    }//End C:*

  
    public TurnManager getTurnController() {
        return turnController;
    }

}//End Class:________________+

