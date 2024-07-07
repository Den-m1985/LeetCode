package medium.subrectangle_queries;

import java.util.ArrayList;

class Main {
    /*
    https://leetcode.com/problems/subrectangle-queries/

    1476. Subrectangle Queries
    Implement the class SubrectangleQueries which receives a rows x cols rectangle
    as a matrix of integers in the constructor and supports two methods:
    1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
    Updates all values with newValue in the subrectangle whose upper left coordinate
    is (row1,col1) and bottom right coordinate is (row2,col2).
    2. getValue(int row, int col)
    Returns the current value of the coordinate (row,col) from the rectangle.

    Example 1:
    Input
    ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
    [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
    Output
    [null,1,null,5,5,null,10,5]
    Explanation
    SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
    // The initial rectangle (4x3) looks like:
    // 1 2 1
    // 4 3 4
    // 3 2 1
    // 1 1 1
    subrectangleQueries.getValue(0, 2); // return 1
    subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
    // After this update the rectangle looks like:
    // 5 5 5
    // 5 5 5
    // 5 5 5
    // 5 5 5
    subrectangleQueries.getValue(0, 2); // return 5
    subrectangleQueries.getValue(3, 1); // return 5
    subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
    // After this update the rectangle looks like:
    // 5   5   5
    // 5   5   5
    // 5   5   5
    // 10  10  10
    subrectangleQueries.getValue(3, 1); // return 10
    subrectangleQueries.getValue(0, 2); // return 5

    Example 2:
    Input
    ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
    [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
    Output
    [null,1,null,100,100,null,20]
    Explanation
    SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
    subrectangleQueries.getValue(0, 0); // return 1
    subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
    subrectangleQueries.getValue(0, 0); // return 100
    subrectangleQueries.getValue(2, 2); // return 100
    subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
    subrectangleQueries.getValue(2, 2); // return 20

    Constraints:
    There will be at most 500 operations considering both methods: updateSubrectangle and getValue.
    1 <= rows, cols <= 100
    rows == rectangle.length
    cols == rectangle[i].length
    0 <= row1 <= row2 < rows
    0 <= col1 <= col2 < cols
    1 <= newValue, rectangle[i][j] <= 10^9
    0 <= row < rows
    0 <= col < cols
    */
    public static void main(String[] args) {
        ArrayList<Data> arrayList = fillData();
        for (Data data : arrayList) {
            SubrectangleQueries obj = new SubrectangleQueries(data.rectangle);

            if (data.getValue1 != null) {
                int param_1 = obj.getValue(data.getValue1[0], data.getValue1[1]);
                System.out.println("get value 1: " + check(param_1, data.output1));
            }

            obj.updateSubrectangle(data.updateSubrectangle1[0],
                    data.updateSubrectangle1[1],
                    data.updateSubrectangle1[2],
                    data.updateSubrectangle1[3],
                    data.updateSubrectangle1[4]);

            int param_2 = obj.getValue(data.getValue2[0], data.getValue2[1]);
            System.out.println("get value 2: " + check(param_2, data.output2));
            int param_3 = obj.getValue(data.getValue3[0], data.getValue3[1]);
            System.out.println("get value 3: " + check(param_3, data.output3));

            obj.updateSubrectangle(data.updateSubrectangle2[0],
                    data.updateSubrectangle2[1],
                    data.updateSubrectangle2[2],
                    data.updateSubrectangle2[3],
                    data.updateSubrectangle2[4]);

            int param_4 = obj.getValue(data.getValue4[0], data.getValue4[1]);
            System.out.println("get value 4: " + check(param_4, data.output4));
            if (data.getValue5 != null) {
                int param_5 = obj.getValue(data.getValue5[0], data.getValue5[1]);
                System.out.println("get value 5: " + check(param_5, data.output5));
            }
            System.out.println("***********************************************************");
        }
    }

    static ArrayList<Data> fillData() {
        ArrayList<Data> arrayList = new ArrayList<>();
        Data data1 = new Data();
        // [[1,2,1],
        // [4,3,4],
        // [3,2,1],
        // [1,1,1]]
        data1.setRectangle(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
        //[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
        data1.setGetValue1(new int[]{0, 2});
        data1.setOutput1(1);
        data1.setUpdateSubrectangle1(new int[]{0, 0, 3, 2, 5});
        data1.setGetValue2(new int[]{0, 2});
        data1.setOutput2(5);
        data1.setGetValue3(new int[]{3, 1});
        data1.setOutput3(5);
        data1.setUpdateSubrectangle2(new int[]{3, 0, 3, 2, 10});
        data1.setGetValue4(new int[]{3, 1});
        data1.setOutput4(10);
        data1.setGetValue5(new int[]{0, 2});
        data1.setOutput5(5);
        arrayList.add(data1);

        Data data2 = new Data();
        data2.setRectangle(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}});
        //[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]
        data2.setGetValue1(new int[]{0, 0});
        data2.setOutput1(1);
        data2.setUpdateSubrectangle1(new int[]{0, 0, 2, 2, 100});
        data2.setGetValue2(new int[]{0, 0});
        data2.setOutput2(100);
        data2.setGetValue3(new int[]{2, 2});
        data2.setOutput3(100);
        data2.setUpdateSubrectangle2(new int[]{1, 1, 2, 2, 20});
        data2.setGetValue4(new int[]{2, 2});
        data2.setOutput4(20);
        arrayList.add(data2);

        Data data3 = new Data();
        data3.setRectangle(new int[][]{{2, 8}, {8, 8}, {7, 4}});
        //[1,0],[1,1,1,1,4],[1,0],[0,0],[2,1,2,1,9],[1,1],[1,0]]
        data3.setGetValue1(new int[]{1, 0});
        data3.setOutput1(8);
        data3.setUpdateSubrectangle1(new int[]{1, 1, 1, 1, 4});
        data3.setGetValue2(new int[]{1, 0});
        data3.setOutput2(8);
        data3.setGetValue3(new int[]{0, 0});
        data3.setOutput3(2);
        data3.setUpdateSubrectangle2(new int[]{2, 1, 2, 1, 9});
        data3.setGetValue4(new int[]{1, 1});
        data3.setOutput4(4);
        data3.setGetValue5(new int[]{1, 0});
        data3.setOutput5(8);
        arrayList.add(data3);

        Data data4 = new Data();
        data4.setRectangle(new int[][]{{3, 9, 4}, {5, 6, 10}});
        //["SubrectangleQueries","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
        //[1,1,1,1,5],[1,0],[1,0],[0,0,1,0,6],[1,0],[0,1]
        //data4.setGetValue1(new int[]{1, 0});
        //data4.setOutput1(8);
        data4.setUpdateSubrectangle1(new int[]{1, 1, 1, 1, 5});
        data4.setGetValue2(new int[]{1, 0});
        data4.setOutput2(5);
        data4.setGetValue3(new int[]{1, 0});
        data4.setOutput3(5);
        data4.setUpdateSubrectangle2(new int[]{0, 0, 1, 0, 6});
        data4.setGetValue4(new int[]{1, 0});
        data4.setOutput4(6);
        data4.setGetValue5(new int[]{0, 1});
        data4.setOutput5(9);
        arrayList.add(data4);

        return arrayList;
    }

    static boolean check(int result, int output) {
        return result == output;
    }

}
