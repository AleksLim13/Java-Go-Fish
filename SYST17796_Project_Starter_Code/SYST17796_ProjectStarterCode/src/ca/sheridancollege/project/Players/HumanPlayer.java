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

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        
    }//End C:*
    
}//End Class:__________________+
