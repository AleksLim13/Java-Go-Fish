package ca.sheridancollege.javagofish.Start;

import ca.sheridancollege.javagofish.Players.CCompPlayer;
import ca.sheridancollege.javagofish.Players.CHumanPlayer;
import ca.sheridancollege.javagofish.Cards.CGoFishDeck;
import ca.sheridancollege.javagofish.Cards.CGoFishDealer;
import ca.sheridancollege.javagofish.Turns.CGoFishScoreBoard;
import ca.sheridancollege.javagofish.Turns.CGoFishTurnManager;
import ca.sheridancollege.javagofish.Turns.ATurnManager;
import java.util.ArrayList;

/**
 * CMAIN CONCRETE CLASS:
 * ---------------------
 * 
 * The Main class with the main method for where the program starts.
 * This class is a stand alone class. It does not extend any class nor
 * will it be extending by another class. It's sole purpose is to be a class for
 * the main method the run time system looks for. We dedicate a class for this
 * method for the sake of clarity. 
 * 
 * 
 * 
 * @author AllyCat13. 
 */
public class CMain 
{
    
    /**
     * The main method. Creates the RoundOne object. Calls the class RounOne play method.  
     * @param args 
     */
    public static void main(String[] args)
    {
        ATurnManager tM = new CGoFishTurnManager(
                                        new CHumanPlayer(
                                                        "Aleks", 
                                                        new ArrayList<>(), 
                                                        new ArrayList<>()
                                                         ),//End C:* 
                                        new CCompPlayer(
                                                       new ArrayList<>(), 
                                                       new ArrayList<>()
                                                       ), //End C:*
                                        new CGoFishDealer(
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
