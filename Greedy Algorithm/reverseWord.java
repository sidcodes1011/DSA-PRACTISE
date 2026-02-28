
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
