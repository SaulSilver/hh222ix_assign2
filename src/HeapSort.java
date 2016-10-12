import java.util.List;

/**
 * A class for performing itemsList heapsort on Item-based list
 * Created by hatem on 2016-10-10.
 */
public class HeapSort {
    private List<Item> itemsList;
    private int n;

    public HeapSort(List<Item> theList) {
        itemsList = theList;
        buildHeap(itemsList);

        for (int i = n; i > 0; i--) {
            swap(0, i);
            n = n - 1;
            maxHeap(itemsList, 0);
        }
    }

    private void buildHeap(List<Item> a) {
        n = a.size() - 1;
        for (int i = n/2; i >= 0; i--)
            maxHeap(a, i);
    }

    /* To create the max heap */
    private void maxHeap(List<Item> a, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest;

        if (left <= n && a.get(left).getTransactionValue() > a.get(i).getTransactionValue())
            largest = left;
        else
            largest = i;

        if (right <= n && a.get(right).getTransactionValue() > a.get(largest).getTransactionValue())
            largest = right;

        if (largest != i) {
            swap(i, largest);
            maxHeap(a, largest);
        }
    }

    /* Swap elements */
    private void swap(int i, int j) {
        Item temp = itemsList.get(i);
        itemsList.set(i, itemsList.get(j));
        itemsList.set(j, temp);
    }
}
