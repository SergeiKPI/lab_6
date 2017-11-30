package models;

import java.util.HashMap;

public class TrieNode{
    public HashMap<Character, TrieNode> children;

    public boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addChild(char child){
        children.put(child, new TrieNode());
    }

    public TrieNode getChild(char child){
        if(!children.keySet().contains(child)){
            return null;
        }

        return children.get(child);
    }

    public boolean containsChild(char child){
        return children.keySet().contains(child);
    }
}
