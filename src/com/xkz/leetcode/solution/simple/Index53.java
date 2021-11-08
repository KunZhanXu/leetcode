package com.xkz.leetcode.solution.simple;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1:
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2:
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3:
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 4:
 * 输入：nums = [-1]
 * 输出：-1
 *
 * 示例 5:
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 */
public class Index53 {

    public static void main(String[] args) {
        System.out.println(searchInsert1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int searchInsert1(int[] nums) {
        int cur_num = 0;
        int max_num = nums[0];
        for(int num : nums){
            cur_num = Math.max(num,cur_num+num);
            max_num = Math.max(cur_num,max_num);
        }
        return max_num;
    }


}