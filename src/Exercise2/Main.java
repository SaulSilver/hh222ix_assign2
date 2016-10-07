package Exercise2;

import Exercise1.Item;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * Created by hatem on 2016-10-05.
 */
public class Main implements A2Main {
    public final long NANO_TO_MILLISECOND = 1000000;
    @Override
    public List<Item> readCSVFile(String filename) {
        List<Item> fileData = new ArrayList<>();
        try {
            String currentLine;
            URL url = this.getClass().getResource(filename);

            BufferedReader fileReader = new BufferedReader(new FileReader(new File(url.toURI())));

            while ((currentLine = fileReader.readLine()) != null)
                fileData.add(new Item(currentLine.trim()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return fileData;
    }

    /** Sort array by transaction value with bubble sort algorithm */
    @Override
    public long bubbleSortByTransactionValue(List<Item> array) {
        long start = System.nanoTime();
        int j;
        boolean flag = true;        //Set flag to true to begin first pass
        Item temp;

        while (flag) {
            flag = false;       //Set flag to false awaiting a possible swap

            for (j = 0; j < array.size()-1; j++) {
                double value1 = array.get(j).getTransactionValue();
                double value2 = array.get(j+1).getTransactionValue();
                if (value1 > value2) {
                    //Swap elements
                    temp = new Item(array.get(j).getPerformer(), value1, array.get(j).getDate());
                    array.set(j, array.get(j+1));
                    array.set(j+1, temp);
                    flag = true;
                }
            }
        }
        return (System.nanoTime() - start);
    }

    /** Sort array by transaction value with quick sort algorithm */
    @Override
    public long quickSortByTransactionValue(List<Item> array) {
        return 0;
    }

    /** Sort array by transaction value with merging sort algorithm, using priority queue and comparator */
    @Override
    public long heapSortByTransactionValue(List<Item> array) {
        return 0;
    }

    @Override
    public TreeSet<Map.Entry<String, Long>> compareAlgorithms(List<Item> array) {
        return null;
    }

    @Override
    public void printResults(TreeSet<Map.Entry<String, Long>> results) {

    }
}
