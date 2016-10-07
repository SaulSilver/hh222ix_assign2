import Exercise1.Item;
import Exercise2.Main;

import java.util.List;

/**
 *
 * Created by hatem on 2016-10-07.
 */
public class test {
    public static void main(String[] args) {
        Main main = new Main();
        List<Item> items = main.readCSVFile("/input.txt");
        long timeSpent = main.quickSortByTransactionValue(items);
        System.out.println(timeSpent + " ns");
    }
}
