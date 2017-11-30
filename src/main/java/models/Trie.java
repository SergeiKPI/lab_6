package models;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    public TrieNode root;
    public TrieNode current;

    public Trie() {
        root = new TrieNode();
        current = root;
    }

    public void insert(String string){
        char letter;
        current = root;

        for (int i = 0; i < string.length(); i++){
            letter = string.charAt(i);

            if(!current.containsChild(letter)){
                current.addChild(letter);
            }

            current = current.getChild(letter);
        }

        current.isWord = true;
    }

    public List<Integer> getSuffixesStartIndices(String string){
        List<Integer> indicies = new LinkedList<>();
        char letter;
        current = root;

        for (int i = 0; i < string.length(); i++) {
            letter = string.charAt(i);
            if(!current.containsChild(letter)){
                return indicies;
            }
            current = current.getChild(letter);
            if(current.isWord){
                indicies.add(i + 1);
            }
        }

        return indicies;
    }
}
