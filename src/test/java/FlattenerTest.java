import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlattenerTest {


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