package lesson16.task2;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class ParallelClass1 {
    @Test
    public void prallel1() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test
    public void prallel2() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }
    @Test
    public void prallel3() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void prallel4() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void prallel5() throws InterruptedException  {
        Thread.sleep(2000);
        assertTrue(true);
    }
}






