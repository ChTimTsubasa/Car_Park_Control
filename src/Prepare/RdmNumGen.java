/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prepare;

import java.util.Random;

/**
 * generate a random String with given length
 * @author Tianyi Chen
 * @author Yuzhe Zhang
 * @version 2015-5-8
 */
public class RdmNumGen {
     /**
     * try times for regenerating
     */
    public final static int RDM_TRY_TIMES=10000;
    
    /**
     * the pure number elements to generate random string
     */
    
    public final static char[] NUM_ELMNT = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    /**
     * this is a method to generate random String
     * @param length
     * @param elements
     * @return a random String generate in length
     */
    public static String rdmGenerate(int length, char[] elements){
        int  bound = RdmNumGen.NUM_ELMNT.length;
        int i;  //the ramdom n
        int count = 0; //length of random chars
        StringBuilder tmpString = new StringBuilder("");
        Random r = new Random();
        while(count < length){
        i = Math.abs(r.nextInt(bound));  //generate a random number
        if (i >= 0 && i < bound) {       //check if it is in the element list
            tmpString.append(elements[i]);
            count ++;
        }
        }
        return tmpString.toString();
    }
}
