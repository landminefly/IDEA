package test11_5;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] ints = new int[]{11, 22,22,22,22,22, 33, 44, 55, 66, 77, 88, 99};
        System.out.println(BinarySearch.startSearchAll(ints, 10));
    }
}

class BinarySearch {
    //如果有相同元素，只找一个
    public static int startSearch(int[] arr, int searchedNum) {
        return search(arr, 0, arr.length - 1, searchedNum);
    }
    /**
     * @param left 表示区间起点在原数组中的下标
     * @param right 表示区间终点在原数组的下标
     */
    public static int search(int[] arr, int left, int right, int searchedNum) {
        //如果区间内已经没有元素了，说明找不到，返回-1
        //如果要找的数比数组的最小值更小，或最大值更大，那么肯定找不到，直接返回-1
        if (left > right || searchedNum < arr[0] || searchedNum > arr[arr.length - 1]) {
            return -1;
        }
        //计算区间中间的下标
        int middle = (left + right) / 2;
        if (arr[middle] > searchedNum) {
            //说明要找的数在左半区间，因此向左递归
            return search(arr, left, middle - 1, searchedNum);
        } else if (arr[middle] < searchedNum) {
            //说明要找的数在右半区间，向右递归
            return search(arr, middle + 1, right, searchedNum);
        } else {
            //arr[middle]就是要找的数，结束递归并返回下标
            return middle;
        }
    }

    //如果有相同元素，找到全部
    public static ArrayList<Integer> startSearchAll(int[] arr, int searchNum) {
        return searchAll(arr, 0, arr.length - 1, searchNum);
    }
    public static ArrayList<Integer> searchAll(int[] arr, int left, int right, int searchedNum) {
        if (left > right || searchedNum < arr[0] || searchedNum > arr[arr.length - 1]) {
            return new ArrayList<Integer>();
        }
        int middle = (left + right) / 2;
        if (arr[middle] > searchedNum) {
            return searchAll(arr, left, middle - 1, searchedNum);
        } else if (arr[middle] < searchedNum) {
            return searchAll(arr, middle + 1, right, searchedNum);
        } else {
            //找到后，还要向前后找，找到全部与其相同的元素
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(middle);
            int tempIndex = middle - 1;
            while (tempIndex >= 0 && arr[tempIndex] == searchedNum) {
                nums.add(tempIndex--);
            }
            tempIndex = middle + 1;
            while (tempIndex < arr.length && arr[tempIndex] == searchedNum) {
                nums.add(tempIndex++);
            }
            Collections.sort(nums);
            return nums;
        }
    }
}
