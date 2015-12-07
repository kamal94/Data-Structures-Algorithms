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
    }
    @Test
    public void testAddWord() throws Exception {
        trieTree.addWord("hi");
//        assertEquals();
    }
}