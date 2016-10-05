package Exercise1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by hatem on 2016-10-05.
 */
public class Item implements A2Item {
    private String performer;
    private double transactionValue;
    private String date;

    public Item(String line) {
        List<String> data = Arrays.asList(line.split(","));
        performer = data.get(0);
        transactionValue = Double.parseDouble(data.get(1));
        date = data.get(2);
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
}
