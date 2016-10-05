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

    @Override
    public long bubbleSortByTransactionValue(List<Item> array) {
        return 0;
    }

    @Override
    public long quickSortByTransactionValue(List<Item> array) {
        return 0;
    }

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
