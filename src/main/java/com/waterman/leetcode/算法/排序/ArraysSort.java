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
        nums = sort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     */
    public int[] quickSort(int[] nums){
        if(nums.length <= 1){
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left,int right){
        if(left >= right){
            return;
        }
        int l = left;
        int r = right;
        //基准值
        int base = nums[left];
        while(l < r){
            while(l < r && nums[r] >= base){
                r--;
            }
            if(l < r){
                nums[l] = nums[r];
                l++;
            }
            while(l < r && nums[l] < base){
                l++;
            }
            if(l < r){
                nums[r] = nums[l];
                r--;
            }
        }
        //基准值归位
        nums[l] = base;
        //递归：左
        quickSort(nums,left, l -1);
        //递归：右
        quickSort(nums,l+1, right);
    }

    /**
     * 归并排序
     */
    public int[] mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void mergeSort(int[] nums,int left, int right){
        if(left == right){
            return ;
        }
        int mid = getMid(left, right);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int l = left;
        int r = mid + 1;
        int[] result = new int[right - left + 1];
        int index = 0;
        while(l <= mid && r <= right){
            if(nums[l] < nums[r]){
                result[index++] = nums[l++];
            }else{
                result[index++] = nums[r++];
            }
        }
        while(l <= mid){
            result[index++] = nums[l++];
        }
        while(r <= right){
            result[index++] = nums[r++];
        }
        System.arraycopy(result, 0, nums, left, result.length);

    }
    private int getMid(int i,int j){
        return (i + j)/2;
    }
}
