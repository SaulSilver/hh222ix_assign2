import java.util.*;

/**
 *
 * Created by hatem on 2016-10-07.
 */
public class test {
    public static void main(String[] args) {
        Main main = new Main();
        List<Item> items = main.readCSVFile("/input.txt");
        TreeSet treeSet = main.compareAlgorithms(items);
        System.out.println("Algorithms timings:");
        main.printResults(treeSet);

        HashMap hashyMashy = new HashMap();
        for (Item i : items)
            hashyMashy.put(i.getPerformer(), i.hashCode());

        Iterator iterator = hashyMashy.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            System.out.println("Key: " + me.getKey() + ", Value: " + me.getValue());
        }
    }
}
