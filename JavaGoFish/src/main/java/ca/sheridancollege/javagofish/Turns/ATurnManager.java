package ca.sheridancollege.javagofish.Turns;


import ca.sheridancollege.javagofish.Cards.ACard;
import ca.sheridancollege.javagofish.Cards.ADeck;
import ca.sheridancollege.javagofish.Cards.CGoFishCard;
import ca.sheridancollege.javagofish.Cards.CGoFishDeck;
import ca.sheridancollege.javagofish.Cards.AHand;
import ca.sheridancollege.javagofish.Players.CCompPlayer;
import ca.sheridancollege.javagofish.Players.CHumanPlayer;
import ca.sheridancollege.javagofish.Players.APlayer;
import ca.sheridancollege.javagofish.Utility.Printer;
import ca.sheridancollege.javagofish.Utility.UInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ATURNMANAGER ABSTRCT CLASS:
 * ------------------
 * 
 * 
 * This class has all the data and functionality needed for tasks that occur during a Players turn. 
 * During a turn, a Players asking for cards is determined to be a success or failure.
 * Whether or not the player should keep asking needs to be determined. 
 * the way a computer and human each uniquely ask for cards needs to be defined. 
 * A way for the Players status as the one asking versus the one being asked needs to be defined.
 * 
 * 
 * 
 * 
 * 
 * @author AllyCat13 @ Sheridan High 2021.
 */
    
    public abstract class ATurnManager 

{

    //Declare: fields: for keeping track. 
    //A: Declare: it's only a two player game. 
    
    //B: Declare: designate storage for each.
    //C: Declare: a list to kee track. 
    //F: Declare: 
    
    /**
     * A reference to a Human player is required.
     */
    protected final APlayer human;
    /**
     * A reference to a computer player is required.
     */
    protected final APlayer computer;
    /**
     * A reference to the player asking for cards is required.
     */
    protected APlayer inPlay;
    /**
     * A reference to the player being asked for cards is required.
     */
    protected APlayer notInPlay;
    /**
     * A reference to the Hand class for hand related tasks is required. 
     */
    protected final AHand classHand;
    /**
     * A reference to a scoreboard for strategy related tasks is required. 
     */
    protected final AScoreBoard scoreBoard;

    //Constructor 
    
   /**
    * Constructs a TurnManager instance and initializes Players and helpers.
    * @param human top level Player type.
    * @param computer top level Player type.
    * @param hand Hand class type.
    * @param scoreBoard ScoreBoard class type. 
    */
    public ATurnManager(
                        APlayer human,
                        APlayer computer,
                        AHand hand,
                        AScoreBoard scoreBoard
                         ) 
    {
        this.human = human;
        this.computer = computer;
        this.classHand = hand;
        this.scoreBoard = scoreBoard;
    }//End C:*

    public APlayer getInPlay() 
    {
        return inPlay;
    }//End G:*

    public void setInPlay(APlayer inPlay) 
    {
        this.inPlay = inPlay;
    }//End G:*

    public APlayer getNotInPlay() 
    {
        return notInPlay;
    }//End G:*

    public APlayer getHuman() 
    {
        return human;
    }//End G:*

    public APlayer getComputer() 
    {
        return computer;
    }//End G:*
    
    public void setNotInPlay(APlayer notInPlay) 
    {
        this.notInPlay = notInPlay;
    }//End S:*

    public AHand getClassHand() 
    {
        return this.classHand;
    }//End G:*


    public AScoreBoard getScoreBoard() 
    {
        return this.scoreBoard;
    }//End G:*
    
    /**
     * This is a check to see if the Card is in the asked players hand.
     * it asks the not asking player for a card, checks their hand if it's there, 
     * @param inPlaysDesireC top level Card type. 
     * @return signal if the Card is in the player hand who's being asked. 
     */
    public abstract boolean goFish(ACard inPlaysDesireC) ;
    
    /**
     * This method iterates for as long as a players ask was successful.
     * it asks the not asking player for a card, checks their hand if it's there, 
     * updates both players hands accordingly, and switches who's during the asking for next round. 
     * @return signal to if the players turn was successful or not. 
     */
    public abstract boolean shouldKeepGoing(); 
    
     /**
      * Behavior for the unique way a human players asks for a Card.
      * The human players implements their own strategy of which card they'll ask for
      * to get as many four of a kinds they can.
      * @return the card asked for of top level Card type. 
      */
    public abstract ACard humanAskingForACard();
    /**
     * A computer needs some strategy logic for which card they ask for. 
     * We use several lists for the computers thought process. 
     * The computer needs a Card list of duplicates determined from their hand as obvious ask options.
     * We could create additional lists for keeping track of Cards the opponent asked for for more
     * sophisticated strategy implementation by the AI. The AI could easily implement a card counting strategy.
     * @return the Card asked for by the AI.
     */
    public abstract ACard computerAskingForACard();
    /**
     * Simple method for switching who's currently asking by assigning the Player to designated Player variable.
     * Use a Player temp variable to facilitate the swapping of the in play versus not in play player.
     */
    public abstract void turnSwitcher(); 
    
}//End class 
