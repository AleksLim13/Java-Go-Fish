/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Start;

import ca.sheridancollege.project.Utility.Printer;

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
          
            
            //Divide: Part Four:________________________________________________
            System.out.println("");
            System.out.println("Round One");
                    
            //Define: main while loop control structure. Per if deck still had cards.
            while(!((GoFish)game)
                                  .getTurnController()
                                  .getClassHand()
                                  .getDeck()
                                  .getDeck()
                                  .isEmpty()
                    )//End W:*
            {
            
            System.out.println("");
            System.out.println( "[" + ((GoFish)game) 
                                                    .getTurnController()
                                                    .getInPlay()
                                                    .getName() + "]" + " -In Play Hand:");

            
            
            ((GoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((GoFish)game)
                                             .getTurnController()
                                              .getInPlay(), 'h');
            
            Printer.printHand(((GoFish)game)
                                             .getTurnController()
                                             .getInPlay()
                                             .getHand()
                                             );
          
            System.out.println("");
            System.out.println("[" + ((GoFish)game)
                                                   .getTurnController()
                                                   .getInPlay()
                                                   .getName() + "]" + " -In Play Desirable List:");
            
          ((GoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((GoFish)game)
                                             .getTurnController()
                                              .getInPlay(), 'd');
            Printer.printHand(((GoFish)game)
                                             .getTurnController()
                                             .getInPlay()
                                             .getDesirableList()
                                             );
            System.out.println("");
            System.out.println("[" + ((GoFish)game)
                                                   .getTurnController()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Hand:");

            
          ((GoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((GoFish)game)
                                             .getTurnController()
                                              .getNotInPlay(), 'h');
            Printer.printHand(((GoFish)game)
                                             .getTurnController()
                                             .getNotInPlay()
                                             .getHand()
                                             );

            System.out.println("");
            System.out.println("[" + ((GoFish)game)
                                                   .getTurnController()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Desirable List:");
            ((GoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((GoFish)game)
                                             .getTurnController()
                                              .getNotInPlay(), 'd');
         
            Printer.printHand(((GoFish)game)
                                             .getTurnController()
                                             .getNotInPlay()
                                             .getDesirableList()
                                             );
                ((GoFish)game)
                           .getTurnController()
                           .shouldKeepGoing();
                
           
            }//End W:*
            


        }//End I:*

    }//End M:*
   
}//End CL:*
