/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.javagofish.Turns;

import ca.sheridancollege.javagofish.Cards.AHand;
import ca.sheridancollege.javagofish.Players.APlayer;

/**
 *
 * @author aleks
 */
public class CGoFishTurnManager extends TurnManager
{

    public CGoFishTurnManager(APlayer human, APlayer computer, AHand hand, AScoreBoard scoreBoard) 
    
    {
        super(human, computer, hand, scoreBoard);
    }//End M:*
    
}//End CL:*
