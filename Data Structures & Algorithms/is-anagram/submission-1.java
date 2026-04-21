class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t) && s.length() != 1){
            return false;
        }

        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        while (i < s.length()){
            if (map.containsKey(s.charAt(i))) {
                int currentCount = map.get(s.charAt(i));
                map.put(s.charAt(i), currentCount + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
            i++;
        }

        System.out.println(map);

        i = 0;
        while (i < t.length()){
            if (map.containsKey(t.charAt(i))) {
                int currentCount = map.get(t.charAt(i));
                map.put(t.charAt(i), currentCount - 1);
            }else{
                map.put(t.charAt(i), 1);
            }
            i++;
        }

        System.out.println(map);

        Optional<Integer> nonZeroValue = map.values().stream().filter(e -> e != 0).findFirst();

        return !nonZeroValue.isPresent();
    }
}
