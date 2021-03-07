/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;
import ca.sheridancollege.project.Players.Player;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class TurnSwitcher {

    //Field Var's 
    private Player inPlay;
    private Player notInPlay;

    //Constructor 
    public TurnSwitcher() {

    }

    //Getter 
    public Player getInPlay() {
        return inPlay;
    }

    //Setter 
    public void setInPlay(Player newInPlay) {
        this.inPlay = newInPlay;
    }

    //Getter 
    public Player getNotInPlay() {
        return notInPlay;
    }//End G:*

    //Setter 
    public void setNotInPlay(Player newNotInPlay) {
        this.notInPlay = newNotInPlay;
    }//End S:*

    //Start Normal Methods 
    public Player turnSwitcher(Player inPlay, Player notInPlay) {
        //A: 
        Player temp = inPlay;
        //B: 
        inPlay = notInPlay;
        notInPlay = temp;
        //C: 
        return inPlay;
    }//End M:*

    //Deciding which player goes first 
    public String coinToss(String guess) {
        //A: Create It
        String[] coin = {"heads", "tails"};
        int decision = (int) (Math.random() * 2);
        //B: Do It
        String flipped = coin[decision];
        //C: Evaluate It
        String result;
        if (guess.equals(flipped)) {
            result = "correct";
        } else {
            result = "incorrect";
        }
        //D: Copy It
        return result;
        
    }//End M:*
    
    
    
}//End class 
