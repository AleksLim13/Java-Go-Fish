/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;

import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Turns.Dealer;
import ca.sheridancollege.project.Turns.Deck;
import ca.sheridancollege.project.Turns.TurnSwitcher;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021. 
 */
public class Start {
  
   
    public static void main(String[] args){
    
        Player human = new HumanPlayer();
        Player computer = new CompPlayer();
        
    GoFish game = new GoFish(
                             new Dealer(new Deck(),
                             new ArrayList<>()),
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
