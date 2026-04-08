public class SortColors{
    // code for swapping of the two numbers
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        /*int zeroCount = 0, oneCount = 0, twoCount = 0;

        // getting the count of the ones and the zeroes and the twos
        for (int x : nums) {
            if (x == 0)
                zeroCount++;
            else if (x == 1)
                oneCount++;
            else
                twoCount++;
        }

        int k = 0;
        for (int i = 0; i < zeroCount; i++) {
            nums[k++] = 0;
        }

        for (int i = 0; i < oneCount; i++) {
            nums[k++] = 1;
        }

        for (int i = 0; i < twoCount; i++) {
            nums[k++] = 2;
        } */

        // two pointers approach using a single pass solution

        /*

        the idea is that 2 should go to the end and 0 should go to the beginning
        so if the current number is 2 make it go to end
        if the current number is 0 make it come to the start

        */

        int p1 = 0, p2 = 0, p3 = nums.length - 1;
        while (p2 <= p3) {
            if (nums[p2] == 2) {
                swap(nums, p2, p3);
                p3--;
            } else if (nums[p2] == 0) {
                swap(nums, p2, p1);
                p2++;
                p1++;
            } else
                p2++;
        }
    }
}