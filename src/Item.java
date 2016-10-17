import java.util.Comparator;

/**
 *
 * Created by hatem on 2016-10-05.
 */
public class Item implements A2Item{
    private String performer;
    private double transactionValue;
    private String date;

    public Item(String line) {
        String[] data = line.split(",");
        performer = data[0];
        transactionValue = Double.parseDouble(data[1]);
        date = data[2];
    }

    public Item(String perf, double transactionVal, String date) {
        performer = perf;
        transactionValue = transactionVal;
        this.date = date;
    }

    @Override
    public String getPerformer() {
        return performer;
    }

    @Override
    public double getTransactionValue() {
        return transactionValue;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setPerformer(String name) {
        performer = name;
    }

    @Override
    public void setTransactionValue(double value) {
        transactionValue = value;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        return 53 * hash + performer.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass())
            return false;
        return this.hashCode() == other.hashCode();
    }
}
