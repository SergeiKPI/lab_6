package models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {
    private Trie trie = new Trie();

    @Before
    public void initTrie(){
        trie.insert("test");
        trie.insert("String");
    }

    @Test
    public void insert() throws Exception {
        TrieNode testRoot = trie.root;
        TrieNode testCurent = trie.current;

        trie.insert("testString");

        assertEquals(testRoot, trie.root);
        assertNotEquals(testCurent, trie.current);
    }

    @Test
    public void getSuffixesStartIndices() throws Exception {
        trie.insert("testString");
        int[] correctResult = new int[]{4, 10};
        List<Integer> target = trie.getSuffixesStartIndices("testString");

        for (int i = 0; i < correctResult.length; i++) {
            assertEquals(correctResult[i], (int)target.get(i));
        }
    }

}