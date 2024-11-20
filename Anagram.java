public class Anagram {
	public static void main(String args[]) {
		System.out.println(isAnagram("silent", "listen"));
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller"));
		System.out.println(isAnagram("Madam Curie", "Radium came"));
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
		System.out.println(preProcess("What? No way!!!"));
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		String str = "1234567";
		boolean pass = true;
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test failed");
	}

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

	public static String preProcess(String str) {
		String processed = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				processed += (char) (c + ('a' - 'A'));
			} else if ((c >= 'a' && c <= 'z') || c == ' ') {
				processed += c;
			}
		}
		return processed;
	}

	public static String randomAnagram(String str) {
		str = preProcess(str);
		String result = "";
		String spaces = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				spaces += i + ",";
			}
		}

		str = str.replace(" ", "");

		while (str.length() > 0) {
			int random = (int) (Math.random() * str.length());
			result += str.charAt(random);
			str = str.substring(0, random) + str.substring(random + 1);
		}

		if (!spaces.isEmpty()) {
			String[] spacePositions = spaces.split(",");
			for (int i = 0; i < spacePositions.length; i++) {
				int pos = Integer.parseInt(spacePositions[i]);
				result = result.substring(0, pos) + " " + result.substring(pos);
			}
		}

		return result;
	}
}
