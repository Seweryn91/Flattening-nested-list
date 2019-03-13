import java.util.ArrayList;
import java.util.List;

public class Flattener {

    private List<Object> flat = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public List<Object> flattenRecursively(List<Object> multidimensionalList) {
        for (Object object : multidimensionalList) {
            if (object instanceof List)
            flatten( (List<Object>) object);
            else flat.add(object);
        }
        return flat;
    }

    @SuppressWarnings("unchecked")
    private void flatten(Object o) {
        if (o instanceof List) {
            flatten((List) o);
        }
    }


    private void flatten(List<Object> multidimensionalList) {

        for (Object object : multidimensionalList) {
            if (object instanceof List)
                flatten(object);
            else
                flat.add(object);
        }
    }

}
