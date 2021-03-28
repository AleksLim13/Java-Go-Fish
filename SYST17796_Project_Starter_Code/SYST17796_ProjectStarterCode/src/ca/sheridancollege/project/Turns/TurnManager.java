/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;


import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import ca.sheridancollege.project.Cards.Hand;
import ca.sheridancollege.project.Cards.PseudoCard;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Utility.UInput;
import java.util.List;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class TurnManager {

    //Declare: fields: for keeping track. 
    //A: Declare: it's only a two player game. 
    
    //B: Declare: designate storage for each.
    //C: Declare: a list to kee track. 
    //F: Declare: 
    private final Player human;
    private final Player computer;
    private Player inPlay;
    private Player notInPlay;
    private final Hand classHand;
    private final ScoreBoard scoreBoard;

    //Constructor 
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
    }

    public void setInPlay(Player inPlay) 
    {
        this.inPlay = inPlay;
    }

    public Player getNotInPlay() 
    {
        return notInPlay;
    }

    public Player getHuman() 
    {
        return human;
    }

    public Player getComputer() 
    {
        return computer;
    }
    
    public void setNotInPlay(Player notInPlay) 
    {
        this.notInPlay = notInPlay;
    }

    public Hand getClassHand() 
    {
        return this.classHand;
    }


    public ScoreBoard getScoreBoard() 
    {
        return this.scoreBoard;
    }
    
    //This works as a check if card is in opponents hand 
    //so there turn keeps going. Returns a yes or no. 
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
                  this.classHand.getCardFromDeck(this.inPlay.getHand());
                  System.out.println("In Play Hand:");
                  System.out.println(this.inPlay.getHand().toString());
                  
                  System.out.println("Not In Play Hand:");
                  System.out.println(this.notInPlay.getHand().toString());

                  return false;
              }//End I:*
              
              else if(!check)
              {
                   System.out.println(this.notInPlay.getName() + " does have " + cTemp.getValue());
                   this.classHand.updateHandAdd(this.inPlay.getHand(), cTemp, this.notInPlay.getHand());
                   System.out.println("In Play Hand:");
                   System.out.println(this.inPlay.getHand().toString());
                
                   this.classHand.updateHandDelete(this.notInPlay.getHand(), this.inPlay.getHand().get(this.inPlay.getHand().size()-1));  
                   System.out.println("Not In Play Hand:");
                   System.out.println(this.notInPlay.getHand().toString());

              }//End EI:*
        }//End W:*
              
        return false;      
    }//End M:*
    
     //Define: gets value and suit as string and then maps it. 
    //while loop overall strcuture with inner for loop and if.
    private Card humanAskingForACard() 
    {
        boolean flag = true;
        //A: Iterate: 
        while (flag) 
        {
            //A.1: Get: 
            System.out.println("Which card value do you want?");
            String cvDesire = UInput.promptStringUser();
            //A.2: Get: 
            //A.3: Create: 
            PseudoCard cDesire = new PseudoCard(
                                                cvDesire.toUpperCase()
                                            );
            //A.4: Initialize: 
            cDesire.createDeck();
            //A.5: Repeat: 
            for (int i = 0; i < cDesire.getPseudoDeck().size(); i++) 
            {
                //A.6: Check: 
                if (cDesire.getValue().equals(cDesire.getPseudoDeck().get(i).getValue())) 
                {
                    //A.7: Create: 
                    Card resCard = new GoFishCard(
                                                  cDesire.getValue()
                                                  );//End C:*
                    //A.9: Copy: 
                    return resCard;
                }//End I:*
            }//End F:*
        }//End W:*
        //A.10: Anticipate: 
        return null;
    }//End M:*
    
    
    private Card computerAskingForACard()
    {
        List<Card> dTemp = computer.getDesirableList();
        List<Card> hTemp = computer.getHand();
        Card cTemp = null;
        
        if(!dTemp.isEmpty())
        {
            cTemp = new GoFishCard(dTemp.get(0).getValue());
            System.out.println("Computer is asking for: " + cTemp.getValue());
            return cTemp;
        }//End I:*
       
        else if(!hTemp.isEmpty())
        {
            cTemp = new GoFishCard(hTemp.get(0).getValue());
            System.out.println("Computer is asking for: " + cTemp.getValue());
            return cTemp;
        }//End E:*
        
        else if(dTemp.isEmpty() && hTemp.isEmpty())
        {
            System.out.println("Computer has no cards left in their hand");
            return null;
        }//End E:*
        
        return cTemp;
    }//End M:*
    
  
    //Deciding which player goes first 
    public void coinToss(String guess) 
    {
        
        //A: Create: the coin as string array.
        String[] coin = {"heads", "tails"};
        
        ///B: simulate: the coin landing with value face up.
        int decision = (int) (Math.random() * 2);
        
        //C: Get: store the result; either heads or tails.
        String flipped = coin[decision];
        
        //C: Evaluate: 
        if (guess.equals(flipped)) 
        {
            System.out.println("You're right. It was: " + flipped + " . It's your play");
           this.inPlay = this.human;
           this.notInPlay = computer;
        } //End I:*
        
        else if(!guess.equals(flipped))
        {
            System.out.println("Sorry, it was: " + flipped);
            this.inPlay = computer;
            this.notInPlay = human;
       
        }//End E:*
  
    }//End M:*
    
}//End class 
