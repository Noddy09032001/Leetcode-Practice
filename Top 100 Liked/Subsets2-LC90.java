public class Subsets2-LC90{
    public void generate(int index, int[] nums, List<Integer> a, Set<List<Integer>> answer) {
        // base case
        if (index == nums.length) {
            answer.add(new ArrayList<>(a)); // adding the values to the answer list
            return; // returning to the function again
        }

        // pick the index
        a.add(nums[index]);
        generate(index + 1, nums, a, answer);

        a.remove(a.size() - 1); // remove the element at the given index [condition for not picking]
        // do not pick the index
        generate(index + 1, nums, a, answer);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0)
            return Collections.emptyList(); // returning an empty list for the same

        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> a = new ArrayList<>();

        generate(0, nums, a, answer);
        return new ArrayList<>(answer);
    }
}