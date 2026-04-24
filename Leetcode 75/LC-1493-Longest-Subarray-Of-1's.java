class Solution {
    public int longestSubarray(int[] nums) {
        // if the second 0 is encountered then set the zero count to 1
        int j = 0, zeroCount = 0;
        int maxLength = 0; // storing the max length

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;

            // if the count of the 0 is more than 1
            while (zeroCount > 1) {
                if (nums[j] == 0)
                    zeroCount--;
                j++;
            }

            maxLength = Math.max(maxLength, (i - j));
        }

        return maxLength;
    }
}