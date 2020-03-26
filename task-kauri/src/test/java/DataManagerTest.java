import com.andrey.DataManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class DataManagerTest {

    DataManager dataManager = new DataManager();

    @Test
    public void encodeDataTest() {
        List<String> actual = new LinkedList<>();
        actual.add("00000001"); //длина равна 1
        List<String> expected = dataManager.encodeData(1);
        Assertions.assertEquals(expected,actual);

        actual.clear();
        expected.clear();
        actual.add("01111111"); // длина равна 127
        expected = dataManager.encodeData(127);
        Assertions.assertEquals(expected,actual);

        actual.clear();
        expected.clear();
        actual.add("10000010");
        actual.add("10000001");
        actual.add("00001110");
        expected = dataManager.encodeData(270);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void decodeDataTest() {
        long actual = 2;
        List<String> list = new LinkedList<>();
        list.add("00000010");
        long expected = dataManager.decodeData(list);
        Assertions.assertEquals(expected,actual);

        list.clear();
        actual = 280;
        list.add("10000010");
        list.add("10000001");
        list.add("11000");
        expected = dataManager.decodeData(list);
        Assertions.assertEquals(expected,actual);
    }
}
