package ca.sheridancollege.javagofish.Start;

import ca.sheridancollege.javagofish.Players.CCompPlayer;
import ca.sheridancollege.javagofish.Players.CHumanPlayer;
import ca.sheridancollege.javagofish.Cards.CGoFishDeck;
import ca.sheridancollege.javagofish.Cards.CGoFishHand;
import ca.sheridancollege.javagofish.Turns.CGoFishScoreBoard;
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
                                        new CHumanPlayer(
                                                        "Aleks", 
                                                        new ArrayList<>(), 
                                                        new ArrayList<>()
                                                         ),//End C:* 
                                        new CCompPlayer(
                                                       new ArrayList<>(), 
                                                       new ArrayList<>()
                                                       ), //End C:*
                                        new CGoFishHand(
                                                 new CGoFishDeck(new ArrayList<>()),
                                                 new CGoFishScoreBoard()
                                                ), //End C:*
                                        new CGoFishScoreBoard()
                                        );
        
        CRoundOne round1 = new CRoundOne(
                                       new CGoFish(
                                                  "Aleks", 
                                                  tM)
                                       );
        round1.play();
    }//End M:*
    
}//End CL:*
