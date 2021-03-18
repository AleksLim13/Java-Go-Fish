/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;

import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Turns.Dealer;
import ca.sheridancollege.project.Turns.TurnSwitcher;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021. 
 */
public class Start {
    
    public static void main(String[] args){
    GoFish game = new GoFish(
                             new Dealer(),
                             new HumanPlayer(),
                             new CompPlayer(),
                             new TurnSwitcher()
                             );
    game.play();
    }//End M:*
    
}//End CL:*
