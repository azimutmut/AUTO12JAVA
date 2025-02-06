package lesson16.task2;

import org.testng.annotations.Test;

public class Groups {
    @Test(groups = {"first"},priority = 1)
    public void one() {
    }

    @Test(groups = {"second"}, priority = 5)
    public void two() {
    }

    @Test(groups = {"first"}, priority = 2)
    public void thee() {
    }

    @Test(groups = {"second"}, priority = 6)
    public void four() {
    }

    @Test(groups = {"first"}, priority = 3)
    public void five() {
    }

    @Test(groups = {"second"}, priority = 7)
    public void six() {

    }

    @Test(groups = {"first"}, priority = 4)
    public void seven() {

    }
    @Test(groups = {"second"}, priority = 8)
    public void eight() {

    }

}
