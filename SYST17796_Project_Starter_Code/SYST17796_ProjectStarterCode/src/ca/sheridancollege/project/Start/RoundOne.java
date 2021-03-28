/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;


import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author aleks
 */
public class RoundOne extends Start {

    private Player human;
    private Player computer;
    private Player inPlay;
    private Player notInPlay;
    
    private Game game;

    public RoundOne(Game game) {
        this.game = game;
    }//End C:*

    @Override
    public void play() {
    
        if (game instanceof GoFish) {
        
         
            this.human = new HumanPlayer("Aleks");
            this.computer = new CompPlayer();
            
            List<Card> hHand = ((GoFish)game).getTurnController().getHand().createHand(7, new ArrayList<>());
            this.human.setHand(hHand);
            System.out.println(this.human.getHand().toString());
         
            
            
            List<Card> cHand = ((GoFish)game).getTurnController().getHand().createHand(7, new ArrayList<>());
            this.computer.setHand(cHand);
            System.out.println(this.computer.getHand().toString());

            this.inPlay = this.human;
            this.notInPlay = this.computer;
            
            System.out.println(this.inPlay.getHand().toString());
            System.out.println(this.notInPlay.getHand().toString());

            
            //his.human.setHand(((GoFish)game).getTurnController().getHand().getHand());
            
           // ((GoFish)game).getTurnController().getHand().createHand(7);
           // this.computer.setHand(((GoFish)game).getTurnController().getHand().getHand());
            
         
            
            //System.out.println(this.human.getHand().toString());
           // System.out.println(this.computer.getHand().toString());
           
        }//End I:*

    }//End M:*
    
    

}//End CL:*
