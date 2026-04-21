class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        while(left <= right && right < s.length()){
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), 1);
                result = Math.max(result, right-left+1);
                right++;
            }else{
                map.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }
}
