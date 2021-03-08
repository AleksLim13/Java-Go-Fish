/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Players;

//Imports:__________________________

import ca.sheridancollege.project.Cards.Card;
import java.util.*;

/**
 *
 * @author alllyCat13 @ Sheridan High 2021
 */
public class HumanPlayer extends Player{
    
    public HumanPlayer(){
        super();
    }//End C:*
    
    public HumanPlayer(String name, ArrayList<Card> hand){
        super(name, hand);
    }//End C:*

    /*
    Recall: this is what a Player has.
    protected String name;
    protected int playerId;
    protected ArrayList<Card> hand;
    protected static int numOfPlayers;
    
    */
    @Override
    public void printStats() {    
        System.out.println(super.name + " " + super.playerId);
        super.hand.forEach(c -> {
            System.out.println(c);
        }); //End F:*
    }//End C:*
    
}//End Class:__________________+
