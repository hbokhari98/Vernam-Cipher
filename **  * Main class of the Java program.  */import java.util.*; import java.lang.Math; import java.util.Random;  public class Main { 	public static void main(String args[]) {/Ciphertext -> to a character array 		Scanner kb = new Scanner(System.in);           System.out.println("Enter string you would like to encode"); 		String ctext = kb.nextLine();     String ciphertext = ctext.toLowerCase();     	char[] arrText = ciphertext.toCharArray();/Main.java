import java.util.*;
import java.lang.Math;
import java.util.Random;

public class Main {
	public static void main(String args[]) {
		// Ciphertext -> to a character array
		Scanner kb = new Scanner(System.in);  
        System.out.println("Enter string you would like to encode");
		String ctext = kb.nextLine();
    String ciphertext = ctext.toLowerCase();
    	char[] arrText = ciphertext.toCharArray();

		// This would be our vernam cipher (should be same length as our text)
		System.out.println("This is our secret generated key");
		char [] key = new char[arrText.length];
		for(int i=0;i<arrText.length;i++){
		    Random rnd = new Random();
            key[i] = (char) (rnd.nextInt(26) + 'A');
            System.out.print(key[i]);
		}
        System.out.println("");
		// Array to hold our encryption (again same length)
		char[] encoded = new char[arrText.length];

		// Encrypt the text by using XOR (exclusive OR) each character of our text against cipher.
    /*Bitwise XOR (exclusive or) "^" is an operator in Java that provides the answer '1' if both of the bits in its operands are different, if both of the bits are same then the XOR operator gives the result '0'. XOR is a binary operator that is evaluated from left to right. The operator "^" is undefined for the argument of type String.*/

		System.out.println("Encoded " + ciphertext + " to be... ");
		for (int i = 0; i < arrText.length; i++) {
			encoded[i] =  (char) (arrText[i] ^ key[i]);
			System.out.print(encoded[i]);
		}

		System.out.println("\nDecoded to be... ");

		// Run through the encrypted text and against the cipher again this decrypts the text.
		for (int i = 0; i < encoded.length; i++) {
			char temp = (char) (encoded[i] ^ key[i]);
			System.out.print(temp);
		}
	 }
}
