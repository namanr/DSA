public class LongestSubarrayAfterDeletingOne {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCnt = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCnt++;
            }

            while (zeroCnt > 1) {
                if (nums[left] == 0) zeroCnt--;
                left++;
            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
