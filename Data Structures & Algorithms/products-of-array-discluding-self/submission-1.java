class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1){
            return nums;
        }

        int globalSum = 1;
        int zeros = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zeros++;
            }else{
                globalSum *= nums[i];
            }
        }

        if(zeros > 1){
            return new int[nums.length];
        }

        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zeros > 0){
                result[i] = (nums[i] == 0)? globalSum : 0;
            }else{
                result[i] = globalSum/nums[i];
            }
        }

        return result;
    }
}  
