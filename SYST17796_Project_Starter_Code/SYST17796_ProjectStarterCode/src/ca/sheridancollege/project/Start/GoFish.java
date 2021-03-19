package ca.sheridancollege.project.Start;

//Imports:__________________________

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Turns.Dealer;
import ca.sheridancollege.project.Turns.Deck;
import ca.sheridancollege.project.Turns.TurnSwitcher;
import ca.sheridancollege.project.Utility.Printer;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class GoFish extends Game {

    private final Dealer dealer; 
    private final Player human;
    private final Player computer;
    private final TurnSwitcher turnController;
    private int[][] books = new int[4][2];
            
    public GoFish(     String hName,
                       ArrayList<Card> hand,
                       int[][] books,
                       ArrayList<Card> desirableList,
                       String cName,
                       TurnSwitcher turnController) {
        super("Go Fish");
        this.dealer = new Dealer(new Deck(), new ArrayList<>());
        this.human = new HumanPlayer(
                       hName,
                       hand,
                       books,
                       desirableList
                      );
        this.computer = new CompPlayer(
                                       cName,
                                       hand,
                                       books,
                                       desirableList
                                       );
       this.turnController = turnController; 
        
    }//End C:*
    public GoFish(
                  Dealer dealer,
                  Player human,
                  Player computer,
                  TurnSwitcher turnController
                  ) {
        super("Go Fish");
        this.dealer = dealer;
        this.human = human;
        this.computer = computer;
        this.turnController = turnController; 
    }//End C:*

    public Dealer getDealer() {
        return dealer;
    }

    public Player getHuman() {
        return human;
    }

    public Player getComputer() {
        return computer;
    }

    public TurnSwitcher getTurnController() {
        return turnController;
    }

    
    @Override
    public void play() {

        System.out.println("Dealer creating a hand");
        this.dealer.createHand(7);
        
        System.out.println("Dealer setting humans hand");
        this.human.setHand(this.dealer.getHand());
        
        System.out.println("Printing humans hand");
        Printer.printHand(this.human.getHand());
        
        System.out.println("Creating humans scorebord");
        this.dealer.createScoreBoard();
        
        System.out.println("Setting humans scorebord");
        this.human.setScoreBoard(this.dealer.getScoreBoard());
        
        System.out.println("Printing humans scorebord");
      
        
        System.out.println("Dealer creating a hand");
        this.dealer.createHand(7);
        
        System.out.println("Dealer setting computers hand");
        this.computer.setHand(this.dealer.getHand());
        
        System.out.println("Printing computers hand");
        Printer.printHand(this.computer.getHand());
        
        System.out.println("Creating computers scorebord");
        this.dealer.createScoreBoard();
        
        System.out.println("Setting computers scorebord");
        this.computer.setScoreBoard(this.dealer.getScoreBoard());
        
        //To change body of generated methods, choose Tools | Templates.
        System.out.println("Printing computers scorebord");
       
    }//End M:*

    @Override
    public void declareWinner() {

        //To change body of generated methods, choose Tools | Templates.
    }//End M:*
    
    


}//End Class:________________+
