
package ca.sheridancollege.javagofish.Turns;


/**
 * This class contains the behavior for making calculations related to a Players hand.
 * @author AllyCat13
 */

import ca.sheridancollege.javagofish.Cards.ACard;
import ca.sheridancollege.javagofish.Players.Player;
import java.util.List;


public abstract class ScoreBoard 

{
    //Declare:
    
    /**
     * This is a field variable for storing the winner of the game. 
     */
    protected Player winner;
 
  
    /**
     * Construct a instance of ScoreBoard when the winner is known ahead of time. 
     */
    public ScoreBoard() 
    {
        
    }//End C:*

    public Player getWinner() 
    {
        return winner;
    }//End G:*

    public void setWinner(Player winner) 
    {
        this.winner = winner;
    }//End S:*
    
    /**
     * This method determines if a Player has a four of a kind and then records it.
     * @param tNum top level Card type.
     * @param player top level Player type. 
     */
    public abstract void calcBooks(
            ACard tNum,
            Player player
    );
     
    /**
     * This method determines where Cards are located that need to be worked on.
     * @param tNum top level Card type.
     * @param tList Card list type.
     * @return integer as position of the Card in the target Hand.
     */
     public abstract int findFirstIndex(
            ACard tNum,
            List<ACard> tList
     );
      
     /**
      * This method creates a list of duplicates cards a Player has.
      * @param player top level Player type. 
      */
    public abstract void getDupes(
                              Player player
                              ); 
    /**
     * 
     * @param human top level Player type.
     * @param computer top level Player type. 
     * @return Player determined to be the one who made the most progress during the game.
     */
    public abstract Player determineWinner(Player human, Player computer); 
    
}//End CL:*
