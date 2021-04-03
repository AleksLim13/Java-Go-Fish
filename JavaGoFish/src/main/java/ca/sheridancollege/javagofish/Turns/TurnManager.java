package ca.sheridancollege.javagofish.Turns;


import ca.sheridancollege.javagofish.Cards.Card;
import ca.sheridancollege.javagofish.Cards.Deck;
import ca.sheridancollege.javagofish.Cards.GoFishCard;
import ca.sheridancollege.javagofish.Cards.Hand;
import ca.sheridancollege.javagofish.Players.CompPlayer;
import ca.sheridancollege.javagofish.Players.HumanPlayer;
import ca.sheridancollege.javagofish.Players.Player;
import ca.sheridancollege.javagofish.Utility.Printer;
import ca.sheridancollege.javagofish.Utility.UInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class has all the data and functionality needed for tasks that occur during a Players turn. 
 * During a turn, a Players asking for cards is determined to be a success or failure.
 * Whether or not the player should keep asking needs to be determined. 
 * the way a computer and human each uniquely ask for cards needs to be defined. 
 * A way for the Players status as the one asking versus the one being asked needs to be defined. 
 * @author AllyCat13 @ Sheridan High 2021.
 */
public class TurnManager {

    //Declare: fields: for keeping track. 
    //A: Declare: it's only a two player game. 
    
    //B: Declare: designate storage for each.
    //C: Declare: a list to kee track. 
    //F: Declare: 
    
    /**
     * A reference to a Human player is required.
     */
    private final Player human;
    /**
     * A reference to a computer player is required.
     */
    private final Player computer;
    /**
     * A reference to the player asking for cards is required.
     */
    private Player inPlay;
    /**
     * A reference to the player being asked for cards is required.
     */
    private Player notInPlay;
    /**
     * A reference to the Hand class for hand related tasks is required. 
     */
    private final Hand classHand;
    /**
     * A reference to a scoreboard for strategy related tasks is required. 
     */
    private final ScoreBoard scoreBoard;

    //Constructor 
    
   /**
    * Constructs a TurnManager instance and initializes Players and helpers.
    * @param human top level Player type.
    * @param computer top level Player type.
    * @param hand Hand class type.
    * @param scoreBoard ScoreBoard class type. 
    */
    public TurnManager(
                        Player human,
                        Player computer,
                        Hand hand,
                        ScoreBoard scoreBoard
                         ) 
    {
        this.human = human;
        this.computer = computer;
        this.classHand = hand;
        this.scoreBoard = scoreBoard;
    }//End C:*

    public Player getInPlay() 
    {
        return inPlay;
    }//End G:*

    public void setInPlay(Player inPlay) 
    {
        this.inPlay = inPlay;
    }//End G:*

    public Player getNotInPlay() 
    {
        return notInPlay;
    }//End G:*

    public Player getHuman() 
    {
        return human;
    }//End G:*

    public Player getComputer() 
    {
        return computer;
    }//End G:*
    
    public void setNotInPlay(Player notInPlay) 
    {
        this.notInPlay = notInPlay;
    }//End S:*

    public Hand getClassHand() 
    {
        return this.classHand;
    }//End G:*


    public ScoreBoard getScoreBoard() 
    {
        return this.scoreBoard;
    }//End G:*
    
    /**
     * This is a check to see if the Card is in the asked players hand.
     * it asks the not asking player for a card, checks their hand if it's there, 
     * @param inPlaysDesireC top level Card type. 
     * @return signal if the Card is in the player hand who's being asked. 
     */
    private boolean goFish(Card inPlaysDesireC) 
    {
        for (int i = 0; i < notInPlay.getHand().size(); i++) 
        {
            if (notInPlay.getHand().get(i).getValue().equals(inPlaysDesireC.getValue())) 
            {
                return false;
            }//End I:*
        }//End F:*
        return true;
    }//End M:*
    
    /**
     * This method iterates for as long as a players ask was successful.
     * it asks the not asking player for a card, checks their hand if it's there, 
     * updates both players hands accordingly, and switches who's during the asking for next round. 
     * @return signal to if the players turn was successful or not. 
     */
    public boolean shouldKeepGoing()
    {
        boolean flag = true;
        while(flag)
        {
            Card cTemp = null;
              
            if(this.inPlay instanceof HumanPlayer)
            {
                  cTemp = humanAskingForACard();
              }//End I:*
              else if(this.inPlay instanceof CompPlayer)
              {
                  cTemp = computerAskingForACard();
              }//End EI:*
              
              boolean check = goFish(cTemp);
              
              if(check)
              {
                  System.out.println(this.notInPlay.getName() + " does not have " + cTemp.getValue());
                  this.classHand.getCardFromDeck(this.inPlay);
                  
                  System.out.println("");
                  this.classHand.sort(inPlay, 'h');
                  System.out.println(this.inPlay.getName() + " In Play Hand:");
                  Printer.printHand(this.inPlay.getHand());
                  
                  System.out.println("");
                  this.classHand.sort(this.notInPlay, 'h');
                  System.out.println(this.notInPlay.getName() + " Not In Play Hand:");
                  Printer.printHand(this.notInPlay.getHand());
                  
                  System.out.println("");
                  System.out.println("Switching who's in play");
                  
                  this.turnSwitcher();
                  
                  System.out.println("");
                  System.out.println( "[" + this.inPlay.getName() + "]" + " In Play");
                  
                  System.out.println("");
                  System.out.println(  "[" + this.notInPlay.getName() + "]" + " Not In Play");
                  
                  return false;
              }//End I:*
              
              else if(!check)
              {
                   System.out.println("");
                   System.out.println(this.notInPlay.getName() + " does have " + cTemp.getValue());
                   
                   this.classHand.updateHandAdd(
                                                this.inPlay, 
                                                cTemp, 
                                                this.notInPlay
                                               );
                   
                   System.out.println("");
                   this.classHand.sort(this.inPlay, 'h');
                   System.out.println("[" + this.inPlay.getName() + "]" + " In Play Hand:");
                   Printer.printHand(this.inPlay.getHand());
                
                   //Notice: now deleting from class hand.
                   
                   System.out.println("");
                   this.classHand.sort(this.notInPlay, 'h');
                   System.out.println("[" + this.notInPlay.getName() + "]" + " Not In Play Hand:");
                   Printer.printHand(this.notInPlay.getHand());
              }//End EI:*
        }//End W:*
              
        return false;      
    }//End M:*
    
     /**
      * Behavior for the unique way a human players asks for a Card.
      * The human players implements their own strategy of which card they'll ask for
      * to get as many four of a kinds they can.
      * @return the card asked for of top level Card type. 
      */
    private Card humanAskingForACard() 
    {
        boolean flag = true;
        //A: Iterate: 
        while (flag) 
        {
            //A.1: Get: 
            System.out.println("");
            System.out.println("Which card value do you want?");
            
            UInput.setInput(new Scanner(System.in));
            String cvDesire = UInput.promptStringUser();
            //A.2: Get: 
            //A.3: Create: 
            GoFishCard cDesire = new GoFishCard(
                                                cvDesire.toUpperCase()
                                            );
            //A.4: Initialize: 
            Deck deck = new Deck(new ArrayList<>());
            deck.initDeck();
            //A.5: Repeat: 
            for (int i = 0; i < deck.getDeck().size(); i++) 
            {
                //A.6: Check: 
                if (cDesire.getValue().equals(deck.getDeck().get(i).getValue())) 
                {
                    
                    return cDesire;
                }//End I:*
            }//End F:*
        }//End W:*
        //A.10: Anticipate: 
        return null;
    }//End M:*
    
    /**
     * A computer needs some strategy logic for which card they ask for. 
     * We use several lists for the computers thought process. 
     * The computer needs a Card list of duplicates determined from their hand as obvious ask options.
     * We could create additional lists for keeping track of Cards the opponent asked for for more
     * sophisticated strategy implementation by the AI. The AI could easily implement a card counting strategy.
     * @return the Card asked for by the AI.
     */
    private Card computerAskingForACard()
    {
        List<Card> dTemp = computer.getDesirableList();
        List<Card> hTemp = computer.getHand();
        Card cTemp = null;
        
        if(!dTemp.isEmpty())
        {
            cTemp = new GoFishCard(dTemp.get(0).getValue());
            System.out.println("");
            System.out.println("Computer is asking for: " + cTemp.getValue());
            System.out.println("Do you have any?");
            UInput.setInput(new Scanner(System.in));
            String response = UInput.promptStringUser();
            if(response.equals("yes"))
            {
                System.out.println("Ok thanks for confirming");
            }//End I:*
            else if(response.equals("no"))
            {
                System.out.println("Ok, computer will go fish then");
            }//End I:*
            return cTemp;
        }//End I:*
       
        else if(!hTemp.isEmpty())
        {
            cTemp = new GoFishCard(hTemp.get(0).getValue());
            System.out.println("");
            System.out.println("Computer is asking for: " + cTemp.getValue());
            System.out.println("Do you have any?");
            UInput.setInput(new Scanner(System.in));
            String response = UInput.promptStringUser();
            if(response.equals("yes"))
            {
                System.out.println("Ok thanks for confirming");
            }//End I:*
            else if(response.equals("no"))
            {
                System.out.println("Ok, computer will go fish then");
            }//End I:*
            return cTemp;
        }//End E:*
        
        else if(dTemp.isEmpty() && hTemp.isEmpty())
        {
            System.out.println("");
            System.out.println("Computer has no cards left in their hand");
            return null;
        }//End E:*
        
        return cTemp;
    }//End M:*
    
    /**
     * Simple method for switching who's currently asking by assigning the Player to designated Player variable.
     * Use a Player temp variable to facilitate the swapping of the in play versus not in play player.
     */
    private void turnSwitcher()
    {
        Player temp = inPlay;
        inPlay = notInPlay;
        notInPlay = temp;  
    }//End M:*
    
}//End class 
