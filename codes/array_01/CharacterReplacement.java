public class CharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int[] count = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                count[s.charAt(left) - 'A']--;  // remove left char
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println("Longest substring after replacements: " + maxLen);
    }
}


// public class CharacterReplacement {
//     public static void main(String[] args) {
//         String s = "AABABBA";
//         int k = 1;
//     }
// }
