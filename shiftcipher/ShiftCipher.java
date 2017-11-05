
package shiftcipher;

/**
 *
 * @author Nerys Jimenez
 * The College of Saint Rose
 * Spring 2017, Cybersecurity and Cryptography
 * This Shift Cipher algorithm uses the modulo operator to encrypt messages.
 * The Shift Cipher has a key k, which is an integer from 0 to 25.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ShiftCipher {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        //letter into the number (using list index) that matches its order in the alphabet starting from 0
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("l");
        list.add("m");
        list.add("n");
        list.add("o");
        list.add("p");
        list.add("q");
        list.add("r");
        list.add("s");
        list.add("t");
        list.add("u");
        list.add("v");
        list.add("w");
        list.add("x");
        list.add("y");
        list.add("z");
         
        String m; //gets input message to encrypt
        int k = 1; //gets input key cipher key value
        int y; //Calculate: y = (m + k) mod 26
        String result=""; //final result of the encrypted message
        int index;
        try{
            System.out.println("Cipher Key Value: ");
            k = keyboard.nextInt();
        }catch(InputMismatchException e)
        {
            System.out.println("Key value must be an integer");
            return;
        }
        //error checking: key value must be an int between 0-25
        if(k < 0 || k > 25)
        {
            System.out.println("Key value must be integer between 0-25");
            return;
        }
        System.out.println("Message to Encrypt: ");
        m = keyboard.next();
        
        //error checking: message to encrypt can not contain special characters or uppercase letters
       for(int i = 0; i < m.length(); i++)
       {
           if(m.charAt(i) < 97 || m.charAt(i)> 122)
           {
               System.out.println("Message to Encrypt must contain only lowercase letters");
               return; 
           }
       }
       
       //Shift Ciphers algorithm result = (m + k) mod 26 where m is the numeric value for each letter (index) and k is the key value
       for(int i = 0; i < m.length(); i++)
        {
            index = list.indexOf(Character.toString(m.charAt(i)));
            y = (index + k);
            y = y%26;
           result += list.get(y).toUpperCase(); //by convenction encrypted messages are uppsercase
        }
        System.out.println("Shift Cipher with k = "+k+" and the message "+m+" is: "+result);
    }
    
}
