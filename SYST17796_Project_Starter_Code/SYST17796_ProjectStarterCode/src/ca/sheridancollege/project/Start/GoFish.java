package ca.sheridancollege.project.Start;

//Imports:__________________________

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Turns.Dealer;
import ca.sheridancollege.project.Turns.Deck;
import ca.sheridancollege.project.Turns.ScoreBoard;
import ca.sheridancollege.project.Turns.TurnManager;
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

    private final Dealer dealer; 
    private final Player human;
    private final Player computer;
    private final TurnManager turnController;
    private final ScoreBoard scoreBoard;
   
            
    public GoFish(     String hName,
                       ArrayList<Card> hand,
                       ArrayList<Card> desirableList,
                       String cName,
                       TurnManager turnController) {
        super("Go Fish");
        this.dealer = new Dealer(new Deck(), new ArrayList<>());
        this.human = new HumanPlayer();
        this.computer = new CompPlayer();
       this.turnController = turnController; 
       this.scoreBoard = new ScoreBoard();
        
    }//End C:*
    public GoFish(
                  Dealer dealer,
                  Player human,
                  Player computer,
                  TurnManager turnController
                  ) {
        super("Go Fish");
        this.dealer = dealer;
        this.human = human;
        this.computer = computer;
        this.turnController = turnController; 
        this.scoreBoard = new ScoreBoard();

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

    public TurnManager getTurnController() {
        return turnController;
    }

    @Override
    public void play() {

      //A: Setting up hands.
      dealer.createHand(7);
      human.setHand(dealer.getHand());
      
      dealer.createHand(7);
      computer.setHand(dealer.getHand());
      
      //B: Setting desireable lists. 
      human.setDesirableList(scoreBoard.getDupes(human.getHand()));
      computer.setDesirableList(scoreBoard.getDupes());
      
    }//End M:*
  
    @Override
    public void declareWinner() {

        //To change body of generated methods, choose Tools | Templates.
    }//End M:*
    
    
}//End Class:________________+

