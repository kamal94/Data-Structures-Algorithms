package DataStructures.TrieTree;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * A class that represents a TrieTree used for storing words (strings).
 *
 * Implementation is based on https://www.topcoder.com/community/data-science/data-science-tutorials/using-tries/
 * Created by Kamal on 12/6/15.
 */
public class TrieTree {
    private int prefixes;
    private TreeMap<Character, TrieTree> children;
    private ArrayList<Character> childrenAdded;

    //TODO::make tests for this class
    public TrieTree()
    {
        prefixes = 0;
        children = new TreeMap<>();
        childrenAdded = new ArrayList<>();
    }

    /**
     * Adds a word to this TrieTree.
     *
     * @param s String  The string to be added to the TrieTree
     */
    public void addWord(String s)
    {
        if(s.isEmpty())
            return;
        prefixes++;
        char first = s.charAt(0);
        if(children.containsKey(first))
            children.get(first).addWord(s.substring(1));
        else {
            TrieTree trieTree = new TrieTree();
            trieTree.addWord(s.substring(1));
            children.put(first, trieTree);
        }
        childrenAdded.add(first);
    }


    /**
     * Returns the number of prefixes that the passes string can represent
     * in this Trie. If the string is not in the trie, an exception is thrown.
     * A string match does not count as a prefix count.
     *
     * @param s String  The string in the trie whose prefix count is desired.
     * @return  int     The number of prefixes that this string stands for.
     * @throws StringNotInTrieException Thrown if the passes string is not in the
     *      trie.
     */
    public int getPrefixCount(String s) throws StringNotInTrieException {
        if (s == null)
            return 0;

        if (s.isEmpty()) //base case
            return prefixes;

        char first = s.charAt(0);
        if(childrenAdded.contains(first))
            return children.get(first).getPrefixCount(s.substring(1));
        else
            throw new StringNotInTrieException();
    }

    /**
     * Returns true if the trie contains the passes string, false otherwise.
     *
     * @param s String The string to be found in the trie.
     * @return  boolean true if the trie contains the passed string. False if the
     *      passes string is null or is not in the trie.
     */
    public boolean contains(String s)
    {
        if(s==null)
            return false;

        if(s.isEmpty()) //base case
            return true;

        char first = s.charAt(0);   //find next character
        if(childrenAdded.contains(first))   //if there is a trie for the character
            return children.get(first).contains(s.substring(1));    //search for the rest of the string in that trie
        else
            return false;
    }


    public class StringNotInTrieException extends Exception {}
}
