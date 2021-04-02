package ca.sheridancollege.javagofish.Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Imports:______________________
import ca.sheridancollege.javagofish.Cards.Card;
import java.util.List;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public final class Printer {

    public Printer() {

    }//End C:*

    //Define: general behavior for printing a list of Cards. Hand or deck or book.
    public static void printHand(List<Card> tHand) {
        for (Card c: tHand) {
            System.out.println(c.toString());
        }//End F:*
    }//End method 

} //End class
