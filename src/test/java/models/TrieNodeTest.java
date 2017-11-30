package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieNodeTest {
    private TrieNode targetTrieNode;

    @Before
    public void initTrieNode(){
        targetTrieNode = new TrieNode();
        targetTrieNode.addChild('w');
    }

    @Test
    public void addChild() throws Exception {
        targetTrieNode.addChild('m');
        assertTrue(targetTrieNode.children.keySet().contains('m'));
    }

    @Test
    public void getChild() throws Exception {
        targetTrieNode.addChild('s');
        TrieNode testResult = targetTrieNode.getChild('s');
        TrieNode nullResult = targetTrieNode.getChild('q');
        assertNotNull(testResult);
        assertNull(nullResult);
    }

    @Test
    public void containsChild() throws Exception {
        assertTrue(targetTrieNode.containsChild('w'));
        assertFalse(targetTrieNode.containsChild('q'));
    }

}