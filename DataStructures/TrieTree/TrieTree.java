package DataStructures.TrieTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * A class that represents a TrieTree used for storing words (strings).
 *
 * Created by Kamal on 12/6/15.
 */
public class TrieTree {
    public final int LETTER_COUNT = 26;
    private int words;
    private int prefixes;
    private TreeMap<Character, TrieTree> children;
    private ArrayList<Character> childrenAdded;

    public TrieTree()
    {
        words = 0;
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
            words++;
        else {
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
    }

    public int getWordsCount()
    {
        return words;
    }

    /**
     * Returns the number of prefixes this Trie contains
     * @return
     */
    public int getPrefixCount()
    {
        int count = 0;
        for(Character c: childrenAdded)
            count += children.get(c).getWordsCount();
        return count;

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


}
