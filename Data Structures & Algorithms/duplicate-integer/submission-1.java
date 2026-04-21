class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i =0; i< nums.length; i++){
            if (countMap.containsKey(nums[i])){
                Integer currentCount = Integer.valueOf(0);
                currentCount = countMap.get(nums[i]);
                Integer currentKey = Integer.valueOf(nums[i]);
                countMap.put(currentKey,currentCount + 1);
            }else{
                countMap.put(nums[i], Integer.valueOf(0));
            }
        }

        Optional<Integer> duplicateValue = countMap.values().stream().filter(v -> v > 0).findFirst();

        return duplicateValue.isPresent();
    }
}
