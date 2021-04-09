package ca.sheridancollege.javagofish.Start;


import ca.sheridancollege.javagofish.Utility.Printer;

/**
 * This class contains the steps for a full round of the Go Fish game. 
 * This class extends the Start class and overrides the play method declared in Start.
 * @author AlllyCat13 @ Sheridan High 2021. 
 */
public class CRoundOne extends AStart {

    /**
     * A reference to a top level Game example.
     * Only one copy is needed and it's state determined once throughout the game.
     */
    
    private final AGame game;

    /**
     * Constructs a instance of RoundOne and initializes the Game field.
     * @param game 
     */
    public CRoundOne(AGame game) 
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
    
        if (game instanceof CGoFish) 
        {
            //Divide: Part One:_________________________________________________
            
            System.out.println("Creating Hands:");
        
            ((CGoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .createHand(7,  ((CGoFish)game)
                                                         .getTurnController()
                                                         .getHuman());
         
             ((CGoFish)game)
                           .getTurnController()
                           .getClassHand()
                           .createHand(7,  ((CGoFish)game)
                                                         .getTurnController()
                                                         .getComputer());
         
            
            
            //Divide: Part Two:_________________________________________________ 
            System.out.println("");
            System.out.println("Creating Duplicate Lists:");
            
            ((CGoFish)game)
                         .getTurnController()
                         .getScoreBoard()
                         .getDupes(((CGoFish)game)
                                                 .getTurnController()
                                                 .getHuman());
            
           
            
            ((CGoFish)game)
                          .getTurnController()
                          .getScoreBoard()
                          .getDupes(((CGoFish)game)
                                                  .getTurnController()
                                                  .getComputer());  
             
        
            
            //Divide: Part Three:_______________________________________________
            
            System.out.println("");
            System.out.println("Setting who goes first");
             ((CGoFish)game)
                          .getTurnController()
                          .setInPlay(((CGoFish)game)
                                                   .getTurnController()
                                                   .getHuman()
                          );//End S:*

            ((CGoFish)game)
                          .getTurnController()
                          .setNotInPlay(((CGoFish)game)
                                                      .getTurnController()
                                                      .getComputer()
                          );//End S:*
          
            
            //Divide: Part Four:________________________________________________
            System.out.println("");
            System.out.println("Round One");
                    
            //Define: main while loop control structure. Per if deck still had cards.
            while(!((CGoFish)game)
                                  .getTurnController()
                                  .getClassHand()
                                  .getClassDeck()
                                  .getDeck()
                                  .isEmpty()
                    )//End W:*
            {
            
            System.out.println("");
            System.out.println( "[" + ((CGoFish)game) 
                                                    .getTurnController()
                                                    .getInPlay()
                                                    .getName() + "]" + " -In Play Hand:");

            
            
            ((CGoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTurnController()
                                              .getInPlay(), 'h');
            
            Printer.printHand(((CGoFish)game)
                                             .getTurnController()
                                             .getInPlay()
                                             .getHand()
                                             );
          
            System.out.println("");
            System.out.println("[" + ((CGoFish)game)
                                                   .getTurnController()
                                                   .getInPlay()
                                                   .getName() + "]" + " -In Play Desirable List:");
            
          ((CGoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTurnController()
                                              .getInPlay(), 'd');
            Printer.printHand(((CGoFish)game)
                                             .getTurnController()
                                             .getInPlay()
                                             .getDesirableList()
                                             );
            System.out.println("");
            System.out.println("[" + ((CGoFish)game)
                                                   .getTurnController()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Hand:");

            
          ((CGoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTurnController()
                                              .getNotInPlay(), 'h');
            Printer.printHand(((CGoFish)game)
                                             .getTurnController()
                                             .getNotInPlay()
                                             .getHand()
                                             );

            System.out.println("");
            System.out.println("[" + ((CGoFish)game)
                                                   .getTurnController()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Desirable List:");
            ((CGoFish)game)
                          .getTurnController()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTurnController()
                                              .getNotInPlay(), 'd');
         
            Printer.printHand(((CGoFish)game)
                                             .getTurnController()
                                             .getNotInPlay()
                                             .getDesirableList()
                                             );
                ((CGoFish)game)
                           .getTurnController()
                           .shouldKeepGoing();
                
            System.out.println("");
               System.out.println("Calculating books for " + ((CGoFish)game)
                           .getTurnController()
                           .getNotInPlay().getName());
               
               
           for(int i = 0; i < ((CGoFish)game)
                                            .getTurnController()
                                            .getNotInPlay()
                                                        .getDesirableList()
                                                             .size(); i++)
           {
               
               ((CGoFish)game)
                           .getTurnController()
                           .getScoreBoard()
                           .calcBooks(((CGoFish)game)
                                                    .getTurnController()
                                                    .getNotInPlay()
                                                    .getDesirableList()
                                                    .get(i), 
                                                     ((CGoFish)game)
                                                                   .getTurnController()
                                                                   .getNotInPlay());
           }//End F:*
            }//End W:*
            


        }//End I:*

    }//End M:*
   
}//End CL:*
