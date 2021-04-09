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


    public class CGoFishDeck extends ADeck

{//Start CL:*

    public CGoFishDeck(List<ACard> deck) 
    {
        super(deck);
    }//End C:*

    @Override
    public void initDeck() {
        for (String suitsRange : ACard.suitsRange) 
        {
            for (String valuesRange : ACard.valuesRange) 
            {
                this.deck.add(new CGoFishCard(suitsRange, valuesRange));
            } //End Inner F:*
        } //end outter for   
    }

    @Override
    public void shuffle() 
    
    {
        int rando;
        for (int i = 0; i < this.deck.size(); i++) 
        {
            //A: Create: 
            rando = (int) (Math.random() * this.deck.size());      
            //B: Get:
            ACard temp = this.deck.get(i);
            //C: Set: 
            this.deck.set(i, this.deck.get(rando));
            this.deck.set(rando, temp);         
        }//End Outer F:*
    }

    @Override
    public int findPosit(List<ACard> hand, ACard tCard) 
    
    {
        int posit = 0;
        for (int i = 0; i < hand.size(); i++) 
        {
            if (hand.get(i).equals(tCard)) 
            {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }///End M:*

    @Override
    public List<ACard> removeCard(ACard card) 
    {
        this.deck.remove(findPosit(this.deck, card));
        return this.deck;
    }//End M:*
        
    
}//End CL:*