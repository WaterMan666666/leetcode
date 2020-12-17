package com.waterman.leetcode.算法.排序;

import java.util.Arrays;

/**
 * @author tongdong
 * @Date: 2020/5/14
 * @Description:
 */
public class ArraysSort {


    public static void main(String[] args) {
        ArraysSort sort = new ArraysSort();
        int[] nums = {5,3,2,1,3,4,1,10,192,8,39};
        sort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] nums){
        if(nums.length == 0){
            return;
        }
        int maxIndex = nums.length - 1;
        while(maxIndex > 0) {
            for (int i = 0; i < maxIndex; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
            maxIndex--;
        }
    }

    /**
     * 插入排序
     */
    public void insertSort(int[] nums){
        if(nums.length == 0){
            return;
        }
       for(int i = 0; i < nums.length; i++){
           int index = i;
           while(index > 0 && nums[index] < nums[index - 1]){
               int temp = nums[index - 1];
               nums[index - 1] = nums[index];
               nums[index--] = temp;
           }
       }
    }

    /**
     * 快速排序
     */
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start , int end){
        if(start > end){
            return;
        }
        int l = start;
        int r = end;
        int base = nums[l];
        while(l < r){
            while(l < r & nums[r] >= base){
                r--;
            }
            nums[l] = nums[r];
            while(l < r & nums[l] <= base){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = base;
        quickSort(nums, start, l - 1);
        quickSort(nums, r + 1, end);
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start , int end){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;
        mergeSort(nums, start,  mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    /**
     * 合并两个有序数组
     */
    private void merge(int[] nums, int start , int mid, int end){
        int index = end - start;
        int[] result = new int[end - start + 1];
        int index1 = mid;
        int index2 = end;
        while(index1 >= start && index2 >= mid + 1 ){
            if(nums[index1] < nums[index2]){
                result[index--] = nums[index2--];
            }else if(nums[index1] > nums[index2]){
                result[index--] = nums[index1--];
            }else{
                result[index--] = nums[index2--];
                result[index--] = nums[index1--];
            }
        }
        if(index1 >= start){
            System.arraycopy(nums,start, result, 0, index1 - start + 1 );
        }
        if(index2 >= mid + 1){
            System.arraycopy(nums, mid + 1, result, 0, index2 - mid );
        }
        System.arraycopy(result, 0, nums, start,end - start + 1);
    }
    /**
     * 堆排序
     */
    public void heapSort(int[] nums){
        //构建堆
        int length = nums.length;
        for(int i = length/2 - 1; i >= 0; i--){
            adjustHeap(nums, i, length - 1);
        }
        for(int i = length - 1 ; i > 0; i--){
            nums[0] = nums[0] ^ nums[i];
            nums[i] = nums[0] ^ nums[i];
            nums[0] = nums[0] ^ nums[i];
            adjustHeap(nums, 0, i);
        }
    }
    /**
     * 调整大顶堆
     */
    private void adjustHeap(int[] nums, int i, int length){
        int base = nums[i];
        for(int k = i * 2 + 1; k < length ; k = k * 2 + 1 ){
            if(k + 1 < length && nums[k] < nums[k + 1]){
                k++;
            }
            if(base < nums[k]){
                nums[i] = nums[k];
                i = k;
            }
        }
        nums[i] = base;
    }

    /**
     * 桶排序
     */
    public void bucketSort(int[] nums){

    }
}
