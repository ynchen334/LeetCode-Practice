class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        if (strs.length == 0 || strs == null){
            return "";
        }
        for (int i=0; i<strs.length; ++i){
            prefix = longestCommonPrefix(strs[i], prefix);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }
    public String longestCommonPrefix(String a, String b){
        int len = Math.min(a.length(), b.length());
        int index = 0;
        while (index < len && a.charAt(index) == b.charAt(index)){
            index++;
        }
        return a.substring(0, index);
    }
}