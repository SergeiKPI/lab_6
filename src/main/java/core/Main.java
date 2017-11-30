package core;

import models.Pair;
import models.Trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final double BYTES_IN_MEGABYTE = 1048576.0;

    public static void main(String[] args) {
        measurePerformances();
    }

    public static void measurePerformances(){
        long startTime;
        long finishTime;
        long measureTimeInNanoSeconds;
        long startMemory;
        long finishMemory;
        long resultMemory;
        double measureTimeInSeconds;
        double resultMBytes;

        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        showResult();
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Time: " + measureTimeInSeconds + " s");
        finishMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Memory: " + resultMBytes + " Mb");
    }

    public static int showResult(){
        File file = new File("words.txt");

        Trie trie = new Trie();
        LinkedList<Pair<String>> queue = new LinkedList<>();

        HashSet<String> compoundWords = new HashSet<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return -1;
        }

        String word;
        List<Integer>suffixeIndices;

        while (scanner.hasNext()){
            word = scanner.next();
            suffixeIndices = trie.getSuffixesStartIndices(word);

            for (int i : suffixeIndices) {
                queue.add(new Pair<String>(word, word.substring(i)));
            }

            trie.insert(word);
        }

        Pair<String> pair;
        int maxLength = 0;
        String longest = "";
        String secondLongest = "";

        while(!queue.isEmpty()){
            pair = queue.removeFirst();
            word = pair.getSecond();

            suffixeIndices = trie.getSuffixesStartIndices(word);

            if(suffixeIndices.isEmpty()){
                continue;
            }

            for (int i : suffixeIndices) {
                if(i == word.length()){
                    if(pair.getFirst().length() > maxLength){
                        secondLongest = longest;
                        maxLength = pair.getFirst().length();
                        longest = pair.getFirst();
                    }

                    compoundWords.add(pair.getFirst());
                }
                else{
                    queue.add(new Pair<String>(pair.getFirst(), word.substring(i)));
                }
            }
        }

        System.out.println("Longest word: " + longest);
        System.out.println("Second longest word: " + secondLongest);
        System.out.println("Total number of compound words: " + compoundWords.size());
        return 0;
    }

    public static double nanoSecondsInSeconds(long nanoSeconds){
        return nanoSeconds*Math.pow(10, -9);
    }

    public static double bytesToMBytes(long bytes){
        return bytes / BYTES_IN_MEGABYTE;
    }
}
