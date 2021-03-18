/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;
import ca.sheridancollege.project.Players.Player;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class TurnSwitcher {

    //Field Var's 
    private Player human;
    private Player computer;
    private Player inPlay;
    private Player notInPlay;
    private ArrayList<Player> inPlayList;
    private String guess;
    private String coinToss;
    private ArrayList<Player> updPlayerList;

    //Constructor 
    public TurnSwitcher(Player human,
                        Player computer,
                        Player inPlay,
                        Player notInPlay,
                        ArrayList<Player> inPlayList,
                        ArrayList<Player> udpPlayerList) {
        this.human = human;
        this.computer = computer;
        this.inPlay = inPlay;
        this.notInPlay = notInPlay;
        this.inPlayList = inPlayList;
        this.updPlayerList = udpPlayerList;     
    }//End C:*

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

  
  
    public Player getHuman() {
        return human;
    }

    public void setHuman(Player human) {
        this.human = human;
    }

    public Player getComputer() {
        return computer;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }



    public ArrayList<Player> getInPlayList() {
        return inPlayList;
    }

    public void setInPlayList(ArrayList<Player> inPlayList) {
        this.inPlayList = inPlayList;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getCoinToss() {
        return coinToss;
    }

    public void setCoinToss(String coinToss) {
        this.coinToss = coinToss;
    }

    public ArrayList<Player> getUpdPlayerList() {
        return updPlayerList;
    }

    public void setUpdPlayerList(ArrayList<Player> updPlayerList) {
        this.updPlayerList = updPlayerList;
    }
    
    

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
