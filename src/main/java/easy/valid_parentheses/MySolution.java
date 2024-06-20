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
        if (s.length() <= 1 || (s.length() % 2) != 0) {
            return false;
        }
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            array.add("" + s.charAt(i));
        }
        if (array.size() == 2) {
            String value = arrayHash.get(array.get(0));
            return array.get(1).equals(value);
        }

        for (int i = 0; i < array.size(); i++) {
            String x = array.get(i);
            if (arrayHash.containsKey(x)) {  // if ( present in arrayHash

                for (Map.Entry<String, String> entryX : arrayHash.entrySet()) {
                    String key = entryX.getKey();
                    if (key.equals(x)) {  // find key
                        String value = entryX.getValue();


                        for (int j = i + 1; j < array.size(); j++) {
                            String y = array.get(j);
                            int lengthBeetwin = j - i;
                            if (value.equals(y) && lengthBeetwin % 2 != 0) {
                                boolean check = isBracketClose(array, arrayHash, array.get(i + 1), i, j);

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
        }
        return true;
    }

    public boolean checkClose(ArrayList<String> array, HashMap<String, String> arrayHash, String key) {
        String value = arrayHash.get(key);
        for (int k = 0; k < array.size(); k++) {
            String temp = array.get(k);
            if (temp.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBracketClose(ArrayList<String> array, HashMap<String, String> arrayHash, String key, int start, int end) {
        String value = arrayHash.get(key);
        for (int k = start; k < end; k++) {
            String temp = array.get(k);
            if (temp.equals(value)) {
                return true;
            }
        }
        return false;
    }

}
