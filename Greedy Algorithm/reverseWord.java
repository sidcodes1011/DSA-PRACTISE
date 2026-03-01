// Question 

// Given a string s, reverse the string without reversing its individual words. Words are separated by dots(.).

// Note: The string may contain leading or trailing dots(.) or multiple dots(.) between two words. 
// The returned string should only have a single dot(.) separating the words, and no extra dots should be included.

public class reverseWord {
    
     public String reverseWordsAlgorithm(String s) {

        String[] parts = s.split("\\.");
        StringBuilder result = new StringBuilder();

        for (int i = parts.length - 1; i >= 0; i--) {

            if (!parts[i].isEmpty()) {
                if (result.length() > 0) {
                    result.append(".");
                }
                result.append(parts[i]);
            }
        }
        return result.toString();
    }
}
