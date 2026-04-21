class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (right + left)/2;
            answer = Math.min(answer, nums[mid]);
            
            if(nums[mid] > nums[right]){
               left = mid + 1; 
            }else{
                right = mid - 1;
            }
        }

        return answer;
    }
}
