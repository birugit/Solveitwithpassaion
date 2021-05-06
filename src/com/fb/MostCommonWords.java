package com.fb;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * @author swamy on 1/2/21
 */
public class MostCommonWords {


    public static void main(String[] args) {
        MostCommonWords s = new MostCommonWords();
        //	String paragraph = "L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'" +
        //	"[\"m\",\"i\",\"s\",\"w\",\"y\",\"d\",\"q\",\"l\",\"a\",\"p\",\"n\",\"t\",\"u\",\"b\",\"o\",\"e\",\"f\",\"g\",\"c\",\"x\"]";
        //z is expected output for above input
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";

        //"Bob! [hit]";//"Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = { "hit" };
        String commonWord = s.mostCommonWord(paragraph, banned);
        System.out.println(commonWord);
    }
    /*14 ms
        private String mostCommonwords(String paragraph, String[] banned) {
            Set<String> ban = new HashSet<>(Arrays.asList(banned));
            Map<String, Integer> count = new HashMap<>();
            String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
            for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
            return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
    */
    //2 ms faster
    public String mostCommonWord(String paragraph, String[] banned) {
        Trie root = new Trie();
        Trie node;
        for (String s : banned) {
            node = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.next[idx] == null) node.next[idx] = new Trie();
                node = node.next[idx];
            }
            node.ban = true;
        }
        String res = "";
        int maxCount = 0;
        String par = paragraph.toLowerCase();
        char[] ch = par.toCharArray();
        int len = ch.length;

        for (int i = 0, j = 0; i < len; i = ++j) {
            node = root;
            while (j < len && ch[j] >= 'a' && ch[j] <= 'z') {//skips when empty space or any special character comes
                System.out.println(ch[j]);
                int idx = ch[j] - 'a';
                if (node.next[idx] == null)
                    node.next[idx] = new Trie();
                node = node.next[idx];
                j++;
            }
            if (j > i && !node.ban) {
                if (++node.count > maxCount) {
                    res = par.substring(i, j);
                    maxCount = node.count;
                }
            }
        }
        return res;
    }

    static class Trie {
        private final Trie[] next;
        private int count;
        private boolean ban;

        public Trie() {
            next = new Trie[26];
        }
    }


}
