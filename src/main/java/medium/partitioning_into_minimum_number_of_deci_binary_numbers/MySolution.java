package medium.partitioning_into_minimum_number_of_deci_binary_numbers;

import java.util.ArrayList;
import java.util.Collections;

public class MySolution {
    public int minPartitions(String n) {
        int count;
        String[] strArray = n.split("");
        ArrayList<Integer> array = new ArrayList<>();
        for (String s : strArray) {
            array.add(Integer.parseInt(s));
        }
        Collections.sort(array);
        count = array.get(array.size() - 1);
        return count;
    }

}
