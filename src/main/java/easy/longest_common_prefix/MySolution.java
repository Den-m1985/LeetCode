package easy.longest_common_prefix;

import java.util.ArrayList;
import java.util.Comparator;

class MySolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        ArrayList<char[]> array = new ArrayList<>();
        for (String str : strs) {
            if (str.equals("")) {
                return "";
            }
            array.add(str.toCharArray());
        }
        array.sort(Comparator.comparing(o -> o.length));

        StringBuilder result = new StringBuilder();
        int index = 0;
        char[] startArray = array.get(0);
        int indexFolow = 0;
        int repeatLetter = 0;
        while (indexFolow < startArray.length) {
            for (int i = 0; i < array.size(); i++) {
                char[] followArray = array.get(i);
                char i1 = startArray[indexFolow];
                char i2 = followArray[indexFolow];
                if (i1 == i2) {
                    index++;
                    if (index == array.size()) {
                        result.append((i1));
                        repeatLetter++;
                    }
                }
            }
            index = 0;
            indexFolow++;
            if (repeatLetter != indexFolow) {
                return result.toString();
            }
        }
        return result.toString();
    }

}
