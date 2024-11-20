/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  



	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean result = true;
		str1 = preProcess(str1);
		str2 = preProcess(str2);
	
		if (str1.length() != str2.length()) {
			result = false;
		} else {
			for (int i = 0; i < str1.length(); i++) {
				boolean matchFound = false;
				for (int u = 0; u < str2.length(); u++) {
					if (str1.charAt(i) == str2.charAt(u)) {
						matchFound = true;
						str2 = str2.substring(0, u) + str2.substring(u + 1); 
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
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str=str.replaceAll("[^a-zA-Z]", "").toLowerCase();
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);  
		StringBuilder str1 = new StringBuilder(str);
		
		for (int i = 0; i < str.length(); i++) 
		{
			int random = (int)(Math.random() * str.length());
			while (str1.charAt(random) == ' ')
			 {
				random = (int)(Math.random() * str.length()); 
			}	
			str1.setCharAt(i, str1.charAt(random));
		}
		return str1.toString();
	}
	}