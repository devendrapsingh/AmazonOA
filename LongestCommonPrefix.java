package InterviewProblems.AmazonInterviewProblems.AmazonOA;


//https://binarysearch.com/problems/Longest-Common-Prefix
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String [] words = {"ab", "ad"};
        Trie root = new Trie();
        for(String s: words){
            insert(s,root);
        }
        System.out.println(longestCommonPrefix(root,words[0],words.length));

    }

    static class Trie {
        Trie[] child;
        int count;

        public Trie() {
            child = new Trie[26];
        }
    }

    static void insert(String s, Trie root) {
        Trie p = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (p.child[i] == null)
                p.child[i] = new Trie();

            p = p.child[i];
            p.count++;

        }
    }

    static public String longestCommonPrefix(Trie root, String s, int n) {
        Trie p = root;
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (p.child[i] != null) {
                p = p.child[i];
                if(p.count==n)
                    str.append(c);
                else
                    break;
            }else
                break;
        }
        return str.toString();

    }


}
