package ca.sheridancollege.javagofish.Players;

//Imports:________________________________

import ca.sheridancollege.javagofish.Cards.ACard;
import java.util.List;


/**
 * This a specific type of Player for modeling the computer.
 * This class inherits data and functionality from Player.
 * @author AllyCat13 @ Sheridan High 2021. 
 */
public class CCompPlayer extends APlayer {

    /**
     * Prevent null pointer exception with Card lists copies to initialize field variables. 
     * @param books Card list data type.
     * @param dL card list data type. 
     */
    public CCompPlayer(List<ACard> books, List<ACard> dL) {
        super("Computer", books, dL);//For visual understanding.
    }//End C:*

   
    
}//End Class:______________________+
