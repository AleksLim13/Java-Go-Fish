/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author AllyCat13
 */
public class PseudoCard {

    private String value;
    private String suit;
    public String[] suits = {
                             "HEARTS", 
                             "CLUBS", 
                             "DIAMONDS", 
                             "SPADES"
                            };
    public String[] values = {
                              "ACE", 
                              "TWO", 
                              "THREE", 
                              "FOUR", 
                              "FIVE", 
                              "SIX", 
                              "SEVEN", 
                              "EIGHT", 
                              "NINE", 
                              "TEN",  
                              "JACK", 
                              "QUEEN", 
                              "KING"
                             };
    private List<PseudoCard> pseudoDeck;

    public PseudoCard() 
    {
          this.pseudoDeck = new ArrayList<>();
    }//End C:*
    
    

    public PseudoCard(String value, String suit) 
    {
        this.value = value;
        this.suit = suit;
        this.pseudoDeck = new ArrayList<>();
    }//End C:*

    public List<PseudoCard> createDeck() 
    {
        for (String v : values) {
            for (String s: suits) {
                pseudoDeck.add(new PseudoCard(v, s));
            } //End F:*
        } //End F:*
        return pseudoDeck;
    }//End M:*

    public String getValue() 
    {
        return value;
    }

    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getSuit() 
    {
        return suit;
    }

    public void setSuit(String suit) 
    {
        this.suit = suit;
    }

    public String[] getSuits() 
    {
        return suits;
    }

    public void setSuits(String[] suits) 
    {
        this.suits = suits;
    }

    public String[] getValues() 
    {
        return values;
    }

    public void setValues(String[] values) 
    {
        this.values = values;
    }

    public List<PseudoCard> getPseudoDeck() 
    {
        return pseudoDeck;
    }

    public void setPseudoDeck(List<PseudoCard> pseudoDeck) 
    {
        this.pseudoDeck = pseudoDeck;
    }
    
    @Override
        public boolean equals(Object o) 
        {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) 
            {
                return false;
            }
            PseudoCard theCard = (PseudoCard) o;
            return value.equals(theCard.value) &&
                   suit.equals(theCard.suit);
        }//End M:*

    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.value);
        hash = 23 * hash + Objects.hashCode(this.suit);
        hash = 23 * hash + Arrays.deepHashCode(this.suits);
        hash = 23 * hash + Arrays.deepHashCode(this.values);
        hash = 23 * hash + Objects.hashCode(this.pseudoDeck);
        return hash;
    }

}//End CL:*