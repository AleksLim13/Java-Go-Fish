/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.javagofish.Cards;

import java.util.List;

/**
 *
 * GOFISHDECK CONCRETE CLASS:
 * --------------------------
 * 
 * 
 * 
 * 
 * @author AllyCat13 @ Sheridan High 2021.
 */


    public class GoFishDeck extends Deck

{

    public GoFishDeck(List<Card> deck) 
    {
        super(deck);
    }//End C:*

    @Override
    public void initDeck() {
        for (String suitsRange : Card.suitsRange) 
        {
            for (String valuesRange : Card.valuesRange) 
            {
                this.deck.add(new GoFishCard(suitsRange, valuesRange));
            } //End Inner F:*
        } //end outter for   
    }
        
    
}//End CL:*
