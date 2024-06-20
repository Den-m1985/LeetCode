package easy.valid_parentheses;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MySolution {
    public boolean isValid(String s) {
        HashMap<String, String> arrayHash = new HashMap<>();
        arrayHash.put("(", ")");
        arrayHash.put("[", "]");
        arrayHash.put("{", "}");
        int length = s.length();
        if (length <= 1 || (length % 2) != 0) {
            return false;
        }
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            array.add("" + s.charAt(i));
        }

        for (int i = 0; i < array.size(); i++) {
            String x = array.get(i);
            if (arrayHash.containsKey(x)) {  // if ( present in arrayHash
                for (Map.Entry<String, String> entryX : arrayHash.entrySet()) {
                    if (entryX.getKey().equals(x)) {  // find key
                        String value = entryX.getValue();
                        for (int j = 1; j < array.size(); j++) {
                            String y = array.get(j);
                            if (value.equals(y) && j%2!=0) {
                                array.set(i, "?");
                                array.set(j, "?");
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (String b : array) {
            if (!b.equals("?")) {
                return false;
            }
            return true;
        }
        return false;
    }

}
