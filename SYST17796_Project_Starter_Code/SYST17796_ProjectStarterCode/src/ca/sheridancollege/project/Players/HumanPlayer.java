/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Players;

//Imports:__________________________


/**
 *
 * @author alllyCat13 @ Sheridan High 2021
 */
public class HumanPlayer extends Player{
    
 
    public HumanPlayer(){
        super();
    }//End C:*
    
  
    @Override
    public void printStats() {    
        System.out.println(super.name + " " + super.playerId);
        super.hand.forEach(c -> {
            System.out.println(c);
        }); //End F:*
    }//End C:*
    
}//End Class:__________________+
