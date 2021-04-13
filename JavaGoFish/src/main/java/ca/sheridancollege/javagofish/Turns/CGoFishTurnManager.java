/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.javagofish.Turns;

import ca.sheridancollege.javagofish.Cards.ACard;
import ca.sheridancollege.javagofish.Cards.ADeck;
import ca.sheridancollege.javagofish.Cards.AHand;
import ca.sheridancollege.javagofish.Cards.CGoFishCard;
import ca.sheridancollege.javagofish.Cards.CGoFishDeck;
import ca.sheridancollege.javagofish.Players.APlayer;
import ca.sheridancollege.javagofish.Players.CCompPlayer;
import ca.sheridancollege.javagofish.Players.CHumanPlayer;
import ca.sheridancollege.javagofish.Utility.Printer;
import ca.sheridancollege.javagofish.Utility.UInput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * CGOFISHTURNMANAGER CONCRETE CLASS: 
 * ---------------------------------
 * 
 * C is for concrete class. 
 *
 *
 *
 * @author AllyCat13.
 */
    public class CGoFishTurnManager extends ATurnManager 

{

    public CGoFishTurnManager(
                              APlayer human, 
                              APlayer computer, 
                              AHand hand, 
                              AScoreBoard scoreBoard
                             ) 
    {
        super(human, computer, hand, scoreBoard);
    }//End M:*

    @Override
    public boolean goFish(ACard inPlaysDesireC) 
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

    @Override
    public boolean shouldKeepGoing() 
    {
        boolean flag = true;
        while (flag) 
        
        {
            ACard cTemp = null;

            if (this.inPlay instanceof CHumanPlayer) 
            {
                cTemp = humanAskingForACard();
            }//End I:*
            else if (this.inPlay instanceof CCompPlayer) 
            {
                cTemp = computerAskingForACard();
            }//End EI:*

            boolean check = goFish(cTemp);

            if (check) 
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
                System.out.println("[" + this.inPlay.getName() + "]" + " In Play");

                System.out.println("");
                System.out.println("[" + this.notInPlay.getName() + "]" + " Not In Play");

                return false;
            }//End I:*
            else if (!check) 
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

    @Override
    public ACard humanAskingForACard() 
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
            CGoFishCard cDesire = new CGoFishCard(
                    cvDesire.toUpperCase()
            );
            //A.4: Initialize: 
            ADeck deck = new CGoFishDeck(new ArrayList<>());
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

    @Override
    public ACard computerAskingForACard() 
    {
        List<ACard> dTemp = computer.getDesirableList();
        List<ACard> hTemp = computer.getHand();
        ACard cTemp = null;
        
        if(!dTemp.isEmpty())
        {
            cTemp = new CGoFishCard(dTemp.get(0).getValue());
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
            cTemp = new CGoFishCard(hTemp.get(0).getValue());
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

    @Override
    public void turnSwitcher() 
    {
        APlayer temp = inPlay;
        inPlay = notInPlay;
        notInPlay = temp;
    }//End M:*

}//End CL:*
