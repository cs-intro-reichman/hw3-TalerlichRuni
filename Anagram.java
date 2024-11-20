/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen"));  // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram 
		String str = "1234567";
		boolean pass = true;
		// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean result = true;
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		if (str1.length() != str2.length()) {
			result = false;
		} else {
			while (str1.length() > 0) {
				char c = str1.charAt(0);
				boolean matchFound = false;
				for (int i = 0; i < str2.length(); i++) {
					if (str2.charAt(i) == c) {
						str2 = str2.substring(0, i) + str2.substring(i + 1);
						str1 = str1.substring(1);
						matchFound = true;
						break;
					}
				}
				if (!matchFound) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. 
	public static String preProcess(String str) {
		String processed = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				processed += (char) (c + ('a' - 'A'));
			} else if (c >= 'a' && c <= 'z') {
				processed += c;
			}
		}
		return processed;
	}

	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String result = "";

		while (str.length() > 0) {
			int random = (int) (Math.random() * str.length());
			result += str.charAt(random);
			str = str.substring(0, random) + str.substring(random + 1);
		}
		return result;
	}
}
