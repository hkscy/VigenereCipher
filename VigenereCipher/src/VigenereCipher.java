import java.util.Scanner;

/**
 * Toy Vigenere Cipher implementation
 * Tuesday 28/7/15
 * @author hkscyy
 */
public class VigenereCipher {
	
	static final boolean TEST = true;
	
	public static void main(String args[]) {
		
		AlphabetLUT lut = new AlphabetLUT();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your message to be encrypted: ");
		String plainText = in.nextLine();
		System.out.println("Enter your secret key: ");
		String secretKey = in.nextLine().toLowerCase();
		
		/* Extend the secret key to the same length as the plainText */
		String extrapolatedKey = "";
		for(int i = 0; i < plainText.length(); i+=secretKey.length()) {
			for(int j = 0; j<secretKey.length(); j++) {
				extrapolatedKey += (secretKey.charAt(j)); //- (int)'a');
			}
		}
		if(TEST) System.out.println("Extrapolated key: " + extrapolatedKey);
		
		/* Encrypt the message, using each corresponding key character to index the shift */
		String cipherText = "";
		int keyIndex = 0;
		
		for(int ptIndex = 0; ptIndex < plainText.length(); ptIndex++) {
			if (plainText.substring(ptIndex, ptIndex+1).matches("^[a-zA-Z]")) {
				if(TEST) {
					System.out.print("pt: " + plainText.charAt(ptIndex));
					System.out.print(" key: " + extrapolatedKey.charAt(keyIndex));
					System.out.println(" cipher: " + lut.shiftLetter(plainText.charAt(ptIndex), lut.getIntValueOf(extrapolatedKey.charAt(keyIndex))));
				}	
				cipherText += lut.shiftLetter(plainText.charAt(ptIndex), lut.getIntValueOf(extrapolatedKey.charAt(keyIndex)));
				keyIndex++;
			} else {
				System.out.println("pt = cipher: " + plainText.charAt(ptIndex));
				cipherText += plainText.charAt(ptIndex);
				/* Loop round again using the same key index and encrypt the next plaintext character */
			}
		}
		
		System.out.println("Encrypted text: " + cipherText);
		
		in.close();
	}

}
