package core;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void main() throws Exception {
        Main.main(new String[]{""});
    }

    @Test
    public void measurePerformances() throws Exception {
        Main.measurePerformances();
    }

    @Test
    public void showResult() throws Exception {
        assertEquals(0, Main.showResult());
    }

    @Test
    public void nanoSecondsInSeconds() throws Exception {
        double result = Main.nanoSecondsInSeconds((long)Math.pow(10, 9));
        assertEquals(result, 1 ,0);
    }

    @Test
    public void bytesToMBytes() throws Exception {
        double result = Main.bytesToMBytes(1048576);
        assertEquals(result, 1, 0);
    }

}