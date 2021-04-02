package ca.sheridancollege.project.Start;

//Imports:__________________________

import ca.sheridancollege.project.Cards.Hand;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Turns.ScoreBoard;
import ca.sheridancollege.project.Turns.TurnManager;
import java.util.ArrayList;


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
