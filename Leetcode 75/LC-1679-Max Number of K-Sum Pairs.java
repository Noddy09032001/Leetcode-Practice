class Solution {
    public int maxOperations(int[] nums, int k) {
        // add them inside the hashmap
        /*Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((k - nums[i]))) {
                count++;
                map.remove(nums[i]); // remove the key for handling duplicates
            }
            map.put(nums[i], 1);
        }

        return count;*/

        // using two pointers
        int i = 0, j = nums.length - 1, count = 0;
        Arrays.sort(nums);
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                count++;
                i++;
                j--;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }

        return count;
    }
}