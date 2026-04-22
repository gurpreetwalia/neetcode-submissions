class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) - 1);

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[j], map.get(nums[j]) - 1);

                if (j > i+1 && nums[j] == nums[j - 1])
                    continue;

                int target = -(nums[i] + nums[j]);

                if (map.getOrDefault(target, 0) > 0) {
                    result.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[j], map.get(nums[j]) + 1);
            }
        }
        return result;
    }
}
