/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); 
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
	public static boolean isAnagram(String str1, String str2) 
	{
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String sa =RemoveSpace(str1);
		String sb=RemoveSpace(str2);

		if(sa.length() != sb.length())
			{
				return false;
			}
			for (int i = 0; i < sa.length(); i++) {
				int c1 = 0;
				int c2 = 0;
				char ch = sa.charAt(i);
				for (int j = 0; j < sb.length(); j++) {

					if(ch == sb.charAt(j) )
					{
						c1 ++;
					}
					if(ch == sa.charAt(j))
					{
						c2 ++;
					}
				}
				if(c1 != c2)
					return false;
				
		}
		return true;
	}
	public static String RemoveSpace(String str){

		String newt = "";

		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ')
				newt += str.charAt(i);
			
		}
		return newt;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {

		String newt="";
		str= str.toLowerCase();
		for( int i = 0; i< str.length(); i++)
		{
			if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || str.charAt(i) == ' ')
			{
				newt += str.charAt(i);
			}
		}

		return newt;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {

		String newt ="";
		while(str.length() > 0)
		{
			int rnd = (int)(str.length()*Math.random());
			newt += str.charAt(rnd);
			str = str.substring(0, rnd) + str.substring(rnd + 1);
		}
		return newt;
	}
}