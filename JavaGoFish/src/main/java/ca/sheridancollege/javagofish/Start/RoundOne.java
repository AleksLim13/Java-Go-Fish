package ca.sheridancollege.javagofish.Start;


import ca.sheridancollege.javagofish.Utility.Printer;

/**
 * This class contains the steps for a full round of the Go Fish game. 
 * This class extends the Start class and overrides the play method declared in Start.
 * @author AlllyCat13 @ Sheridan High 2021. 
 */
public class RoundOne extends Start {

    /**
     * A reference to a top level Game example.
     * Only one copy is needed and it's state determined once throughout the game.
     */
    
    private final Game game;

    /**
     * Constructs a instance of RoundOne and initializes the Game field.
     * @param game 
     */
    public RoundOne(Game game) 
    {
        this.game = game;
    }//End C:*

    /**
     * Overrides Start play method per the unique steps of a GoFish round.
     * This method creates hands, sets who's in play, and calls keep going method repeatedly. 
     */
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
                
            System.out.println("");
               System.out.println("Calculating books for " + ((GoFish)game)
                           .getTurnController()
                           .getNotInPlay().getName());
               
               
           for(int i = 0; i < ((GoFish)game)
                                            .getTurnController()
                                            .getNotInPlay()
                                                        .getDesirableList()
                                                             .size(); i++)
           {
               
               ((GoFish)game)
                           .getTurnController()
                           .getScoreBoard()
                           .calcBooks(((GoFish)game)
                                                    .getTurnController()
                                                    .getNotInPlay()
                                                    .getDesirableList()
                                                    .get(i), 
                                                     ((GoFish)game)
                                                                   .getTurnController()
                                                                   .getNotInPlay());
           }//End F:*
            }//End W:*
            


        }//End I:*

    }//End M:*
   
}//End CL:*
