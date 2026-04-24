class Solution {
    public int maxVowels(String s, int k) {
        boolean[] isVowel = new boolean[s.length()]; // getting a boolean array for storing the vowel positions
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i); // getting the current character
            if (curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u')
                isVowel[i] = true;
        }

        int maxLength = 0;
        int j = 0, count = 0;
        for (int i = 0; i < isVowel.length; i++) {
            if (isVowel[i])
                count++;

            // if the window length is satisfied
            if ((i - j + 1) == k) {
                maxLength = Math.max(maxLength, count); // updating the max length
                if (isVowel[j])
                    count--; // reducing the count as this becomes already seen
                j++; // incrementing the j pointer
            }
        }

        return maxLength;
    }
}