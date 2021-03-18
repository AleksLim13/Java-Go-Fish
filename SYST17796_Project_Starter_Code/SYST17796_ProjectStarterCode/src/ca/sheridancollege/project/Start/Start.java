/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Turns.Dealer;
import ca.sheridancollege.project.Turns.TurnSwitcher;
import ca.sheridancollege.project.Utility.UInput;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021. 
 */
public class Start {
    /*
    String name,
                       ArrayList<Card> hand,
                       HashMap<Card.Value, Integer> scoreBoard,
                       HashMap<Card.Value, Integer> books,
                       ArrayList<Card> desirableList
    */
    public static void main(String[] args){
    
        Player human = new HumanPlayer(UInput.promptStringUser(),
                                             new ArrayList<>(),
                                             new HashMap<>(),
                                             new HashMap<>(),
                                             new ArrayList<>());
        Player computer = new CompPlayer("Computer",
                                             new ArrayList<>(),
                                             new HashMap<>(),
                                             new HashMap<>(),
                                             new ArrayList<>());
    GoFish game = new GoFish(
                             new Dealer(),
                             human,
                             computer,
                             new TurnSwitcher(human,
                                              computer,
                                              human,
                                              computer,
                                              new ArrayList<>(),
                                              new ArrayList<>()
                                               )//End inner:* 
                            );//End outer:*
    game.play();
    }//End M:*
    
}//End CL:*
