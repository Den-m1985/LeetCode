package easy.valid_parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

class MySolution {
    boolean isValid(String s) {
        HashMap<String, String> arrayHash = new HashMap<>();
        arrayHash.put("(", ")");
        arrayHash.put("[", "]");
        arrayHash.put("{", "}");
        if (s.length() <= 1 || (s.length() % 2) != 0) {
            return false;
        }
        ArrayList<String> array = s.chars()
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.toCollection(ArrayList::new));

        if (array.size() == 2) {
            String value = arrayHash.get(array.get(0));
            return array.get(1).equals(value);
        }

        int countBefor = 0;
        while (array.size() != countBefor) {
            countBefor = array.size();
            findNearestBracket(array, arrayHash, 0, 0);
        }
        return array.size() == 0;
    }

    void findNearestBracket(ArrayList<String> array, HashMap<String, String> arrayHash, int i, int maxRecursionDepth) {
        maxRecursionDepth++;
        if (i >= array.size() - 1 || maxRecursionDepth == 4000) {
            return;
        }
        String key = array.get(i);
        String keyNext = array.get(i + 1);
        if (arrayHash.containsKey(key)) {  // if key contain open bracket?
            String value = arrayHash.get(key);
            if (keyNext.equals(value)) {
                array.remove(i);
                array.remove(i);
                i = 0;
            } else i++;
        } else i++;
        findNearestBracket(array, arrayHash, i, maxRecursionDepth);
    }

}
