import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlattenerTest {

    @Test
    void testFlattener_notNestedList() {
        Flattener flattener = new Flattener();
        List<Object> testList = createNotNestedList();
        String expected = "[Str1, 1, 2, 3, Str2, 4, 5, 6, Str3, 6, 7, 8]";
        String actual = flattener.flattenRecursively(testList).toString();
        assertEquals(actual, expected);
    }

    @Test
    void testFlattener_nestedList() {
        Flattener flattener = new Flattener();
        List<Object> nestedList = createNestedList();
        String expected = "[Str1, 1, 2, 3, Str2, 4, 5, 6, Str3, 6, 7, 8, This string, 0, is part, 1, of a "+
                "nested list, 9, and this string is not]";
        String actual = flattener.flattenRecursively(nestedList).toString();
        assertEquals(actual, expected);
    }

    private List<Object> createNestedList() {
        List<Object> basicList = createNotNestedList();
        List<Object> nestedList = new ArrayList<>();
        nestedList.add("This string");
        nestedList.add(0);
        nestedList.add("is part");
        nestedList.add(1);
        nestedList.add("of a nested list");
        basicList.add(nestedList);
        basicList.add(9);
        basicList.add("and this string is not");
        return basicList;
    }

    private List<Object> createNestedNestedList() {
        List<Object> superior = new ArrayList<>();
        superior.add("outside string");
        superior.add(0);

        List<Object> medio = new ArrayList<>();
        medio.add("middle string");
        medio.add(1);

        List<Object> inferior = new ArrayList<>();
        inferior.add("inner string");
        inferior.add(2);

        medio.add(inferior);
        superior.add(medio);
        return superior;
    }

    private List<Object> createNotNestedList() {
        List<Object> basicList = new ArrayList<>();
        basicList.add("Str1");
        for (int i = 1; i < 4; i++)
            basicList.add(i);

        basicList.add("Str2");
        for (int i = 4; i < 7; i++)
            basicList.add(i);

        basicList.add("Str3");

        for (int i = 6; i < 9; i++)
            basicList.add(i);

        return basicList;
    }

}