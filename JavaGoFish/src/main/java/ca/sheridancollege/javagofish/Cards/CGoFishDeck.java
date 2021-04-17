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
 * This is a concrete class. It's the implementation for ADeck. It is a example of ADeck. In this
 * case it is a Go Fish Deck. I added some exception handling for best and worst case scenarios.
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
    public void initDeck() 
    {
        try 
        {
            for (String suitsRange : ACard.suitsRange) 
            {
                for (String valuesRange : ACard.valuesRange) 
                {
                    this.deck.add(new CGoFishCard(suitsRange, valuesRange));
                } //End Inner F:*
            } //end outter for   
        }//End TRY:*
        catch (NullPointerException | ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("The deck field could be null or accessing the index failed " + e);
        }//End CAT:*

    }//End M:*

    @Override
    public void shuffle() 
    {
        try 
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
        
        catch (NullPointerException | ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("Has the deck field being initialized. Are array counters set properly");
            System.out.println(e);
        }//End CAT:*

    }//End M:*

}//End CL:*
