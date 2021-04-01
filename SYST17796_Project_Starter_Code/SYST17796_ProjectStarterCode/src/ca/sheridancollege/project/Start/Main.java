/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;

import ca.sheridancollege.project.Cards.Hand;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Turns.Deck;
import ca.sheridancollege.project.Turns.ScoreBoard;
import ca.sheridancollege.project.Turns.TurnManager;
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
