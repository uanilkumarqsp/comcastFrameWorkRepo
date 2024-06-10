package practice.testng;

/**Mutiple DATA providers*/
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CombinedDataProviderTest {

    @Test(dataProvider = "combinedDataProvider")
    public void testWithCombinedDataProviders(String input1, int input2, String input3) {
        System.out.println(input1 + ", " + input2 + ", " + input3);
        // Your test logic here
    }

    @DataProvider(name = "combinedDataProvider")
    public Object[][] combinedDataProvider() {
        Object[][] data1 = dataProvider1();
        Object[][] data2 = dataProvider2();
        Object[][] combinedData = new Object[data1.length + data2.length][];

        int index = 0;
        for (Object[] data : data1) {
            combinedData[index++] = data;
        }
        for (Object[] data : data2) {
            combinedData[index++] = data;
        }

        return combinedData;
    }

    public Object[][] dataProvider1() {
        return new Object[][]{
                {"data1A", 1, "extra1"},
                {"data1B", 2, "extra2"}
        };
    }
    

    public Object[][] dataProvider2() {
        return new Object[][] {
                {"data2A", 3, "extra3"},{"data2B", 4, "extra4"} };
                }
    }
}
        
    


 
