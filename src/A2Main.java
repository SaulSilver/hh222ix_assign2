import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface A2Main {
	public List<Item> readCSVFile(String filename);

	/** Sort array by transaction value with bubble sort algorithm */
	public long bubbleSortByTransactionValue(List<Item> array);

	/** Sort array by transaction value with quick sort algorithm */
	public long quickSortByTransactionValue(List<Item> array);

	/** Sort array by transaction value with merging sort algorithm, using priority queue and comparator */
	public long heapSortByTransactionValue(List<Item> array);

	public TreeSet<Map.Entry<String, Long>> compareAlgorithms(List<Item> array);

	public void printResults(TreeSet<Map.Entry<String, Long>> results);
}
