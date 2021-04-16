/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.javagofish.InputRules;

/**
 *
 * @author aleks
 */

import java.util.Arrays;
import java.util.List;

/**
 *Input validations in DashBoardController is dependent on this class. There is 5 different
 *ranges of acceptable character sets in here modeled as List constructs. This lets us use the
 *contains Collections method on each character in the input that is stored in the Text Fields.
 *There's a space included in Lower bet and Upper bet because you can provide a full name with
 *a space in between. We don't really need the upper bet because we can just call to lower case
 *on the data in the Text Field. Maybe in the future we will need it. In the future maybe we'll
 *make the user input a valid password or user name when registering and may require them to include
 *a special character so we have a range of those values too. final and static because these are
 *constants and we need it to be a central copy of each.
 *
 *
 *
 *
 * @author AllyCat13.
 *
 */
    public class LangRules

{
	//Recall: calls contains method when checking user input.
    public final static List<Character> lowerBet = Arrays.asList(
                                                                'a', 'b', 'c', 'd', 'e', 'f',
                                                                'g', 'h', 'i', 'j', 'k', 'l',
                                                                 'm', 'n', 'o', 'p', 'q', 'r',
                                                                 's', 't', 'u', 'v', 'w', 'x',
                                                                 'y', 'z', ' '
              			                            );

    //Recall: calls contains method when checking user input.
    public static final List<Character> upperBet = Arrays.asList(
			                                         'A', 'B', 'C', 'D', 'E', 'F',
						                 'G', 'H', 'I', 'J', 'K', 'L',
						                 'M', 'N', 'O', 'P', 'Q', 'R',
					                          'S', 'T', 'U', 'V', 'W', 'X',
					                          'Y', 'Z', ' '
            							);

    //Recall: calls contains method when checking user input.
    public final static List<Character> specialBet = Arrays.asList(
							          '~', '`', '!', '@', '#', '$', '%', '^',
							          '&', '*', '(', ')', '-', '_', '+', '=',
						                  '[', '{', ']', '}', '\\', '|', ';', ':',
						                  '\'', '\"', ',', '<', '.', '>', '?', '/'
    								);

    //Recall: calls contains method when checking user input.
    public final static List<Integer> numberBet = Arrays.asList(
								46, 48, 49, 50, 51, 52, 53,
						                54, 55, 56, 57
    		                                                );

	public LangRules()
	{
		// TODO Auto-generated constructor stub
	}//End M:*

}//End CL:*
