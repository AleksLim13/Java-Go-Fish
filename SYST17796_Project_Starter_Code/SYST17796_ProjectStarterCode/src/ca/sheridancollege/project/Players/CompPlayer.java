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

    public CompPlayer() {
        super();//For visual understanding.
    }//End C:*

    public CompPlayer(String name, ArrayList<Card> hand) {
        super("Computer", hand);
    }//End C:*

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }//End M:*

}//End Class:______________________+
