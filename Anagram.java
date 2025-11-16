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
    String cleanStr1 = preProcess(str1);//משתמש בפונקציית עיבוד
    String cleanStr2 = preProcess(str2);
    
    // אם האורכים שונים, הן לא יכולות להיות אנגרמות
    if (cleanStr1.length() != cleanStr2.length()) {
        return false;
    }
    
    // 3. המרה למערך תווים)
    char[] charArray1 = cleanStr1.toCharArray();
    char[] charArray2 = cleanStr2.toCharArray();

    StringBuilder tempStr2 = new StringBuilder(cleanStr2);
    
    // עוברים על כל תו במחרוזת הראשונה )
    for (int i = 0; i < cleanStr1.length(); i++) {
        char ch1 = cleanStr1.charAt(i);
        boolean found = false;
        
        // עוברים על המחרוזת השנייה )
        for (int j = 0; j < tempStr2.length(); j++) {
            if (ch1 == tempStr2.charAt(j)) {
                // מצאנו התאמה!
                tempStr2.deleteCharAt(j); // מוחקים את התו כדי שלא ייבחר שוב
                found = true;
                break; // עוברים לתו הבא במחרוזת הראשונה
            }
        }
        
        // אם התו לא נמצא במחרוזת השנייה (או נמחק כבר), הן לא אנגרמות
        if (!found) {
            return false;
        }
    }
    
    return true; 
}
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
    String result = ""; //המחרוזת החדשה
    for (int i = 0; i < str.length(); i++) // רץ על כל תו
	 {
        char ch = str.charAt(i);
        char lowerCaseCh = Character.toLowerCase(ch);
        if (Character.isLetter(lowerCaseCh))  // אם מדובר באות
		{
            result = result + lowerCaseCh;
        }
    }
    
    return result;
}
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
    StringBuilder source = new StringBuilder(str);//מאפשר למחוק תוים מהמחרוזת
    String result = ""; // המחרוזת החדשה מתחילה ריקה
    java.util.Random generator = new java.util.Random(); // ליצור מספרים אקראיים
    int length = str.length();
    for (int i = 0; i < length; i++) // עבור כל תו במחרוזת המקורית
	{
        int randomIndex = generator.nextInt(source.length());// בחירת אינדקס אקראי
        char randomChar = source.charAt(randomIndex);
        result += randomChar;// להוסיף את התו למחרוזת החדשה
        source.deleteCharAt(randomIndex);//מוריד את התו מהמקור
    }
    return result;
}
}