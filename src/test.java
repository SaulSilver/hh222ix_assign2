import Exercise1.Item;
import Exercise2and3.Main;

import java.util.List;
import java.util.TreeSet;

/**
 *
 * Created by hatem on 2016-10-07.
 */
public class test {
    public static void main(String[] args) {
        Main main = new Main();
        List<Item> items = main.readCSVFile("/input.txt");
        TreeSet treeSet = main.compareAlgorithms(items);
        main.printResults(treeSet);
    }
}
