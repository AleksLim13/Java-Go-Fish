/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gitexer29th;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author aleks
 */
public class InputStuff {
    public double promptDoubleUser(Scanner input){
		boolean continueInput = true;
		double userNum = 0.0;

		do{
			try{

				System.out.println("Enter a double like 3.0");
			    userNum = input.nextDouble();
			    continueInput = false;
			}
			catch (InputMismatchException ex){
				System.out.println("Not a double!");
				input.nextLine();
			}

		}
		while(continueInput);


		return userNum;
	}
	public int promptIntUser(Scanner input){
		boolean continueInput = true;
		int userNum = 0;

		do{
			try{

				System.out.println("Enter a integer like 3");
			    userNum = input.nextInt();
			    continueInput = false;
			}
			catch (InputMismatchException ex){
				System.out.println("Not a Integer!");
				input.nextLine();
			}

		}
		while(continueInput);


		return userNum;
	}
    
        public int validateBwRange(int target){
        boolean flag = true; 
        InputStuff input = new InputStuff();
        while(flag){
            System.out.println("Notice: Cards in a standard deck range from 1-13");
            target = input.promptIntUser(new Scanner(System.in));
            if(target >= 1 && target <= 13){
                flag = false; 
                return target;
            }
        } 
        return target; 
        }    
        
}//end class