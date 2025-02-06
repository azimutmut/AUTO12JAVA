package lesson16.task2;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class ParallelClass2 {
    @Test
    public void prallel6() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test
    public void prallel7() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test
    public void prallel8() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void prallel9() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void prallel10() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }
}






