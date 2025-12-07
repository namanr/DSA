public class Solution {
    public int longestSubstring(String s, int k, int m) {

        int[] freq = new int[26];      // frequency of chars in window
        int excess = 0;                // characters above m inside window
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {

            int c = s.charAt(right) - 'a';

            // Increase frequency of this character in window
            freq[c]++;

            // If freq[c] just moved from m to m+1, that adds ONE new excess
            if (freq[c] == m + 1) {
                excess++;
            }

            // SHRINK WINDOW while total excess > k
            while (excess > k) {

                int leftChar = s.charAt(left) - 'a';

                // If this leftChar was an extra, removing it reduces excess
                if (freq[leftChar] == m + 1) {
                    excess--;
                }

                freq[leftChar]--;
                left++;
            }

            // Now window [left..right] is valid
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
