class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 1) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0 )return false;
        }

        return true;
    }
}
