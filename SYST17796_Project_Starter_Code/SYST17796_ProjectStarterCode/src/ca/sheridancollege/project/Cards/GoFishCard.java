/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Cards;

/**
 *
 * @author aleks
 */
public class GoFishCard extends Card{
    
    public GoFishCard(){
    super(Suit.DEFAULT, Value.DEFAULT);
    }//End C:*
    public GoFishCard(Suit suit, Value value){
      super(suit, value);
    }//End C:*

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}//End Class:__________________+
