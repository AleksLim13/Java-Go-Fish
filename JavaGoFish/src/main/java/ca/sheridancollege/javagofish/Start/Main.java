package ca.sheridancollege.javagofish.Start;

import ca.sheridancollege.javagofish.Players.CompPlayer;
import ca.sheridancollege.javagofish.Players.HumanPlayer;
import ca.sheridancollege.javagofish.Cards.CGoFishDeck;
import ca.sheridancollege.javagofish.Cards.CGoFishHand;
import ca.sheridancollege.javagofish.Turns.GoFishScoreBoard;
import ca.sheridancollege.javagofish.Turns.TurnManager;
import java.util.ArrayList;

/**
 * 
 * The Main class with the main method for where the program starts.
 * 
 * 
 * 
 * 
 * @author AllyCat13. 
 */
public class Main 
{
    
    /**
     * The main method. Creates the RoundOne object. Calls the class RounOne play method.  
     * @param args 
     */
    public static void main(String[] args)
    {
        TurnManager tM = new TurnManager(
                                        new HumanPlayer(
                                                        "Aleks", 
                                                        new ArrayList<>(), 
                                                        new ArrayList<>()
                                                         ),//End C:* 
                                        new CompPlayer(
                                                       new ArrayList<>(), 
                                                       new ArrayList<>()
                                                       ), //End C:*
                                        new CGoFishHand(
                                                 new CGoFishDeck(new ArrayList<>()),
                                                 new GoFishScoreBoard()
                                                ), //End C:*
                                        new GoFishScoreBoard()
                                        );
        
        RoundOne round1 = new RoundOne(
                                       new GoFish(
                                                  "Aleks", 
                                                  tM)
                                       );
        round1.play();
    }//End M:*
    
}//End CL:*
