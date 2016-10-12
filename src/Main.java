import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 *
 * Created by hatem on 2016-10-05.
 */
public class Main implements A2Main {
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

    /**
     * Sort array by transaction value with bubble sort algorithm
     */
    @Override
    public long bubbleSortByTransactionValue(List<Item> array) {
        long start = System.nanoTime();
        if (array == null || array.size() == 0)
            return 0;
        int j;
        boolean flag = true;        //Set flag to true to begin first pass
        Item temp;

        while (flag) {
            flag = false;       //Set flag to false awaiting a possible swap

            for (j = 0; j < array.size() - 1; j++) {
                double value1 = array.get(j).getTransactionValue();
                double value2 = array.get(j + 1).getTransactionValue();
                if (value1 < value2) {
                    //Swap elements
                    temp = new Item(array.get(j).getPerformer(), value1, array.get(j).getDate());
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    flag = true;
                }
            }
        }
        return (System.nanoTime() - start);
    }

    /**
     * Sort array by transaction value with quick sort algorithm
     */
    @Override
    public long quickSortByTransactionValue(List<Item> array) {
        long start = System.nanoTime();
        if (array == null || array.size() == 0)
            return 0;
        quicksort(0, array.size() - 1, array);
        return System.nanoTime() - start;
    }

    private void quicksort(int low, int high, List<Item> array) {
        int i = low;
        int j = high;
        double pivot = array.get(low + (high - low) / 2).getTransactionValue();

        while (i <= j) {
            while (array.get(i).getTransactionValue() < pivot)
                i++;
            while (array.get(j).getTransactionValue() > pivot)
                j--;
            if (i <= j) {
                //Exchange values
                Item temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);

                i++;
                j--;
            }
        }
        //recursion step
        if (low < j)
            quicksort(low, j, array);
        if (i < high)
            quicksort(i, high, array);
    }

    /**
     * Sort array by transaction value with merging sort algorithm, using priority queue and comparator
     */
    @Override
    public long heapSortByTransactionValue(List<Item> array) {
        long start = System.nanoTime();

        HeapSort heapSort = new HeapSort(array);

        return System.nanoTime() - start;
    }

    @Override
    public TreeSet<Map.Entry<String, Long>> compareAlgorithms(List<Item> array) {
        long bubbleSort = bubbleSortByTransactionValue(array);
        long quickSort = quickSortByTransactionValue(array);
        long heapSort = heapSortByTransactionValue(array);

        TreeSet<Map.Entry<String, Long>> treeSet = new TreeSet<>();
        treeSet.add(new MyMap("BS", bubbleSort));
        treeSet.add(new MyMap("QS", quickSort));
        treeSet.add(new MyMap("HS", heapSort));


        return treeSet;
    }

    @Override
    public void printResults(TreeSet<Map.Entry<String, Long>> results) {
        for (Map.Entry<String, Long> entry : results)
            System.out.println(entry);
    }

    /**
     * This class implements a custom Comparable for the Map objects that are used for compareAlgorithms(array)
     */
    private class MyMap extends AbstractMap.SimpleEntry<String, Long> implements Comparable<MyMap>{
        private AbstractMap.Entry<String, Long> map;


        public MyMap(String key, Long value) {
            super(key, value);
        }

        @Override
        public int compareTo(MyMap o) {
            return this.getValue().compareTo(o.getValue());
        }
    }
}
