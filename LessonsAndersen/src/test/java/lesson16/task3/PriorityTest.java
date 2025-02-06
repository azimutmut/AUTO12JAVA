package lesson16.task3;


import org.testng.annotations.Test;

public class PriorityTest {
    @Test(priority = 3)
    public void a(){

    }

    @Test(priority = 2)
    public void b(){

    }
    @Test(priority = 1)
    public void c(){

    }
    @Test(dependsOnMethods = {"e"})
    public void d(){
//        Assert.fail();
    }

    @Test(dependsOnMethods = {"f"})
    public void e(){

    }

    @Test
    public void f(){

    }


}
