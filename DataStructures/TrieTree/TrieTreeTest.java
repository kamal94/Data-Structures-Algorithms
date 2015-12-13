package DataStructures.TrieTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kamal on 12/6/15.
 */
public class TrieTreeTest {

    private TrieTree trieTree;

    @Before
    public void createTrie() {
        trieTree = new TrieTree();
        trieTree.addWord("car");
        trieTree.addWord("cat");
        trieTree.addWord("catania");
    }

    @Test
    public void testContains() {
        assertEquals(true, trieTree.contains(""));
        assertEquals(true, trieTree.contains("c"));
        assertEquals(true, trieTree.contains("car"));
        assertEquals(true, trieTree.contains("cat"));
        assertEquals(true, trieTree.contains("catania"));
        assertEquals(false, trieTree.contains("can"));
        assertEquals(false, trieTree.contains("d"));
        assertEquals(false, trieTree.contains("z"));
    }

    @Test
    public void testGetPrefixCount() {
        try {
            assertEquals(3, trieTree.getPrefixCount("c"));
            assertEquals(3, trieTree.getPrefixCount("ca"));
            assertEquals(0, trieTree.getPrefixCount("car"));
            assertEquals(1, trieTree.getPrefixCount("cat"));
            assertEquals(1, trieTree.getPrefixCount("cata"));
            //todo:: test exception throwing
            // assertEquals(new TrieTree.StringNotInTrieException(), trieTree.getPrefixCount("dog"));
        } catch (TrieTree.StringNotInTrieException e) {
            e.printStackTrace();
        }
    }
}