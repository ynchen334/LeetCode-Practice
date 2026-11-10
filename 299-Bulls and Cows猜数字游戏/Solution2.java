class Solution2 {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int n = secret.length();
        ArrayList<Character> nums = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            nums.add(secret.charAt(i));
        }

        for (int i = 0; i < n; ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
                nums.remove((Character) guess.charAt(i));
            }
        }

        for (int i = 0; i < n; ++i) {
            if (secret.charAt(i) != guess.charAt(i)
                    && nums.contains(guess.charAt(i))) {
                b++;
                nums.remove((Character) guess.charAt(i));
            }
        }

        return Integer.toString(a) + 'A' + Integer.toString(b) + 'B';
    }
}