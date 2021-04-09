

package ca.sheridancollege.javagofish.Players;

//Imports:__________________________

import ca.sheridancollege.javagofish.Cards.ACard;
import java.util.List;



/**
 *This models human players. 
 * This class inherits data and functionality from Player. 
 * @author alllyCat13 @ Sheridan High 2021
 */
public class HumanPlayer extends Player{
    
 /**
  * Constructs a Player and initializes name, books, and duplicate list.
  * @param name of String type.
  * @param books card list type.
  * @param dL Card list type. 
  */
    public HumanPlayer(String name, List<ACard> books, List<ACard> dL){
        super(name, books, dL);
    }//End C:*
    
 
}//End Class:__________________+
