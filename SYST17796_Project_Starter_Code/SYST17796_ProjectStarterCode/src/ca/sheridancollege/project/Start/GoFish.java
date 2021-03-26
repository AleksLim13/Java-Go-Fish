package ca.sheridancollege.project.Start;

//Imports:__________________________

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.Hand;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Turns.ScoreBoard;
import ca.sheridancollege.project.Turns.TurnManager;
import ca.sheridancollege.project.Utility.Printer;
import java.util.ArrayList;


/************************************************************
 * @author AllyCat13 @ Sheridan High 2021
 */
/**CLASS OVERVIEW:
 * --------------
 *
 * 
 ***************************************************************/
public class GoFish extends Game {

    private final Player human;
    private final Player computer;
    private final TurnManager turnController;
    private final ScoreBoard scoreBoard;
    private static GoFish game;
   
            
    public GoFish() {
        this.human = new HumanPlayer();
        this.computer = new CompPlayer();
       this.turnController = new TurnManager(
                                             new HumanPlayer(), 
                                             new CompPlayer(),
                                             new ArrayList<>(),
                                             new ArrayList<>(),
                                             new Hand()
                                            ); 
       this.scoreBoard = new ScoreBoard();
       GoFish.game = new GoFish();
       
        
    }//End C:*
    public GoFish(
                  Player human,
                  Player computer,
                  TurnManager turnController
                  ) 
    {
        this.human = human;
        this.computer = computer;
        this.turnController = turnController; 
        this.scoreBoard = new ScoreBoard();
        GoFish.game = new GoFish();

    }//End C:*


    public Player getHuman() {
        return human;
    }

    public Player getComputer() {
        return computer;
    }

    public TurnManager getTurnController() {
        return turnController;
    }

    @Override
    public void play() {

      //A: Setting up hands.
      //A.1: 
      System.out.println("Creating and setting humans hand");
      turnController.getHand().createHand(7);
      human.setHand(turnController.getHand().getHand());
      System.out.println("Printing humans hand");
      Printer.printHand(human.getHand());
      //A.2:
      System.out.println("Creating and setting computers hand");
      turnController.getHand().createHand(7);
      computer.setHand(turnController.getHand().getHand());
      System.out.println("Printing computers hand");
      Printer.printHand(computer.getHand());

      //B: Setting desireable lists. 
      //B.1: 
      System.out.println("Setting humans desirable list");
      human.setDesirableList(scoreBoard.getDupes(human.getHand()));
      System.out.println("Printing humans desirable list");
      Printer.printHand(human.getDesirableList());
      
      //B.2:
      System.out.println("Setting computers desirable list");
      computer.setDesirableList(scoreBoard.getDupes());
      System.out.println("Printing computers desirable list");
      Printer.printHand(computer.getDesirableList());
      
      
      
    }//End M:*
    
    //Define: programs starting point.
    public static void main(String[] args){
        game.play();
    }//End M:*
  
    @Override
    public void declareWinner() {

        //To change body of generated methods, choose Tools | Templates.
    }//End M:*
    
    
}//End Class:________________+

