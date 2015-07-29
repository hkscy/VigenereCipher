import java.util.HashMap;

/**
 * Alphabet LUT used to map a to 1, b to 2 z to 26 etc
 * Because codepoints and character sets are hard.
 * 
 * @author hkscyy
 * Wednesday 29/09
 */
public class AlphabetLUT {
	
	private HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();
	private HashMap<Integer, Character> _alphabet = new HashMap<Integer, Character>();
	
	/**
	 * Instantiate a hash of the lowercase alphabet
	 */
	public AlphabetLUT() {
		alphabet.put('a', Integer.valueOf(0)); _alphabet.put(Integer.valueOf(0), 'a');
		alphabet.put('b', Integer.valueOf(1)); _alphabet.put(Integer.valueOf(1), 'b');
		alphabet.put('c', Integer.valueOf(2)); _alphabet.put(Integer.valueOf(2), 'c');
		alphabet.put('d', Integer.valueOf(3)); _alphabet.put(Integer.valueOf(3), 'd');
		alphabet.put('e', Integer.valueOf(4)); _alphabet.put(Integer.valueOf(4), 'e');
		alphabet.put('f', Integer.valueOf(5)); _alphabet.put(Integer.valueOf(5), 'f');
		alphabet.put('g', Integer.valueOf(6)); _alphabet.put(Integer.valueOf(6), 'g');
		alphabet.put('h', Integer.valueOf(7)); _alphabet.put(Integer.valueOf(7), 'h');
		alphabet.put('i', Integer.valueOf(8)); _alphabet.put(Integer.valueOf(8), 'i');
		alphabet.put('j', Integer.valueOf(9)); _alphabet.put(Integer.valueOf(9), 'j');
		alphabet.put('k', Integer.valueOf(10)); _alphabet.put(Integer.valueOf(10), 'k');
		alphabet.put('l', Integer.valueOf(11)); _alphabet.put(Integer.valueOf(11), 'l');
		alphabet.put('m', Integer.valueOf(12)); _alphabet.put(Integer.valueOf(12), 'm');
		alphabet.put('n', Integer.valueOf(13)); _alphabet.put(Integer.valueOf(13), 'n');
		alphabet.put('o', Integer.valueOf(14)); _alphabet.put(Integer.valueOf(14), 'o');
		alphabet.put('p', Integer.valueOf(15)); _alphabet.put(Integer.valueOf(15), 'p');
		alphabet.put('q', Integer.valueOf(16)); _alphabet.put(Integer.valueOf(16), 'q');
		alphabet.put('r', Integer.valueOf(17)); _alphabet.put(Integer.valueOf(17), 'r');
		alphabet.put('s', Integer.valueOf(18)); _alphabet.put(Integer.valueOf(18), 's');
		alphabet.put('t', Integer.valueOf(19)); _alphabet.put(Integer.valueOf(19), 't');
		alphabet.put('u', Integer.valueOf(20)); _alphabet.put(Integer.valueOf(20), 'u');
		alphabet.put('v', Integer.valueOf(21)); _alphabet.put(Integer.valueOf(21), 'v');
		alphabet.put('w', Integer.valueOf(22)); _alphabet.put(Integer.valueOf(22), 'w');
		alphabet.put('x', Integer.valueOf(23)); _alphabet.put(Integer.valueOf(23), 'x');
		alphabet.put('y', Integer.valueOf(24)); _alphabet.put(Integer.valueOf(24), 'y');
		alphabet.put('z', Integer.valueOf(25)); _alphabet.put(Integer.valueOf(25), 'z');
	}
	
	/**
	 * Shift a letter by the corresponding number of places in the alphabet
	 * Only shifts a-zA-Z
	 * @param letter letter to be shifted
	 * @param shift number of places to shift (mod 26)
	 * @return the resulting letter
	 */
	Character shiftLetter(char letter, int shift) {
		boolean isLowerCase = Character.isLowerCase(letter);
		Integer input = isLowerCase?
						alphabet.get(letter):
						alphabet.get(Character.toLowerCase(letter));
		Character output = letter;
		if(input != null) {
			input+=shift;
			input%=_alphabet.size();
			output = isLowerCase?
					_alphabet.get(input):
					Character.toUpperCase(_alphabet.get(input));
		} 
		return output;
	}

	/**
	 * Get integer value of given letter. Case insensitive. a-z only.
	 * @param c Letter to check value of.
	 * @return integer value of character.
	 */
	int getIntValueOf(Character c) {
		boolean isLowerCase = Character.isLowerCase(c);
		Integer result = isLowerCase?
						 alphabet.get(c):
						 alphabet.get(Character.toLowerCase(c));
		
		return (result == null)?0:result;
	}

}
