class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(); // storing and modifying the answer
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i); // getting the current index
            if (curr != '*')
                sb.append(curr);
            else {
                sb.deleteCharAt(sb.length() - 1); // remove the last character
            }
        }

        return sb.toString(); // returning the string version
    }
}