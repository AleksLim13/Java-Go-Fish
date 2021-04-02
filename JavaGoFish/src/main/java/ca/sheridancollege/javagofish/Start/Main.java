package ca.sheridancollege.javagofish.Start;

import ca.sheridancollege.javagofish.Cards.Hand;
import ca.sheridancollege.javagofish.Players.CompPlayer;
import ca.sheridancollege.javagofish.Players.HumanPlayer;
import ca.sheridancollege.javagofish.Cards.Deck;
import ca.sheridancollege.javagofish.Turns.ScoreBoard;
import ca.sheridancollege.javagofish.Turns.TurnManager;
import java.util.ArrayList;

/**
 *
 * @author aleks
 */
public class Main 
{
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
                                        new Hand(
                                                 new Deck(),
                                                 new ScoreBoard()
                                                ), //End C:*
                                        new ScoreBoard()
                                        );
        
        RoundOne round1 = new RoundOne(
                                       new GoFish(
                                                  "Aleks", 
                                                  tM)
                                       );
        round1.play();
    }//End M:*
    
}//End CL:*
