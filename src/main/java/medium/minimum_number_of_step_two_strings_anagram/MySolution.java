package medium.minimum_number_of_step_two_strings_anagram;

import java.util.*;

public class MySolution {
    public int minSteps(String s, String t) {
        if (s.length() <= 1) {
            return 0;
        }
        String[] arrS = s.split("");
        String[] arrT = t.split("");
        ArrayList<String> arrayOrigin = new ArrayList<>(List.of(arrT));
        ArrayList<String> b = new ArrayList<>(List.of(arrS));
        for (String v : arrayOrigin) {
            b.remove(v);
        }
        return b.size();
    }

}
