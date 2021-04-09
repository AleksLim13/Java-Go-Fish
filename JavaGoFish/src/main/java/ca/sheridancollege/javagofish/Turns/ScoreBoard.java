
package ca.sheridancollege.javagofish.Turns;


/**
 * This class contains the behavior for making calculations related to a Players hand.
 * @author AllyCat13
 */

import ca.sheridancollege.javagofish.Cards.ACard;
import ca.sheridancollege.javagofish.Players.Player;
import java.util.ArrayList;
import java.util.List;


public class ScoreBoard {
    //Declare:
    
    /**
     * This is a field variable for storing the winner of the game. 
     */
    private Player winner;
 
    /**
     * Default constructor for creating a ScoreBoard to be used in a aggregating class. 
     */
    public ScoreBoard() 
    {
    }//End C:*

    /**
     * Construct a instance of ScoreBoard when the winner is known ahead of time. 
     * @param winner top level Player type. 
     */
    public ScoreBoard(Player winner) 
    {
        this.winner = winner;
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
    public void calcBooks(
            ACard tNum,
            Player player
    ) {
        int ilCount = 0;
        //Repeat: set outer loop. 
        
        player.setBooks(new ArrayList<>());
        
        for (int i = 0; i < player.getDesirableList().size(); i++) 
        {
            //A.3.1: Check:
            if (tNum.getValue().equals(player.getDesirableList().get(i).getValue())) 
            {
                //Increment: counter if already in duplicate list. 
                ilCount++;
            }//End I:*                    
        }//End F:*
        
        if (ilCount == 4) 
        {
            //Add: 
            player.getBooks().add(tNum);
            //Notice: should only ever be four of a kind. E.g., standard deck format. 
            for (int j = 0; j < 4; j++) 
            {
                int pTemp = findFirstIndex(tNum, player.getHand());
                player.getHand().remove(pTemp);
            }//End I:*  
            
            for (int j = 0; j < 4; j++) 
            {
                int pTemp = findFirstIndex(tNum, player.getDesirableList());
                player.getDesirableList().remove(pTemp);
            }//End I:*  
        }//End I:*  
    }//End M:*
     
    /**
     * This method determines where Cards are located that need to be worked on.
     * @param tNum top level Card type.
     * @param tList Card list type.
     * @return integer as position of the Card in the target Hand.
     */
     private int findFirstIndex(
            ACard tNum,
            List<ACard> tList
    ) {
        int pos = 0;
        for (int i = 0; i < tList.size(); i++) 
        {
            if (tNum.getValue().equals(tList.get(i).getValue())) 
            {
                pos = i;
                return pos;
            }//End I:*
        }//End F:*
        return pos;
    }//End M:*
      
     /**
      * This method creates a list of duplicates cards a Player has.
      * @param player top level Player type. 
      */
    public void getDupes(
                              Player player
                              ) 
    {
        player.getDesirableList().clear();
        
    //A: main for loop: compare each card to every other card in hand.
        for (int i = 0; i < player.getHand().size(); i++) {
            int lCount = 0;
            //A.1: par two of compare each card to every other card in hand.
            //----
            for (int j = 0; j < player.getHand().size(); j++) {
                //Notice: duplicates determined only by card value.
                if (player.getHand().get(i).getValue().equals(player.getHand().get(j).getValue())) {
                    //A.1.1: increase counter if they are equal. 
                    lCount++;
                }//End I:*
            }//End F:*
            //A.2: counter > 1 means theres duplicates.
            //-----
            //Check: 
            if (lCount > 1) {
                player.getDesirableList().add(player.getHand().get(i));
            }//End I:*
        }//End F:*
    }//End M:*
    
    

    /**
     * 
     * @param human top level Player type.
     * @param computer top level Player type. 
     * @return Player determined to be the one who made the most progress during the game.
     */
    public Player determineWinner(Player human, Player computer) {
        if(human.getBooks().size() > computer.getBooks().size()){
            winner = human;
        }//End I:*
        else{
            winner = computer;
        }//End E:*
        return winner;
    }//End M:*
    
}//End CL:*
