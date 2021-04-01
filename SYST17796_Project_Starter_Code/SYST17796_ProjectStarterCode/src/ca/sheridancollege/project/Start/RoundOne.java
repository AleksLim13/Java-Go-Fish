/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;




/**
 *
 * @author AlllyCat13 @ Sheridan High 2021. 
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
            //Divide: Part One:_________________________________________________
            
            System.out.println("Creating Hands:");
        
            ((GoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .createHand(7,  ((GoFish)game)
                                                         .getTurnController()
                                                         .getHuman());
         
             ((GoFish)game)
                           .getTurnController()
                           .getClassHand()
                           .createHand(7,  ((GoFish)game)
                                                         .getTurnController()
                                                         .getComputer());
         
            
            
            //Divide: Part Two:_________________________________________________ 
            System.out.println("");
            System.out.println("Creating Duplicate Lists:");
            
            ((GoFish)game)
                         .getTurnController()
                         .getScoreBoard()
                         .getDupes(((GoFish)game)
                                                 .getTurnController()
                                                 .getHuman());
            
           
            
            ((GoFish)game)
                          .getTurnController()
                          .getScoreBoard()
                          .getDupes(((GoFish)game)
                                                  .getTurnController()
                                                  .getComputer());  
             
        
            
            //Divide: Part Three:_______________________________________________
            
            System.out.println("");
            System.out.println("Setting who goes first");
             ((GoFish)game)
                          .getTurnController()
                          .setInPlay(((GoFish)game)
                                                   .getTurnController()
                                                   .getHuman()
                          );//End S:*

            ((GoFish)game)
                          .getTurnController()
                          .setNotInPlay(((GoFish)game)
                                                      .getTurnController()
                                                      .getComputer()
                          );//End S:*
          
            System.out.println("");
            System.out.println( "[" + ((GoFish)game) 
                                                    .getTurnController()
                                                    .getInPlay()
                                                    .getName() + "]" + " -In Play Hand:");

            System.out.println(((GoFish)game)
                                             .getTurnController()
                                             .getInPlay()
                                             .getHand()
                                             .toString());
          
            System.out.println("");
            System.out.println("[" + ((GoFish)game)
                                                   .getTurnController()
                                                   .getInPlay()
                                                   .getName() + "]" + " -In Play Desirable List:");
            System.out.println(((GoFish)game)
                                             .getTurnController()
                                             .getInPlay()
                                             .getDesirableList()
                                             .toString());
            System.out.println("");
            System.out.println("[" + ((GoFish)game)
                                                   .getTurnController()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Hand:");

            System.out.println(((GoFish)game)
                                             .getTurnController()
                                             .getNotInPlay()
                                             .getHand()
                                             .toString());

            System.out.println("");
            System.out.println("[" + ((GoFish)game)
                                                   .getTurnController()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Desirable List:");
            System.out.println(((GoFish)game)
                                             .getTurnController()
                                             .getNotInPlay()
                                             .getDesirableList()
                                             .toString());
            //Divide: Part Four:________________________________________________
            System.out.println("");
            System.out.println("Round One");
             
            ((GoFish)game)
                           .getTurnController()
                           .shouldKeepGoing();


        }//End I:*

    }//End M:*
   
}//End CL:*
