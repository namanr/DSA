public class SubarraySumPositive {
    public int countSubarrays(int[] nums, int k) {
        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                count++;
            }

            if (left > right) {
                left = right + 1;
                sum = 0;
            }
        }

        return count;
    }
}
