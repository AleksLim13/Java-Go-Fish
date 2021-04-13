package ca.sheridancollege.javagofish.Start;


import ca.sheridancollege.javagofish.Utility.Printer;

/**
 * This class contains the steps for a full round of the Go Fish game. 
 * This class extends the Start class and overrides the play method declared in Start.
 * @author AlllyCat13 @ Sheridan High 2021. 
 */
public class CRoundOne extends AStart 

{

    /**
     * A reference to a top level Game example.
     * Only one copy is needed and it's state determined once throughout the game.
     */
    
    

    /**
     * Constructs a instance of RoundOne and initializes the Game field.
     * @param game 
     */
    public CRoundOne(AGame game) 
    {
        super(game);
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
                          .getTM()
                          .getClassHand()
                          .createHand(7,  ((CGoFish)game)
                                                         .getTM()
                                                         .getHuman());
         
             ((CGoFish)game)
                           .getTM()
                           .getClassHand()
                           .createHand(7,  ((CGoFish)game)
                                                         .getTM()
                                                         .getComputer());
         
            
            
            //Divide: Part Two:_________________________________________________ 
            System.out.println("");
            System.out.println("Creating Duplicate Lists:");
            
            ((CGoFish)game)
                         .getTM()
                         .getScoreBoard()
                         .getDupes(((CGoFish)game)
                                                 .getTM()
                                                 .getHuman());
            
           
            
            ((CGoFish)game)
                          .getTM()
                          .getScoreBoard()
                          .getDupes(((CGoFish)game)
                                                  .getTM()
                                                  .getComputer());  
             
        
            
            //Divide: Part Three:_______________________________________________
            
            System.out.println("");
            System.out.println("Setting who goes first");
             ((CGoFish)game)
                          .getTM()
                          .setInPlay(((CGoFish)game)
                                                   .getTM()
                                                   .getHuman()
                          );//End S:*

            ((CGoFish)game)
                          .getTM()
                          .setNotInPlay(((CGoFish)game)
                                                      .getTM()
                                                      .getComputer()
                          );//End S:*
          
            
            //Divide: Part Four:________________________________________________
            System.out.println("");
            System.out.println("Round One");
                    
            //Define: main while loop control structure. Per if deck still had cards.
            while(!((CGoFish)game)
                                  .getTM()
                                  .getClassHand()
                                  .getClassDeck()
                                  .getDeck()
                                  .isEmpty()
                    )//End W:*
            {
            
            System.out.println("");
            System.out.println( "[" + ((CGoFish)game) 
                                                    .getTM()
                                                    .getInPlay()
                                                    .getName() + "]" + " -In Play Hand:");

            
            
            ((CGoFish)game)
                          .getTM()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTM()
                                              .getInPlay(), 'h');
            
            Printer.printHand(((CGoFish)game)
                                             .getTM()
                                             .getInPlay()
                                             .getHand()
                                             );
          
            System.out.println("");
            System.out.println("[" + ((CGoFish)game)
                                                   .getTM()
                                                   .getInPlay()
                                                   .getName() + "]" + " -In Play Desirable List:");
            
          ((CGoFish)game)
                          .getTM()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTM()
                                              .getInPlay(), 'd');
            Printer.printHand(((CGoFish)game)
                                             .getTM()
                                             .getInPlay()
                                             .getDesirableList()
                                             );
            System.out.println("");
            System.out.println("[" + ((CGoFish)game)
                                                   .getTM()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Hand:");

            
          ((CGoFish)game)
                          .getTM()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTM()
                                              .getNotInPlay(), 'h');
            Printer.printHand(((CGoFish)game)
                                             .getTM()
                                             .getNotInPlay()
                                             .getHand()
                                             );

            System.out.println("");
            System.out.println("[" + ((CGoFish)game)
                                                   .getTM()
                                                   .getNotInPlay()
                                                   .getName() + "]" + " -Not In Play Desirable List:");
            ((CGoFish)game)
                          .getTM()
                          .getClassHand()
                          .sort(((CGoFish)game)
                                             .getTM()
                                              .getNotInPlay(), 'd');
         
            Printer.printHand(((CGoFish)game)
                                             .getTM()
                                             .getNotInPlay()
                                             .getDesirableList()
                                             );
                ((CGoFish)game)
                           .getTM()
                           .shouldKeepGoing();
                
            System.out.println("");
               System.out.println("Calculating books for " + ((CGoFish)game)
                           .getTM()
                           .getNotInPlay().getName());
               
               
           for(int i = 0; i < ((CGoFish)game)
                                            .getTM()
                                            .getNotInPlay()
                                                        .getDesirableList()
                                                             .size(); i++)
           {
               
               ((CGoFish)game)
                           .getTM()
                           .getScoreBoard()
                           .calcBooks(((CGoFish)game)
                                                    .getTM()
                                                    .getNotInPlay()
                                                    .getDesirableList()
                                                    .get(i), 
                                                     ((CGoFish)game)
                                                                   .getTM()
                                                                   .getNotInPlay());
           }//End F:*
            }//End W:*
            
            System.out.println("Deck is empty. Determining winner now");
            ((CGoFish)game)
                           .getTM()
                           .getScoreBoard()
                           .determineWinner(
                                             ((CGoFish)game)
                                                .getTM()
                                                .getHuman(), ((CGoFish)game)
                                                                .getTM()
                                                                .getComputer());
            

        }//End I:*

    }//End M:*
   
}//End CL:*
