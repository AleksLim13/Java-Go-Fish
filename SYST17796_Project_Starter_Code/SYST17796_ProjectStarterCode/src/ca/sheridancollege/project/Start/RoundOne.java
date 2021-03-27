/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Utility.Printer;
import ca.sheridancollege.project.Utility.UInput;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RoundOne extends Start {

    private Game game;

    public RoundOne(Game game) 
    {
        this.game = game;
    }//End C:*

    @Override
    public void play() 
    {

        if (game instanceof GoFish) 
        {
            
         
            
            System.out.println("Creating humans hand");
            ((GoFish)game).getTurnController().getHand().createHand(7);
             List<Card> hHand = ((GoFish)game).getTurnController().getHand().getHand();
            ((GoFish)game).getTurnController().getHuman().setHand(hHand);
            System.out.println("");
            
            System.out.println("Printing size of deck now.");
            System.out.println(((GoFish)game).getTurnController().getHand().getDeck().getDeck().size());
           
            System.out.println("Printing humans hand");
            Printer.printHand(((GoFish)game).getTurnController().getHuman().getHand());
            System.out.println("");
            
            System.out.println("Setting humans duplicates");
            List<Card> hDupes = ((GoFish)game).getTurnController().getScoreBoard().getDupes(hHand, new ArrayList<>());
            ((GoFish)game).getTurnController().getHuman().setDesirableList(hDupes);
            System.out.println("");
            
            System.out.println("Printing human dupes");
            Printer.printHand( ((GoFish)game).getTurnController().getHuman().getDesirableList());
            System.out.println("");

            //A.2:
           
            System.out.println("Creating and setting computers hand");
            ((GoFish)game).getTurnController().getHand().createHand(7);
            List<Card> cHand = ((GoFish)game).getTurnController().getHand().getHand();
            System.out.println("");

            ((GoFish)game).getTurnController().getComputer().setHand(cHand);
            System.out.println("Printing computers hand");
            Printer.printHand(((GoFish)game).getTurnController().getComputer().getHand());
            System.out.println("");
            
             System.out.println("Printing size of deck now.");
            System.out.println(((GoFish)game).getTurnController().getHand().getDeck().getDeck().size());
            
            System.out.println("Setting computers duplicates");
            List<Card> cDupes = ((GoFish)game).getTurnController().getScoreBoard().getDupes(cHand, new ArrayList<>());
            ((GoFish)game).getTurnController().getComputer().setDesirableList(cDupes);
            System.out.println("");
            
            System.out.println("Printing computer dupes");
            Printer.printHand( ((GoFish)game).getTurnController().getComputer().getDesirableList());
            System.out.println("");

           //C: Start: Coin toss to decide who goes first. 
            System.out.println("Starting the coint toss now.");
            System.out.println("Choose heads or tails");
            String uGuess = UInput.promptStringUser();
            ((GoFish)game).getTurnController().coinToss(uGuess.toLowerCase());
            System.out.println("");
            
            System.out.println("Printing who's in play");
            System.out.println(((GoFish)game).getTurnController().getInPlay().printStats());
            
            System.out.println("Starting first round now.");
            ((GoFish)game).getTurnController().shouldKeepGoing();
            
            
          

        }//End I:*

    }//End M:*

}//End CL:*
