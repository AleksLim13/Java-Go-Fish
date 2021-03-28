/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;


import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author aleks
 */
public class RoundOne extends Start {

    
    
    private Game game;

    public RoundOne(Game game) {
        this.game = game;
    }//End C:*

    @Override
    public void play() {
    
        if (game instanceof GoFish) {
        
         List<Card> hHand = ((GoFish)game).getTurnController().getClassHand().createHand(7, new ArrayList<>());
         List<Card> cHand = ((GoFish)game).getTurnController().getClassHand().createHand(7, new ArrayList<>());
         
         ((GoFish)game).getTurnController().getHuman().setHand(hHand);
         ((GoFish)game).getTurnController().getComputer().setHand(cHand);
         
          ((GoFish)game).getTurnController().setInPlay(((GoFish)game).getTurnController().getHuman());
          ((GoFish)game).getTurnController().setNotInPlay(((GoFish)game).getTurnController().getComputer());

            System.out.println(((GoFish)game).getTurnController().getInPlay().getHand().toString());
          
            System.out.println(((GoFish)game).getTurnController().getNotInPlay().getHand().toString());


        }//End I:*

    }//End M:*
    
    

}//End CL:*
