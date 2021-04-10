package ca.sheridancollege.javagofish.Start;

import ca.sheridancollege.javagofish.Turns.ATurnManager;

/**
 * AGAME ABSTRACT CLASS:
 * ---------------------
 * 
 * 
 * A top level class for modeling generic card games. We'll subtype other Game objects from this class 
 * making this a template then. We may have Black Jack and Rummy in the future. We could be asked to make 
 * another card game and we don't want to start from scratch. So, we abstract common attributes among card
 * games here. Not right now, that will be expanded on later. For now it's just a class we designated
 * as the Game template. An instance like Black Jack or Big Two can extend this class. 
 * 
 * 
 * 
 * @author AllyCat13 : Sheridan High 2021. 
 */

    public abstract class AGame 

{
        /**
         * A game needs a Turn Manager who directs all components.
         */
        protected final ATurnManager tM;
    
    /**
     * Basic constructor for creating a game example. 
     * @param tM
     */
        
        
    public AGame(ATurnManager tM)
    {
        this.tM = tM;
    }//End C:*

    public ATurnManager getTM() 
    {
        return tM;
    }//End G:*
    
    
   
}//End class
