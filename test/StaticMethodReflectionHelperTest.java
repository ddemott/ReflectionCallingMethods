import org.junit.Assert;
import org.junit.Test;

public class StaticMethodReflectionHelperTest {
    @Test
    public void callStaticMethodTest() throws Exception {
        Object obj = StaticMethodReflectionHelper.callStaticMethod(TestClass.class, "testMethod", 1);
        Integer actualResultsInteger = (Integer) obj;
        Integer expectedResultInteger = 1;

        Assert.assertEquals(expectedResultInteger, actualResultsInteger);
    }

}
