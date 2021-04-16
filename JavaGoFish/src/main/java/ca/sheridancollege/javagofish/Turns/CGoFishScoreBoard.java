/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.javagofish.Turns;

import ca.sheridancollege.javagofish.Cards.ACard;
import ca.sheridancollege.javagofish.Players.APlayer;
import java.util.ArrayList;
import java.util.List;

/**
 * GOFISHSCOREBOARD CONCRETE CLASS: -------------------------------
 *
 * In any card game, getting multiples of a card value is required for
 * increasing chances of getting a winning hand. Any instance of a ScoreBoard
 * for any card game will need to define how duplicates are calculated. There's
 * not much variation in how duplicate objects in a List are determined in Java.
 * Whatever combination of Card values or suits in a game is the target of the
 * game, there will need to be a dedicated List for recording and updating. The
 * calculate books method in this class does that.
 *
 *
 *
 * @author AlllyCat13.
 */
    public class CGoFishScoreBoard extends AScoreBoard 

{

    public CGoFishScoreBoard() 
    {
        super();
    }//End C:*

    @Override
    public void getDupes(APlayer player) 
    
    {
        try 
        
        {

            player.getDesirableList().clear();

            //A: main for loop: compare each card to every other card in hand.
            for (int i = 0; i < player.getHand().size(); i++) 
            {
                int lCount = 0;
                //A.1: par two of compare each card to every other card in hand.
                //----
                for (int j = 0; j < player.getHand().size(); j++) 
                {
                    //Notice: duplicates determined only by card value.
                    if (player.getHand().get(i).getValue().equals(player.getHand().get(j).getValue())) 
                    {
                        //A.1.1: increase counter if they are equal. 
                        lCount++;
                    }//End I:*
                }//End F:*
                //A.2: counter > 1 means theres duplicates.
                //-----
                //Check: 
                if (lCount > 1) 
                {
                    player.getDesirableList().add(player.getHand().get(i));
                }//End I:*
            }//End F:*    
        }//End TRY:*
        
        catch (IllegalArgumentException e) 
        {
            System.out.println("Player, Player hand, or both are null " + e);
        }//End CAT:*

    }//End M:*

    @Override
    public int findFirstIndex(ACard tNum, List<ACard> tList) 
    {
       try
       {
           int pos = 0;
        for (int i = 0; i < tList.size(); i++) 
        {
            if (tNum.getValue().equals(tList.get(i).getValue())) 
            {
                pos = i;
                return pos;
            }//End I:*
        }//End F:*
        return pos;
       }
       catch(IllegalArgumentException e)
       {
           System.out.println("Could be a bull card, List or both " + e);
       }//End CAT:*
       return -1; 
    }//End M:*

    @Override
    public void calcBooks(ACard tNum, APlayer player) 
    {

        try 
        {
            int ilCount = 0;
            //Repeat: set outer loop. 

            player.setBooks(new ArrayList<>());

            for (int i = 0; i < player.getDesirableList().size(); i++) 
            {
                //A.3.1: Check:
                if (tNum.getValue().equals(player.getDesirableList().get(i).getValue())) 
                {
                    //Increment: counter if already in duplicate list. 
                    ilCount++;
                }//End I:*                    
            }//End F:*

            if (ilCount == 4) 
            {
                //Add: 
                player.getBooks().add(tNum);
                //Notice: should only ever be four of a kind. E.g., standard deck format. 
                for (int j = 0; j < 4; j++) 
                {
                    int pTemp = findFirstIndex(tNum, player.getHand());
                    player.getHand().remove(pTemp);
                }//End I:*  

                for (int j = 0; j < 4; j++) 
                {
                    int pTemp = findFirstIndex(tNum, player.getDesirableList());
                    player.getDesirableList().remove(pTemp);
                }//End I:*  
            }//End I:*     

        }//End TRY:*
        catch (IllegalArgumentException | IndexOutOfBoundsException e) 
        {
            System.out.println("Null values in hand, desirable list, books, or player");
            System.out.println("It coul be a index out of bounds exception");
            System.out.println(e);
        }//End CAT:*

    }//End M:*

    @Override
    public APlayer determineWinner(APlayer human, APlayer computer) 
    {
        try 
        
        {
            if (human.getBooks().size() > computer.getBooks().size()) 
            {
                winner = human;
            }//End I:*
            else 
            {
                winner = computer;
            }//End E:*
            
            return winner;
        } //End TRY:*
        
        catch (IllegalArgumentException e) 
        {
            System.out.println("Player 1, Player 2, their books, or all are null " + e);
        }//End CAT:*
        return null;
    }//End M:*

}//End CL:*
