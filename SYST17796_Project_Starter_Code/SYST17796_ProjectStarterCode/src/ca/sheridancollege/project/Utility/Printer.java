/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Utility;
import ca.sheridancollege.project.Cards.Card;

import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Printer {

    public Printer() {
    }

    //Prints deck stoed in this class's deck field var
    //Assumed to be set from actions elsewhere
    public void printDeck(ArrayList<Card> tDeck) {
        for (int i = 0; i < tDeck.size(); i++) {
            System.out.println(tDeck.get(i).getValue() + " " + tDeck.get(i).getSuit());
        }
    }//End method 

    public void printHand(ArrayList<Card> tHand) {
        for (int i = 0; i < tHand.size(); i++) {
            System.out.println(tHand.get(i).getValue() + " " + tHand.get(i).getSuit());
        }
    }//End method 

} //End class
