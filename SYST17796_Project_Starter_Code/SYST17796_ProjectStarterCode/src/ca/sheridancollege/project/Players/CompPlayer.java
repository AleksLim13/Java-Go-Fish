/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Players;

//Imports:________________________________

import java.util.*;
import ca.sheridancollege.project.Cards.Card;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021. 
 */
public class CompPlayer extends Player {

    public CompPlayer(
                       String name,
                       ArrayList<Card> hand,
                       int[][] books,
                       ArrayList<Card> desirableList) {
        super(        name,
                      hand,
                      books,
                      desirableList
             );//For visual understanding.
    }//End C:*

    public CompPlayer(String name, ArrayList<Card> hand) {
        super("Computer", hand);
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
        System.out.println(super.name);
        super.hand.forEach(c -> {
            System.out.println(c);
        }); //End F:*
    }//End C:*
    
}//End Class:______________________+
