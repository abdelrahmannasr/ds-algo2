import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<String> nodes =  new ArrayList<>();

    public void add(String label) {
        nodes.add(label);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
