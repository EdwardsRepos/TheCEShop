package com.the_CE_Shop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class The_CE_Shop{
    /**
     * Question 1:
     * Write a function to find and return the second largest number in the array
     * @param nums
     * @return
     * secondlargest
     * @throws Exception
     */
    public static int secondLargestNumQ1(int[] nums) throws Exception {
        //Check the size of the array to determined it can be compared
        if(nums.length < 2){
            throw new Exception("Not allowed to compare arrays with size 1 or less.");
        }
        //Initialize a secondLargest int variable to hold the value of the second largest number in the array
        int secondlargest = 0;
        //count int variable's function is to check if all the elements in the array are equal
        int count = 0;
        //sorting the array in ascending
        Arrays.sort(nums);
        //first loop goes through the array
        for (int i =0; i < nums.length -1; i++) {
            // nested loop goes through the array and has logic to compare 'j' vs 'i' (where 'j' and 'i' are representation of an index in the array)
            for (int j = 0; j < nums.length - 1; j++) {
                //condition to compare if a element at index 'i' is smaller that the last index of the array (since array
                //is sorted last index would be the largest number in the array. This if condition also checks that the current
                // index 'i' is not equal to the largest number in the array (nums.length - 1)
                if (nums[i] < nums[(nums.length - 1)] && nums[i] != nums[(nums.length - 1)]) {
                    // if conditions are true then 'i' is the second largest.
                    secondlargest = nums[i];
                    // another condition to check for equality
                } else if (nums[i] == nums[(nums.length - 1)]) {
                    //if index at 'i' is equal then count goes up by 1
                    count++;
                    //if the value of count is equal to the size of the array, this means all numbers in the array are equal
                    if (count == nums.length){
                        throw new Exception("All numbers in the array are equal");
                    }
                    //if they are not all equal then continue to the next iteration of the nested loop.
                    continue;
                }
            }
        }
        //return the value of the second largest number in the array
        return secondlargest;
    }
    /**
     * * Question 2:
     * Write a function that compares two strings that represents integers and
     * return true if the first number is larger than the second.
     * @param str1
     * @param str2
     * @return
     * @throws Exception
     */
    public static boolean isFirstNumberLargerThanSecond (String str1, String str2) throws Exception {
        //parsing str1 and str2 into int data type. Trim the strings to avoid NumberFormatException
        int num1 = Integer.parseInt(str1.trim());
        int num2 = Integer.parseInt(str2.trim());
        //Condition to compare numbers and also check for equality. In case of equality programs throw an exception.
        if (num1 > num2){
            return true;
        }else if (num2 > num1){
            return false;
        }else{
            throw new Exception("Numbers are equal");
        }

    }
    /**
     * Question3
     * You are given the configuration of a chessboard with some rooks. Write a function that receives the board configuration
     * in a 2D array and returns true if all rooks are safe and false otherwise
     * @param arg0
     * @return
     */
    public static boolean areRooksSafe(int[][] arg0) {
        //loop to iterate throgh 2D array
        for (int row = 0, column = 0; row < 8 && column < 8; row++, column++) {
            //count will represent the number of rooks either in the columns or the rows.
            int count = 0;
            // nested loop to iterate through the rows and compare with index of first loop
            for (int i = 0; i < 8; i++) {
                //if the index at the given row is equal to 1 that would be the position of the rook and we will add 1 to the count
                if (arg0[row][i] == 1) {
                    count++;
                }
                //if count is more than 1 means there is another piece on the board and rook is at risk.
                if (count > 1) {
                    return false;
                }
            }
            // resetting count variable to repeat process through columns
            count = 0;
            // nested loop to iterate through the columns and compare with index of first loop
            for (int i = 0; i < 8; i++) {
                // condition to find the position of the rook
                if (arg0[i][column] == 1) {
                    count++;
                }
                // if count is more than 1 means there is another piece on the board and rook is at risk.
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Question4
     * Write a function that takes in a 2 dimensional array and returns the number of negative numbers.
     * Note: the numbers always increase or stay the same as the array index increases.
     * @param parameter
     * @return
     */
    public static int negNum(int[][] parameter) {
        //count will hold the count for how many  negative nubers are in the 2d array
        int count = 0;
        //length will determine the number of iterations in the nested loop
        int length = parameter.length;
        //loop to iterate trhough the array
        for (int i = 0; i < length; i++) {
            //inner loop to compare index from the first loop against other elements in the 2d array
            for (int j = 0; j < parameter[i].length; j++) {
                //condition to check which elements are less than 0 or negative
                if (parameter[i][j] < 0) {
                    //if condition is met, counter goes up by 1
                    count++;
                } else {
                    //if not, exit and go to the next iteration on the loop
                    break;
                }
            }
        }
        return count;
    }
    /**
     * Question5
     * Write a function that takes in an array of numbers and prints the combinations that add up to 10.
     * @param givenArray
     * @param sum
     * @return
     *
     */
    // this method will return a list of list with integers with possible conbinations that add up to 10
    public List<List<Integer>> combinationThatAddToTen(int[] givenArray, int sum) {
        // empty list to store the list of possible combinations
        List<List<Integer>> combinations = new ArrayList();
        // created a helper or recursive method
        lastPossibleComb(givenArray, 0, sum, new ArrayList(), combinations);
        return combinations;
    }
    /**
     * Recursive helper method. The approach is to
     * @param givenArray
     * @param index
     * @param sum
     * @param list
     * @param result
     */
    public void lastPossibleComb(int[] givenArray, int index, int sum, List<Integer> list, List<List<Integer>> result) {
        //sum represents 10 since we are subtracting givenArray[i] in each recursive call, when sum becomes < 0
        // would mean the current combination is more than 10
        if (sum < 0)
            return;
        // if sum equals to 0  since we are subtracting givenArray[i] in each recursive call,
        // sum == 0 represents the combination adding to 10. then we add current combination to the a new list.
        if (sum == 0)
            result.add(new ArrayList(list));
        //loop through the array and
        for (int i = index; i < givenArray.length; i++) {
            // add current iterarion to the list
            list.add(givenArray[i]);
            //make a recursion call to substract current sum - givenArray[i] to check for sum to == 0
            lastPossibleComb(givenArray, i, sum - givenArray[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        //Q1
        int[] exmpl = new int[4];
        exmpl[0] = 250;
        exmpl[1] = 255;
        exmpl[2] = 257;
        exmpl[3] = 256;
        int secondLargest = secondLargestNumQ1(exmpl);
        System.out.println(secondLargest);
        //Q2
        System.out.println(isFirstNumberLargerThanSecond("1249         ","1239 "));
        //Q3
        int[][] chessInt = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };

        System.out.println(areRooksSafe(chessInt));
        //Q4
        int[][] a = {
                {-4, -4, -1, -1,},
                {-2, -2, -1, -1},
                {-1, 1, 2, 3},
                {1, 2, 3, 4}
        };
        System.out.println(negNum(a));
        //Q5
        int [] combinations = new int [5];
        combinations[0] = 5;
        combinations[1] = 5;
        combinations[2] = 3;
        combinations[3] = 2;
        combinations[4] = 7;
        The_CE_Shop obj = new The_CE_Shop();
        System.out.println(obj.combinationThatAddToTen(combinations,10));
    }
}
