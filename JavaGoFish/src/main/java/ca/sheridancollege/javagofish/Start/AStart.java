package ca.sheridancollege.javagofish.Start;

/**
 * ASTART ABSTRACT CLASS:
 * ----------------------
 * 
 * This class models how a Game starts and plays. Every game has to play and have steps
 * for how the game will achieve this. We factored that common behavior from games in general in
 * this broad class category. Each instance of this class will define the way that the particular 
 * game plays. The main program steps for seeing which player can get the most four of a
 * kinds by conducting mental arithmetic on cards in their head will be defined in the 
 * play method in the extending class. These steps will naturally use all program components 
 * together inside the play methods block. Once again, if we're asked later to make another
 * game with similar but different card logic we won't have to recreate everything that is 
 * similar for card games starting.
 * 
 * 
 * @author AllyCat13 : Sheridan High 2021.
 */
public abstract class AStart 

{
     //Define: programs starting point.
    
    /**
     * This method is where the programs overall steps will be defined.
     */
    public abstract void play();
   
}//End CL:*
