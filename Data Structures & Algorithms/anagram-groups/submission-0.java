class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] strArr = s.toCharArray();
            Arrays.sort(strArr);
            String sorted = new String(strArr);

            if(!map.containsKey(sorted)){
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(sorted, value);
            }else{
                map.get(sorted).add(s);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
