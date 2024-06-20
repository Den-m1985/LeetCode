package easy.valid_parentheses;

import java.util.ArrayList;

public class Main {
    /*
    Given a string s containing just the characters
    '(', ')', '{', '}', '[' and ']'
    determine if the input string is valid.
    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
     */
    public static void main(String[] args) {
        ArrayList<Data> arrayData = fillArray();

        for (Data data : arrayData) {
            boolean result = new MySolution().isValid(data.input);
            System.out.println("My solution: " + checkResult(result, data.output));
        }

    }

    public static ArrayList<Data> fillArray() {
        ArrayList<Data> arrayData = new ArrayList<>();
        Data data1 = new Data("()", true);
        Data data2 = new Data("()[]{}", true);
        Data data3 = new Data("(]", false);
        Data data4 = new Data("{[]}", true);
        Data data5 = new Data("({)}", false);
        Data data6 = new Data("(){}}{", false);
        arrayData.add(data1);
        arrayData.add(data2);
        arrayData.add(data3);
        arrayData.add(data4);
        arrayData.add(data5);
        arrayData.add(data6);

        return arrayData;
    }

    public static boolean checkResult(boolean strIn, boolean strOut) {
        return strIn == strOut;
    }

}
