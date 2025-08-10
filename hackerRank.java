public class hackerRank {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        String[] subS = new String[s.length()-k+1];
        
        for(int i = 0; i<s.length()-k+1; i++){
            subS[i] = s.substring(i, i+k);
        }

        smallest = subS[0];
        largest = subS[0];
        for (String string : subS) {
            if (string.compareTo(smallest) < 0 ) {
                smallest = string;
            }
            if (string.compareTo(largest) > 0) {
                largest = string;
            }
        }
        
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }
}
