/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.Player;
import java.util.List;

/**
 *
 * @author aleks
 */
public class ScoreBoard {
    public void calcBooks(
            Card tNum,
            List<Card> dupes,
            List<Card> books,
            List<Card> hand
    ) {
        //----
        int ilCount = 0;
        for (int i = 0; i < dupes.size(); i++) {
            //A.3.1: increment counter if already in duplicate list
            if (tNum.equals(dupes.get(i))) {
                ilCount++;
            }//End I:*                    
        }//End F:*
        if (ilCount == 4) {
            books.add(tNum);
            //Notice: should only ever be four of a kind. E.g., standard deck format. 
            for (int j = 0; j < 4; j++) {
                hand.remove(findFirstIndex(tNum, hand));
            }//End I:*                  
        }//End I:*  
    }//End M:*
    
    
     public int findFirstIndex(
            Card tNum,
            List<Card> tList
    ) {
        int pos = 0;
        for (int i = 0; i < tList.size(); i++) {
            if (tNum.equals(tList.get(i))) {
                pos = i;
                return pos;
            }//End I:*
        }//End F:*
        return pos;
    }//End M:*
     
     
       //Define: get a list of duplicate cards. 
    public static void getDupes(
            List<Integer> hand,
            List<Integer> dupes,
            List<Integer> books
    ) {

        //A: main for loop: compare each card to every other card in hand.
        //------------------
        for (int i = 0; i < hand.size(); i++) {
            int lCount = 0;
            //A.1: par two of compare each card to every other card in hand.
            //----
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i).equals(hand.get(j))) {
                    //A.1.1: increase counter if they are equal. 
                    lCount++;
                }//End I:*
            }//End F:*
            //A.2: counter > 1 means theres duplicates.
            //-----
            if (lCount > 1) {
                dupes.add(hand.get(i));
            }//End I:*
        }//End F:*
    }//End M:*

    //Define: under construction...
    public Player determineWinner() {
        return null;
    }//End M:*
    
}//End CL:*
