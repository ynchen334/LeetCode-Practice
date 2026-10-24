class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int currChar = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        while (flag == true){
            for (int j=0; j<n-1; ++j){
                if ( currChar >=strs[j].length() || currChar >= strs[j+1].length() || strs[j].charAt(currChar) != strs[j+1].charAt(currChar) ){
                    flag = false;
                    break;
                }
            }
            if (flag == true){
                sb.append(strs[0].charAt(currChar));
                currChar++;
            }
        }
        return sb.toString();
    }
}