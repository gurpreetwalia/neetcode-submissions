class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0){
            return 0;
        }
        int result = 0;
        
        int localSum = 0;
        for(int i=0;i<nums.length-1;i++){
            
            if(nums[i+1] == nums[i] + 1){
                localSum++;
            }else{
                if(nums[i+1] != nums[i]){
                    localSum = 0;
                }
            }

            System.out.print(nums[i] + " " + nums[i+1]);

            result = Math.max(localSum, result);

            System.out.println(" result = " + result + " localSum = " + localSum);
        }
        
        return result+1;
    }
}
