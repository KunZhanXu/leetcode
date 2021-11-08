package com.xkz.leetcode.solution.simple;

/**
 * 35.搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 *
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 *
 *
 */
public class Index35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert2(nums,7));
    }

    /**
     * 自解
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int index = 0;
        int length = nums.length;
        boolean isContain = false;
        for (int i =0; i<length; i++){
            if (nums[i] == target){
                isContain = true;
                index = i;
            }
        }
        if (!isContain){
            if (nums[0]>target){
                return 0;
            }
            if (nums[length-1]<target){
                return length;
            }
            for (int i =0; i<length-1; i++){
                if (nums[i] < target && target < nums[i+1]){
                    index = i+1;
                }
            }
        }
        return index;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
        int mid = 0;
        int ans = length;
        while(left<=right){
            mid = (left+right)/2;
            if (target<=nums[mid]){
                ans = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }


}
