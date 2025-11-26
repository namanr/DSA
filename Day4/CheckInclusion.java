public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;

            if (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == s1.length()) {
                if (java.util.Arrays.equals(need, window)) return true;
            }
        }

        return false;
    }
}
