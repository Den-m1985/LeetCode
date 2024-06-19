package easy.longest_common_prefix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MySolution {
    /*
    Input: strs = ["flower","flow","flight"]
        Output: "fl"
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }

        ArrayList<char[]> array = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            array.add(strs[i].toCharArray());
        }
        array.sort(Comparator.comparing(o -> o.length));
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int i = 0; i < array.size(); i++) {
            char[] exI = array.get(i);
            char symbolIndex = array.get(i)[i];
            for (int j = 1; j < array.size(); j++) {
                char[] exJ = array.get(j);
                char symbolIndexJ = array.get(j)[i];
                if (symbolIndex == symbolIndexJ) {
                    index++;
                    if (index == 0){
                        result.append(symbolIndex);
                    }
                }
            }
            index =0;


//            for (char symbol : array.get(i)) {
//                if (symbol == first[i-1]) {
//                    result.append(symbol);
//                }
//            }
        }
        return result.toString();
    }

}
