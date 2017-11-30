package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {
    private Pair<String> testPair;

    @Before
    public void initPair(){
        testPair = new Pair<>("one", "two");
    }

    @Test
    public void getFirst() throws Exception {
        assertEquals("one", testPair.getFirst());
    }

    @Test
    public void getSecond() throws Exception {
        assertEquals("two", testPair.getSecond());
    }

}