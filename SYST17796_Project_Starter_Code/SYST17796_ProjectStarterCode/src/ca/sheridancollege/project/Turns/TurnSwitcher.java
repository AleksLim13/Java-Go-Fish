/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;
import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Utility.Printer;
import ca.sheridancollege.project.Utility.UInput;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class TurnSwitcher {

    //Field Var's 
    private final Card cardStuff;
    private Player human;
    private Player computer;
    private Player inPlay;
    private Player notInPlay;
    private final Printer printStuff;
    private final UInput inputStuff;
    private ArrayList<Player> inPlayList;
    private String guess;
    private String coinToss;
    private ArrayList<Player> updPlayerList;

    //Constructor 
    public TurnSwitcher() {
        this.cardStuff = new GoFishCard();
        this.human = new HumanPlayer();
        this.computer = new CompPlayer();
        this.inPlay = new Player();
        this.notInPlay = new Player();
        this.printStuff = new Printer();
        this.inputStuff = new UInput();
        this.inPlayList = new ArrayList<>();
        this.updPlayerList = new ArrayList<>();     
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

    public Card getCardStuff() {
        return cardStuff;
    }

  
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

    public Printer getPrintStuff() {
        return printStuff;
    }

    public UInput getInputStuff() {
        return inputStuff;
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
