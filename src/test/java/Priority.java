import org.testng.annotations.Test;

public class Priority {
    @Test(priority = 3)
    public void testA()
    {
        System.out.println("Priority 3");
    }
    @Test(priority = 1)
    public void testB()
    {
        System.out.println("Priority 1");
    }
    @Test(priority = 2)
    public void testC()
    {
        System.out.println("Priority 2");
    }
}